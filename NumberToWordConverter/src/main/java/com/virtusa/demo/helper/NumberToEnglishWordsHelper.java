/*
 *
 * Copyright (c) Virtusa 2019
 * All Rights Reserved.
 *
 * Note: All information contained herein is, and remains 
 * the property of Virtusa Consulting Services.
 * You shall not disclose such Confidential Information 
 * and shall use it only in accordance with the terms of the
 * license agreement you entered into with Virtusa Consulting Services.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Virtusa Consulting Services.
 */
package com.virtusa.demo.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.virtusa.demo.constants.CurrencyConstants;
import com.virtusa.demo.exception.CurrencyException;

/**
 * Converts numbers less than Thousand into British English words and find a
 * substring from a given input String based on start and end index and return
 * the integer value of it.
 * 
 * <pre>
 * Changelog:
 * 
 * shobitgarg@virtusa.com - June 14, 2019 Initial version
 * </pre>
 *
 * @author shobitgarg@virtusa.com
 */
public class NumberToEnglishWordsHelper {

	/**
     * for logging.
     */
	private static Logger log = LoggerFactory.getLogger(NumberToEnglishWordsHelper.class);

    /**
     * This method is used to convert Numbers less than thousand in British
     * English words.
     * 
     * @param number
     *            input number
     * 
     * @return String.
     */
    public String convertNumberLessThanThousand(int number) throws CurrencyException {
        log.info("Start: NumberToEnglishWordsHelper.convertNumberLessThanThousand method ");

        try {
            String var;
            if (number % CurrencyConstants.numHundred < CurrencyConstants.numTwenty) {
                var = CurrencyConstants.numbersArray[number % CurrencyConstants.numHundred];
                number /= CurrencyConstants.numHundred;
            } else {
                var = CurrencyConstants.numbersArray[number % CurrencyConstants.numTen];
                number /= CurrencyConstants.numTen;

                var = CurrencyConstants.tensArray[number % CurrencyConstants.numTen] + var;
                number /= CurrencyConstants.numTen;
            }

            if (number == CurrencyConstants.numZero)
                return var;
            log.info("End: NumberToEnglishWordsHelper.convertNumberLessThanThousand method ");
            String varStr= null;
            if(!var.equalsIgnoreCase("")) {
            varStr= CurrencyConstants.numbersArray[number] + CurrencyConstants.hundred + CurrencyConstants.and + var;
            }
            else {
            	varStr= CurrencyConstants.numbersArray[number] + CurrencyConstants.hundred + var;
            }
            return varStr;
        } catch (ArrayIndexOutOfBoundsException e) {
        	log.error("ArrayIndexOutOfBoundsException in : NumberToEnglishWordsHelper.convertNumberLessThanThousand method ");
            throw new CurrencyException(e);
        } catch (Exception e) {
        	log.error("Exception in : NumberToEnglishWordsHelper.convertNumberLessThanThousand method ");
            throw new CurrencyException(e);
        }

    }

    /**
     * This method is used to find a substring from a given input String based
     * on start and end index and return the integer value of it.
     * 
     * @param number
     *            input number
     * @param startIndex
     *            the Start Index
     * @param endIndex
     *            the end Index
     * @return Integer number.
     */
    public int getNumber(String number, int startIndex, int endIndex) {
        log.info("Start: NumberToEnglishWordsHelper.getNumber method ");
        return Integer.parseInt(number.substring(startIndex, endIndex));
    }

}
