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
package com.virtusa.demo.convertimpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.virtusa.demo.convertimpl.Thousands;
import com.virtusa.demo.exception.CurrencyException;
import static org.junit.Assert.assertEquals;

/**
 * Test Class for Thousands
 * 
 * <pre>
 * Changelog:
 * 
 * shobitgarg@virtusa.com - June 14, 2019 Initial version
 * </pre>
 * 
 * @author shobitgarg@virtusapolaris.com
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ThousandsTest {

    /** HundredThousands. */
    @InjectMocks
    private Thousands thousands;
    
    /**
     * for logging.
     */
	private static Logger log = LoggerFactory.getLogger(ThousandsTest.class);

    @Before
    public void setUp() throws Exception {
       log.info("before");
    }

    /**
     * Test calculateCurrencyTestZeroThousandNumbers method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void calculateCurrencyTestZeroThousandNumbers() throws CurrencyException {

        String number = "000123000000";
        String result = thousands.calculateCurrency(number);
        assertEquals("", result);
    }

    /**
     * Test convertNumbersLessThanOneHundredTwenty method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void convertNumbersLessThanOneHundredTwenty() throws CurrencyException {

        String number = "000000000119";
        String result = thousands.calculateCurrency(number);
        assertEquals(" one hundred  and  nineteen", result);

    }

    /**
     * Test convertNumbersMoreThanOneHundredTwenty method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void convertNumbersMoreThanOneHundredTwenty() throws CurrencyException {

        String number = "000000000123";
        String result = thousands.calculateCurrency(number);
        assertEquals(" one hundred  and  twenty three", result);

    }

}
