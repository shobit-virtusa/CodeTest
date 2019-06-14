/*
 *
 * Copyright (c) Virtusa 2019
 * All Rights Reserved.
 *
 * Note: All information contained herein is, and remains 
 * the property of Virtusa Consulting Services.
 * 
 * You shall not disclose such Confidential Information 
 * and shall use it only in accordance with the terms of the
 * license agreement you entered into with Virtusa Consulting Services.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Virtusa Consulting Services.
 */
package com.virtusa.demo.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.virtusa.demo.constants.CurrencyConstants;
import com.virtusa.demo.convert.CurrencyConverter;
import com.virtusa.demo.convertimpl.Billions;
import com.virtusa.demo.convertimpl.HundredThousands;
import com.virtusa.demo.convertimpl.Millions;
import com.virtusa.demo.convertimpl.Thousands;

/**
 * Returns Currency Object.
 * 
 * <pre>
 * Changelog:
 * 
 * shobitgarg@virtusa.com - June 14, 2019 Initial version
 * </pre>
 *
 * @author shobitgarg@virtusa.com
 */
public class CurrencyFactory {
	
	/**
     * for logging.
     */
	private static Logger log = LoggerFactory.getLogger(CurrencyFactory.class);

    /**
     * This method will be used to return a currency type object
     * 
     * @param currencyType
     *            input currencyType
     * @return CurrencyConverter - currency type Object
     */
    public CurrencyConverter getCurrency(String currencyType) {

        log.info("START: CurrencyFactory.getCurrency method");
        if (currencyType == null) {
            return null;
        }
        if (currencyType.equalsIgnoreCase(CurrencyConstants.billion)) {
            return new Billions();

        } else if (currencyType.equalsIgnoreCase(CurrencyConstants.million)) {
            return new Millions();

        } else if (currencyType.equalsIgnoreCase(CurrencyConstants.hundredThousand)) {
            return new HundredThousands();

        } else if (currencyType.equalsIgnoreCase(CurrencyConstants.thousand)) {
            return new Thousands();
        }
        log.info("END: CurrencyFactory.getCurrency method");
        return null;
    }

}