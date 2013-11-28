package tianci.qixiang.henan.utils.ftp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ftpserver.FtpServer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class MyServletContextListener implements ServletContextListener {

	public static final String FTPSERVER_CONTEXT_NAME = "org.apache.ftpserver";

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("Stopping FtpServer");
		// 停止FTP server
		FtpServer server = (FtpServer) sce.getServletContext().getAttribute(
				FTPSERVER_CONTEXT_NAME);

		if (server != null) {
			server.stop();

			sce.getServletContext().removeAttribute(FTPSERVER_CONTEXT_NAME);

			System.out.println("FtpServer stopped");
		} else {
			System.out.println("No running FtpServer found");
		}

	}

	// 容器初始化
	public void contextInitialized(ServletContextEvent sce) {
		/* 在此如不希望容器启动里就开启FTPserver而是希望在页面通过手动开启 */
		System.out.println("Starting FtpServer");

		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(sce.getServletContext());

		FtpServer server = (FtpServer) ctx.getBean("myServer");

		sce.getServletContext().setAttribute(FTPSERVER_CONTEXT_NAME, server);

		try {
			server.start();
			System.out.println("FtpServer started");
		} catch (Exception e) {
			throw new RuntimeException("Failed to start FtpServer", e);
		}
	}
}
