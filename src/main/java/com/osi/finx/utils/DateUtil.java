package com.osi.finx.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

	
	public static String getWeekStartDate(String selectedDate) throws Exception {
		LOGGER.debug("DateUtil :: getWeekStartDate :: START");
		
		DateTime startDate = null;
		
		try {
			 startDate = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(selectedDate);

			  int i=0;
			  while(i<6)
			  {
				  startDate = startDate.minusDays(1);
			      if(startDate.getDayOfWeek()<=5)
			      {
			          i++;
			      }

			  }
			  
		} catch (Exception e) {
			LOGGER.error("OsiDateUtil :: getWeekStartDate() :: ERROR :: ", e);
			throw e;
		}
		LOGGER.debug("OsiDateUtil :: getWeekStartDate() :: END");

		return startDate.toString();
	}

		

}
