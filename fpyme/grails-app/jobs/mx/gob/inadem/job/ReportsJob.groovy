package mx.gob.inadem.job

import mx.gob.inadem.*
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.quartz.Job;
import org.quartz.JobKey;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


class ReportsJob implements org.quartz.Job {


    public void execute(JobExecutionContext context) throws JobExecutionException{
        def grailsApplication = org.codehaus.groovy.grails.commons.ApplicationHolder.getApplication()
        def developerService = grailsApplication.mainContext.getBean("developerService")
        def schedulerService = grailsApplication.mainContext.getBean("schedulerService")
        def jmsService = grailsApplication.mainContext.getBean("jmsService")

        JobKey key = context.getJobDetail().getKey()
        JobDataMap dataMap = context.getJobDetail().getJobDataMap()
				println dataMap
        def name = dataMap.getString("name")
        JobLog log = JobLog.findByName(name)

        if(!log) {
          println "Log $name doesnt exist!"
          return
        }

        if(!schedulerService.isLeader()) {
          println "Trying to execute $name but we are not the leader"
          return
        }

        String query = log.body
        String to = log.to
        String language = log.language
        try{
            def result = null
            def mailMessage
            if(language == "sql"){
                result = developerService.jobExecuteQuery(query)
                mailMessage = [
                        'applicantMail': "ADMIN",
                        'key': 'REPORTE',
                        'to': to,
                        'title': key.getName(),
                        //'text':buildHtmlTable(result.result,result.columns)
                        // 'text':buildCsvText(result.result,result.columns)
                        'xlsx': buildXlsxFile(result.result, result.columns)
                ] as Map
            } else if(log.parseCsv) {
                result = developerService.jobExecuteScript(query)
                mailMessage = [
                        'applicantMail': "ADMIN",
                        'key': 'REPORTE',
                        'to': to,
                        'title': key.getName(),
                        'xlsx': buildXlsxFile(result.output)
                ] as Map
            } else {
                result = developerService.jobExecuteScript(query)
                mailMessage = [
                        'applicantMail': "ADMIN",
                        'key': 'REPORTE',
                        'to': to,
                        'title': key.getName(),
                        'text': result.output
                ] as Map
            }
            jmsService.send("jms/jobMailerQueue", mailMessage)

        }catch(Exception ex){
           println ex.getMessage()
           println ex.getStackTrace()
           println "Error al ejecutar el job"
        }
    }

    def buildHtmlTable(def result, def columns){
        def htmlTable = "<table>" +
                "<thead>"
        columns.each{
            htmlTable += "<th>$it</th>"
        }
        htmlTable += "</thead><tbody>"
        result.each{ row->
            htmlTable += "<tr>"
            row.each{k, v ->
                htmlTable += "<td>$v</td>"
            }
            htmlTable +="</tr>"
        }
        htmlTable+= "</tbody></table>"
        htmlTable
    }

    def buildCsvText(def result, def columns){
        def csvText = ""
        csvText = columns.join(",")
        csvText += "\n"
        result.each{ row->
            def vals = row.collect{ k, v ->
                v
            }
            csvText += vals.join(",")
            csvText += "\n"
        }
        csvText
    }

    def buildXlsxFile(def text) {
        def rownum = 0
        SXSSFWorkbook wb = new SXSSFWorkbook(100)
        Sheet sh = wb.createSheet();
        Row row = sh.createRow(rownum);
        def columnCount = 0
        def cellnum = 0
        text.eachLine { r ->
          row = sh.createRow(rownum);
          cellnum = 0
          def columns = r.split("\\|")
          if(columns.size() > columnCount) {
            columnCount = columns.size()
          }
          columns.each {
            Cell cell = row.createCell(cellnum);
            cell.setCellValue(it);
            cellnum += 1
          }
          rownum += 1
        }
        (0..columnCount-1).each {
          sh.autoSizeColumn(it)
        }
        def tmpFile = File.createTempFile("report", ".tmp")
        FileOutputStream out = new FileOutputStream(tmpFile)
        wb.write(out)
        out.close()

        wb.dispose()
        tmpFile.getAbsolutePath()
    }

    def buildXlsxFile(def result, def columns) {
        def rownum = 0
        SXSSFWorkbook wb = new SXSSFWorkbook(100)
        Sheet sh = wb.createSheet();
        Row row = sh.createRow(rownum);
        def cellnum = 0
        def columnCount = columns.size()
        columns.each {
            Cell cell = row.createCell(cellnum);
            cell.setCellValue(it);
            cellnum += 1
        }
        rownum += 1
        result.each { r ->
          row = sh.createRow(rownum);
          cellnum = 0
          columns.each {
            Cell cell = row.createCell(cellnum);
            cell.setCellValue(r[it]);
            cellnum += 1
          }
          rownum += 1
        }
        (0..columnCount-1).each {
          sh.autoSizeColumn(it)
        }
        def tmpFile = File.createTempFile("report", ".tmp")
        FileOutputStream out = new FileOutputStream(tmpFile)
        wb.write(out)
        out.close()

        wb.dispose()
        tmpFile.getAbsolutePath()
    }
}
