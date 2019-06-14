package com.virtusa.demo.helper;

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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.virtusa.demo.exception.CurrencyException;
import com.virtusa.demo.helper.NumberToEnglishWordsHelper;
import static org.junit.Assert.assertEquals;

/**
 * Test Class for NumberToEnglishWordsHelper
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
public class NumberToEnglishWordsHelperTest {

    /** The Converter. */
    @InjectMocks
    private NumberToEnglishWordsHelper numberToEnglishWordsHelper;
    
    /**
     * for logging.
     */
	private static Logger log = LoggerFactory.getLogger(NumberToEnglishWordsHelperTest.class);

    @Before
    public void setUp() throws Exception {
        log.info("before");

    }

    /**
     * Test get number method.
     * 
     */
    @Test
    public void getNumberTest() {

        String number = "123456789";
        int startIndex = 3;
        int endIndex = 6;
        int result = numberToEnglishWordsHelper.getNumber(number, startIndex, endIndex);
        assertEquals(456, result);
    }

    /**
     * Test convertNumberZeroTest method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void convertNumberZeroTest() throws CurrencyException {

        int number = 0;
        String result = numberToEnglishWordsHelper.convertNumberLessThanThousand(number);
        assertEquals("", result);

    }

    /**
     * Test convertNumberLessThanOneHundredTwentyTest method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void convertNumberLessThanOneHundredTwentyTest() throws CurrencyException {

        int number = 119;
        String result = numberToEnglishWordsHelper.convertNumberLessThanThousand(number);
        assertEquals(" one hundred  and  nineteen", result);

    }

    /**
     * Test convertNumberMoreThanOneHundredTwentyTest method.
     * 
     * @throws CurrencyException
     * 
     */
    @Test
    public void convertNumberMoreThanOneHundredTwentyTest() throws CurrencyException {

        int number = 123;
        String result = numberToEnglishWordsHelper.convertNumberLessThanThousand(number);
        assertEquals(" one hundred  and  twenty three", result);

    }

}
