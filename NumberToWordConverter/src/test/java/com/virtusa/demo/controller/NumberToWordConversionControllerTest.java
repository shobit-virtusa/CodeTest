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
package com.virtusa.demo.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.virtusa.demo.exception.CurrencyException;
import static org.junit.Assert.assertEquals;

/**
 * Test Class for NumberToWordConversionController
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
public class NumberToWordConversionControllerTest {

    /** NumberToBritishEnglishWordsClient. */
    @InjectMocks
    private NumberToWordConversionController numberToWordConversionController;

    /**
     * for logging.
     */
	private static Logger log = LoggerFactory.getLogger(NumberToWordConversionControllerTest.class);
    
    @Before
    public void setUp() throws Exception {
        log.info("before");
    }

    /**
     * Test convertNumberZeroToBritishEnglishWords method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void convert() throws CurrencyException {

        String number = "0";
        String result = NumberToWordConversionController.convert(number);
        assertEquals("zero", result);
    }

    /**
     * Test convertNumberToBritishEnglishWords method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void convertNumberToBritishEnglishWords() throws CurrencyException {

        String number = "123456789";
        String result = NumberToWordConversionController.convert(number);
        assertEquals("one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty nine",
                result);
    }

}
