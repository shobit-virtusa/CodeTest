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
 * Calculate Millions.
 * 
 * <pre>
 * Changelog:
 * 
 * shobitgarg@virtusa.com - June 14, 2019 Initial version
 * </pre>
 *
 * @author shobitgarg@virtusa.com
 */
public class Millions extends NumberToEnglishWordsHelper implements CurrencyConverter {

	/**
     * for logging.
     */
	private static Logger log = LoggerFactory.getLogger(Millions.class);
	
    /**
     * This method is used to calculate Millions in the input number.
     * 
     * @param number
     *            input number
     * @return String tradMillions.
     */
    @Override
    public String calculateCurrency(String number) throws CurrencyException {

        log.info("Start: Millions.calculateCurrency method ");
        // nnnXXXnnnnnn
        int millions = getNumber(number, CurrencyConstants.numThree, CurrencyConstants.numSix);

        String tradMillions;
        switch (millions) {
        case 0:
            tradMillions = CurrencyConstants.emptyString;
            break;
        case 1:
            tradMillions = convertNumberLessThanThousand(millions) + CurrencyConstants.million;
            break;
        default:
            tradMillions = convertNumberLessThanThousand(millions) + CurrencyConstants.million;
        }

        log.info("End: Millions.calculateCurrency method ");
        return tradMillions;
    }
}
