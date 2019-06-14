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

import com.virtusa.demo.convertimpl.Millions;
import com.virtusa.demo.exception.CurrencyException;
import static org.junit.Assert.assertEquals;

/**
 * Test Class for Millions
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
public class MillionsTest {

    /** Millions. */
    @InjectMocks
    private Millions millions;
    
    /**
     * for logging.
     */
	private static Logger log = LoggerFactory.getLogger(BillionsTest.class);

    @Before
    public void setUp() throws Exception {
    	log.info("before");
    }

    /**
     * Test calculateCurrencyTestZeroMillionNumbers method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void calculateCurrencyTestZeroMillionNumbers() throws CurrencyException {

        String number = "000000456789";
        String result = millions.calculateCurrency(number);
        assertEquals("", result);
    }

    /**
     * Test calculateCurrencyTestOneMillionNumbers method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void calculateCurrencyTestOneMillionNumbers() throws CurrencyException {

        String number = "000100000000";
        String result = millions.calculateCurrency(number);
        assertEquals(" one hundred  million ", result);
    }

    /**
     * Test calculateCurrencyTestOtherMillionNumbers method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void calculateCurrencyTestOtherMillionNumbers() throws CurrencyException {

        String number = "000456000000";
        String result = millions.calculateCurrency(number);
        System.out.print(result);
        assertEquals(" four hundred  and  fifty six million ", result);
    }

}
