package com.hibernate.employeeManagement;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class EmployeeManagementApplication 
{
	private static final Logger log = LoggerFactory.getLogger(EmployeeManagementApplication.class);
	public static void main(String[] args) 
	{
		SpringApplication app = new SpringApplication(EmployeeManagementApplication.class);
		Environment env = app.run(args).getEnvironment();
		logApplicationStartup(env);
	}

	private static void logApplicationStartup(Environment env)
	{
		String serverPort = env.getProperty("server.port");
		String contextPath = env.getProperty("server.servlet.context-path");
		contextPath = "/";
		String protocol = "http";
		String hostAddress = "localhost";
		try 
		{
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} 
		catch (UnknownHostException e) 
		{
			log.warn("The host name could not be determined, using `localhost` as fallback");
		}
		log.info("\n----------------------------------------------------------\n\t" +
				"Application is running! Access URLs:\n\t" +
				"Local: \t\t{}://localhost:{}{}\n\t" +
				"External: \t{}://{}:{}{}\n\t" +
				"\n----------------------------------------------------------",
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath);
	}

}
