package mx.com.mschool.service

import grails.plugin.jms.*
import mx.com.mschool.*
import org.springframework.core.io.ClassPathResource
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.FileWriter;
import java.io.IOException;

class MailerService {
		static exposes = ["jms"]

		def mailService
		def freemarkerConfiguration

	@Queue(name="jms/mailerQueue")
    def sendMail(msg) {
			def mt = MailTemplate.findByKey(msg.key)
			def t = freemarkerConfiguration.getTemplate(msg.key)
			def writer = new StringWriter()
			t.process(msg, writer)
			writer.flush()

			def header = new ClassPathResource('/mails/header.png')
			def wideHeader = new ClassPathResource('/mails/wideHeader.png')
			def objective = new ClassPathResource('/mails/objective.png')
			def text = writer.toString()
      def toName = ""
      def title

      if(msg.toName) {
        toName = msg.toName.replaceAll("\"", "").replaceAll(",", "")
      }

      if(msg.title) {
        title = msg.title
      } else {
        title = mt.title
      }

      mailService.sendMail {
				multipart true
				to "${toName} <${msg.to}>"
				from "${mt.fromAlias} <${mt.fromMail}>"
				subject title
        if(mt.bccs){
          bcc mt.bccs as String[]
        }
				if(text.contains('cid:header')) {
          inline 'header', 'image/png', header
        }
				if(text.contains('cid:wideHeader')) {
          inline 'wideHeader', 'image/png', wideHeader
        }
				if(text.contains('cid:objective')) {
					inline 'objective', 'image/png', objective
				}
				html text
			}

			log.info("Mensaje enviado")
    }

    @Queue(name="jms/jobMailerQueue")
    def sendJobMail(msg) {
        def mt = MailTemplate.findByKey(msg.key)
        def header = new ClassPathResource('/mails/header.png')
        def wideHeader = new ClassPathResource('/mails/wideHeader.png')
        def objective = new ClassPathResource('/mails/objective.png')

        if(msg.text) {
          def text = msg.text
          def toList = msg.to?.split(",")
          def filename = msg.filename ? msg.filename.replaceAll("[^\\x00-\\x7F]", "") : msg.title.replaceAll("[^\\x00-\\x7F]", "") + ".csv"
          def body = "Reporte $msg.title\n".toString()
          //createCsvFile(text, msg.title)

          mailService.sendMail {
              multipart true
              to toList as String[]
              from "${mt.fromAlias} <${mt.fromMail}>"
              subject msg.title
              if(mt.bccs){
                bcc mt.bccs as String[]
              }
              html body
              attach filename, "text/plain", text as byte[]
          }
        } else {
          def text = msg.text
          def toList = msg.to?.split(",")
          def body = "Reporte" + msg.title
          def filename = msg.title.replaceAll("[^\\x00-\\x7F]", "") + ".xlsx"
          def f = new File(msg.xlsx)
          //createCsvFile(text, msg.title)

          mailService.sendMail {
              multipart true
              to toList as String[]
              from "${mt.fromAlias} <${mt.fromMail}>"
              subject msg.title
              if(mt.bccs){
                bcc mt.bccs as String[]
              }
              html body
              attach filename, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", f
          }
          f.delete()
        }



        log.info("Mensaje enviado")
    }

    def createCsvFile(def text, def filename){
        //create a temp file
        try{
            File temp = File.createTempFile(filename, ".csv")
            FileWriter fw = new FileWriter(temp.getAbsoluteFile())
            BufferedWriter bw = new BufferedWriter(fw)
            bw.write(text)
            bw.close()
            def path = Paths.get(temp.getAbsolutePath())
            byte[] data = Files.readAllBytes(path)
            println data.size()
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
