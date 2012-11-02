package net.mikasa.genericprocess;

import java.util.Date;

import org.apache.log4j.Logger;
import org.joda.time.Period;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProcess 
{
	protected static final Logger log = Logger.getLogger(MainProcess.class);
	private static ApplicationContext context;
	
	public static void main(String[] args)
	{
		
		Date start = new Date();
		//Load Spring context
		context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml","classpath:net/sf/appinfo/appInfoDefaultContext.xml");
		String appInfoText = context.getBean("appInfoText", String.class);
		log.info("################################################################################");
		log.info("# Main Process                                                                 #");
		log.info("# Version: " + appInfoText);
		log.info("# Process start date: " + start.toString() + "                             #");
		log.info("################################################################################");
		
		//Main Process
		log.info("Main process start");
		
		Date end = new Date();
		Period period = new Period(start.getTime(), end.getTime());
		log.info("################################################################################");
		log.info("# Process result: OK                                                           #");		
		log.info("# Time elapsed: " +  String.format("%02d:%02d:%02d",period.getHours(), period.getMinutes(), period.getSeconds()) + "                                                       #");
		log.info("################################################################################");		
		log.info("All done");
		System.exit(0);		
		
	}
}
