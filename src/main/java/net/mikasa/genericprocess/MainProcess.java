package net.mikasa.genericprocess;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.logging.log4j.*;
import org.joda.time.Period;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProcess 
{
	static final Logger log = LogManager.getLogger(MainProcess.class.getName());
	private static ApplicationContext context;
	
	public static void main(String[] args)
	{
		
		Date start = new Date();
		//Load Spring context
		context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml","classpath:net/sf/appinfo/appInfoDefaultContext.xml");
		String appInfoText = context.getBean("appInfoText", String.class);
		log.info("###########################################################################################################");
		log.info("# Main Process                                                                                            #");
		log.info("# Version: " + appInfoText + " #");
		log.info("# Process start date: " + start.toString() + "                                                       #");
		log.info("###########################################################################################################");
		
		//Main Process
		log.info("Main process start");
		
		try
		{
			log.info("Reading configuration file:");
			Configuration config = new PropertiesConfiguration("config.properties");
			
			Map<String,String> mProperties = new HashMap<String, String>();
			Iterator<String> it = config.getKeys();
			while(it.hasNext())
			{
				String key = it.next();
				String value = config.getString(key);
				mProperties.put(key, value);
				log.info("Loaded " + key + " = " + value);
			}
			log.info("Read " + mProperties.size() + " configuration properties");
		}
		catch(Exception e)
		{
			log.error("Main process error: " + e);
		}
		
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
