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

import com.virtusa.demo.convertimpl.Billions;
import com.virtusa.demo.exception.CurrencyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Test Class for Billions
 * 
 * <pre>
 * Changelog:
 * 
 * shobitgarg@virtusa.com - June 14, 2019 Initial version
 * </pre>
 * 
 * @author shobitgarg@virtusa.com
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BillionsTest {

    /** Billions. */
    @InjectMocks
    private Billions billions;
	
	/**
     * for logging.
     */
	private static Logger log = LoggerFactory.getLogger(BillionsTest.class);
	
    @Before
    public void setUp() throws Exception {
      log.info("before");
    }

    /**
     * Test calculateCurrencyTestZeroBillionNumbers method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void calculateCurrencyTestZeroBillionNumbers() throws CurrencyException {

        String number = "000123456789";
        String result = billions.calculateCurrency(number);
        assertEquals("", result);
    }

    /**
     * Test calculateCurrencyTestOneBillionNumbers method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void calculateCurrencyTestOneBillionNumbers() throws CurrencyException {

        String number = "001000000000";
        String result = billions.calculateCurrency(number);
        assertEquals(" one billion ", result);
    }

    /**
     * Test calculateCurrencyTestOtherBillionNumbers method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void calculateCurrencyTestOtherBillionNumbers() throws CurrencyException {

        String number = "123456789999";
        String result = billions.calculateCurrency(number);
        assertEquals(" one hundred  and  twenty three billion ", result);
    }

}
