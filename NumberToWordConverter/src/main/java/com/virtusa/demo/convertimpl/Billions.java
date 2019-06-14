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
package com.virtusa.demo.convertimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.virtusa.demo.constants.CurrencyConstants;
import com.virtusa.demo.controller.NumberToWordConversionController;
import com.virtusa.demo.convert.CurrencyConverter;
import com.virtusa.demo.exception.CurrencyException;
import com.virtusa.demo.helper.NumberToEnglishWordsHelper;


/**
 * Calculate Billions.
 * 
 * <pre>
 * number - e.g. 1234
 * </pre>
 * 
 * <pre>
 * Changelog:
 * 
 * shobitgarg@virtusa.com - June 14, 2019 Initial version
 * </pre>
 *
 * @author shobitgarg@virtusa.com
 */
public class Billions extends NumberToEnglishWordsHelper implements CurrencyConverter {
	
	/**
     * for logging.
     */
	private static Logger log = LoggerFactory.getLogger(Billions.class);

    /**
     * This method is used to calculate Billions in the input number.
     * 
     * @param number
     *            input number
     * @return String tradBillions.
     */
    @Override
    public String calculateCurrency(String number) throws CurrencyException {

        log.info("Start: Billions.calculateCurrency method ");
        // XXXnnnnnnnnn
        int billions = getNumber(number, CurrencyConstants.numZero, CurrencyConstants.numThree);
        String tradBillions;
        switch (billions) {
        case 0:
            tradBillions = CurrencyConstants.emptyString;
            break;
        case 1:
            tradBillions = convertNumberLessThanThousand(billions) + CurrencyConstants.billion;
            break;
        default:
            tradBillions = convertNumberLessThanThousand(billions) + CurrencyConstants.billion;
        }

        log.info("End: Billions.calculateCurrency method ");
        return tradBillions;

    }
}
