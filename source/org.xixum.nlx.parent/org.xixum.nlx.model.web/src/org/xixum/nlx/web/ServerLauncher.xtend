/*
 * generated by Xtext 2.16.0
 */
package org.xixum.nlx.web

import java.net.InetSocketAddress
import org.eclipse.jetty.annotations.AnnotationConfiguration
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.util.log.Slf4jLog
import org.eclipse.jetty.webapp.MetaInfConfiguration
import org.eclipse.jetty.webapp.WebAppContext
import org.eclipse.jetty.webapp.WebInfConfiguration
import org.eclipse.jetty.webapp.WebXmlConfiguration

/**
 * This program starts an HTTP server for testing the web integration of your DSL.
 * Just execute it and point a web browser to http://localhost:8080/
 */
class ServerLauncher {
	def static void main(String[] args) {
		val server = new Server(new InetSocketAddress('localhost', 8080))
		server.handler = new WebAppContext => [
			resourceBase = 'WebRoot'
			welcomeFiles = #["index.html"]
			contextPath = "/"
			configurations = #[
				new AnnotationConfiguration,
				new WebXmlConfiguration,
				new WebInfConfiguration,
				new MetaInfConfiguration
			]
			setAttribute(WebInfConfiguration.CONTAINER_JAR_PATTERN, '.*/org\\.xixum\\.nlx\\.model\\.web/.*,.*\\.jar')
			setInitParameter("org.mortbay.jetty.servlet.Default.useFileMappedBuffer", "false")
		]
		val log = new Slf4jLog(ServerLauncher.name)
		try {
			server.start
			log.info('Server started ' + server.getURI + '...')
			new Thread[
				log.info('Press enter to stop the server...')
				val key = System.in.read
				if (key != -1) {
					server.stop
				} else {
					log.warn('Console input is not available. In order to stop the server, you need to cancel process manually.')
				}
			].start
			server.join
		} catch (Exception exception) {
			log.warn(exception.message)
			System.exit(1)
		}
	}
}
