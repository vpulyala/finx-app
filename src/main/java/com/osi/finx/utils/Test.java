package com.osi.finx.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
public class Test {

	  public static final int DAYS_PER_WEEKEND = 2;
	  public static final int WEEK_START = DateTimeConstants.MONDAY;
	  public static final int WEEK_END = DateTimeConstants.FRIDAY;

	  public static void main(String args[]) {
		  
		  DateTime selectedDate = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss").parseDateTime("24/08/2018 20:27:05");

		  int i=0;
		  while(i<6)
		  {
			  selectedDate = selectedDate.minusDays(1);
					  System.out.println("in --->"+selectedDate);
		      if(selectedDate.getDayOfWeek()<=5)
		      {
		          i++;
		      }

		  }
		  System.out.println("new date"+selectedDate);
		  
		  
		  
		  /*for(int i=moveBy;i>0;i--){
				DateTime prevDate = selectedDate;
				System.out.println(prevDate.toString());
				if(DateTimeConstants.SATURDAY == prevDate.getDayOfWeek() && DateTimeConstants.SUNDAY == prevDate.getDayOfWeek()){
					i++; 
				}
				prevDate = prevDate.minus(1);
			}*/
			
		  
/*			
			String xmlString = "<?xml version='1.0' encoding='ISO-8859-1'?>"+
"<?xml-stylesheet type='text/xsl' href='non-vatable.xsl'?>"+
"<QxIHubTransaction>"+
  "<ftTrxId>1</ftTrxId>"+
  "<orgCode>10000</orgCode>"+
  "<leCode>11</leCode>"+
  "<trxType>REVENUE</trxType>"+
  "<locationCode>100111</locationCode>"+
  "<acctType>PREPAID</acctType>"+
  "<providerCode>20</providerCode>"+
  "<serviceType>LOGISTICS</serviceType>"+
  "<productCode>103</productCode>"+
  "<customer>Customer</customer>"+
  "<customerTypeCode>20</customerTypeCode>"+
  "<buyer>Buyer</buyer>"+
  "<customerEmail>qc.receipt.client@qac.com</customerEmail>"+
  "<trackingNo>120001</trackingNo>"+
  "<currencyCode>PHP</currencyCode>"+
  "<claimType>00</claimType>"+
 "<QxIHubTransactionLine>"+ 
    "<lineTypeCode>90</lineTypeCode>"+
    "<lineTypeDescription>INSURANCE FEE</lineTypeDescription>"+
    "<netAmount>1700</netAmount>"+
    "<vatAmount>77</vatAmount>"+
    "<grossAmount>1777</grossAmount>"+
  "</QxIHubTransactionLine>"+
  "<QxIHubTransactionLine>"+
    "<lineTypeCode>lt0002</lineTypeCode>"+
    "<lineTypeDescription>SHIPPING FEE</lineTypeDescription>"+
    "<netAmount>1900</netAmount>"+
    "<vatAmount>99</vatAmount>"+
    "<grossAmount>1999</grossAmount>"+
  "</QxIHubTransactionLine>"+
  "<QxIHubTransactionPayment>"+
    "<paymentType>10</paymentType>"+
    "<paymentValue>1777</paymentValue>"+
  "</QxIHubTransactionPayment>"+
"</QxIHubTransaction>";

		    RestTemplate restTemplate =  new RestTemplate();
		    //Create a list for the message converters
		    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		    //Add the String Message converter
		    messageConverters.add(new StringHttpMessageConverter());
		    //Add the message converters to the restTemplate
		    restTemplate.setMessageConverters(messageConverters);


		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_XML);
		    HttpEntity<String> request = new HttpEntity<String>(xmlString, headers);

		    final ResponseEntity<String> response = restTemplate.postForEntity("http://192.168.24.77:8080/QxIHUB/nonRevenueTransaction", request, String.class);
*/
		  
		  
			//System.out.println("Business day  for 5 days from now is "+prevDate.toString());
			
			
/*		  IntFunction<TemporalAdjuster> addBusinessDays = days -> TemporalAdjusters.ofDateAdjuster(
				    date -> {
				      LocalDate baseDate =
				          days > 0 ? date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
				              : days < 0 ? date.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)) : date;
				      int businessDays = days + Math.min(Math.max(baseDate.until(date).getDays(), -4), 4);
				      return baseDate.minusWeeks(businessDays / 5).minusDays(businessDays % 5);
				    });

				
	    System.out.println(LocalDate.of(2018, 8, 24).with(addBusinessDays.apply(7)));
*/	  } 
}
