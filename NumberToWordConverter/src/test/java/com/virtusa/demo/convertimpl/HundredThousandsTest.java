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

import com.virtusa.demo.convertimpl.HundredThousands;
import com.virtusa.demo.exception.CurrencyException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Test Class for HundredThousands
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
public class HundredThousandsTest {
	
	/**
     * for logging.
     */
	private static Logger log = LoggerFactory.getLogger(HundredThousandsTest.class);

    /** HundredThousands. */
    @InjectMocks
    private HundredThousands hundredThousands;

    @Before
    public void setUp() throws Exception {
    	log.info("before");
    }

    /**
     * Test calculateCurrencyTestZeroHundredThousandNumbers method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void calculateCurrencyTestZeroHundredThousandNumbers() throws CurrencyException {

        String number = "000000000789";
        String result = hundredThousands.calculateCurrency(number);
        assertEquals("", result);
    }

    /**
     * Test calculateCurrencyTestOneHundredThousandNumbers method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void calculateCurrencyTestOneHundredThousandNumbers() throws CurrencyException {

        String number = "000000100999";
        String result = hundredThousands.calculateCurrency(number);
        assertEquals(" one hundred  thousand ", result);
    }

    /**
     * Test calculateCurrencyTestOtherHundredThousandNumbers method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void calculateCurrencyTestOtherHundredThousandNumbers() throws CurrencyException {

        String number = "000000456789";
        String result = hundredThousands.calculateCurrency(number);
        assertEquals(" four hundred  and  fifty six thousand ", result);
    }

}
