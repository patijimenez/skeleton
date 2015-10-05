package mx.gob.inadem.freemarker

import freemarker.cache.TemplateLoader
import mx.gob.inadem.*
import java.io.Reader

class InademTemplateLoader implements TemplateLoader {

		Reader getReader(Object templateSource, String encoding) {
			return new StringReader(templateSource.body)
		}

		long getLastModified(Object templateSource) {
			if(templateSource.lastUpdated == null) {
				templateSource.dateCreated.time
			} else {
				templateSource.lastUpdated.time
			}
		}

		Object findTemplateSource(String name) {
			return MailTemplate.findByKey(name)
		}

		void closeTemplateSource(Object templateSource) {
		}

}
