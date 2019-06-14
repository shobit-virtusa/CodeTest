package com.virtusa.demo.controller;

import java.text.DecimalFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.demo.constants.CurrencyConstants;
import com.virtusa.demo.convert.CurrencyConverter;
import com.virtusa.demo.exception.CurrencyException;
import com.virtusa.demo.factory.CurrencyFactory;

/**
 * Converts Numbers to British English Words.
 * 
 * <pre>
 * number - e.g. 1234
 * </pre>
 * 
 * <pre>
 * Changelog:
 * 
 * shobitgarg@virtusa.com - June 14, 2019 Initial version support Billions and Millions
 * shobitgarg@virtusa.com - June 14, 2019 Supports Hundred Thousands and Thousands
 * </pre>
 *
 * @author shobitgarg@virtusa.com
 */
@RestController
public class NumberToWordConversionController {
	
	/**
     * for logging.
     */
	private static Logger log = LoggerFactory.getLogger(NumberToWordConversionController.class);
	
	/**
     * This is the  method which makes use of convert method and prints
     * equivalent british english words for given input number.
     * 
     * @param number-number.
     * @return String.
     * @exception IOException
     *                On input error.
     */
	@RequestMapping(value = "/number/{number}",method = RequestMethod.GET)
	public String convertNumber(@PathVariable("number") String number){
		 log.info("Start: NumberToBritishEnglishWordsClient.main method ");
	     String convertedNumberToWordVar=null;   
	     try {
	    	 convertedNumberToWordVar=convert(number);
	            System.out.println("Conversion of number into British English Words--- " + '\n'
	                    + convertedNumberToWordVar );

	        } catch (CurrencyException currencyException) {
	            log.error("Exception occurred in NumberToBritishEnglishWordsClient.convert method...");
	            System.out.println("Exception occurred in NumberToBritishEnglishWordsClient.convert method..." + '\n'
	                    + "Cause is - " + currencyException.getEx() + " error");
	        }
	     
	        log.info("END: NumberToBritishEnglishWordsClient.main method ");
	        return convertedNumberToWordVar;
	}
	
	 /**
     * This method is used to convert numbers into British English Words.
     * 
     * @param number
     *            input number
     * @return String British English Words equivalent to the input number.
     */
    public static String convert(String number) throws CurrencyException {
    	log.info("START: NumberToBritishEnglishWordsClient.convert method");
        // 0 to 999 999 999 999
        if (number.equalsIgnoreCase("0")) 
            return CurrencyConstants.zero;
        
        DecimalFormat df = new DecimalFormat(CurrencyConstants.mask);
        String snumber = df.format(Long.parseLong(number));

        CurrencyFactory currencyFactory = new CurrencyFactory();
      
        // get an object of Billions and call its calculateCurrency method.
        CurrencyConverter billionsCurrencyConverter = currencyFactory.getCurrency(CurrencyConstants.billion);

        // call calculateCurrency method of Billions
        String result = billionsCurrencyConverter.calculateCurrency(snumber);

        // get an object of Millions and call its calculateCurrency method.
        CurrencyConverter millionsCurrencyConverter = currencyFactory.getCurrency(CurrencyConstants.million);

        // call calculateCurrency method of Millions
        result = result + millionsCurrencyConverter.calculateCurrency(snumber);

        // get an object of HundredThousands and call its calculateCurrency method 
        CurrencyConverter hundredThousandCurrencyConverter = currencyFactory.getCurrency(CurrencyConstants.hundredThousand);

        // call calculateCurrency method of HundredThousands
        result = result + hundredThousandCurrencyConverter.calculateCurrency(snumber);

        // get an object of Thousands and call its calculateCurrency method.
        CurrencyConverter thousandCurrencyConverter = currencyFactory.getCurrency(CurrencyConstants.thousand);

        // call calculateCurrency method of Thousands
        result = result +thousandCurrencyConverter.calculateCurrency(snumber);

        log.info("END: NumberToBritishEnglishWordsClient.convert method ");

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

}
