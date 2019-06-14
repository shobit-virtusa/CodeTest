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
package com.virtusa.demo.convert;

import com.virtusa.demo.exception.CurrencyException;

/**
 * Number Converter to be used to calculate no of
 * Billions,Millions,HundredThousands,Thousands in the given input number
 *
 * @author shobitgarg@virtusa.com
 * @param <number>
 *            the input number
 */
public interface CurrencyConverter {

    /**
     * This method will be used by implementing classes to calculate no of
     * Billions,Millions,HundredThousands,Thousands in the given input number.
     * 
     * @param number
     *            input number
     * @return String .
     */
    public String calculateCurrency(String number) throws CurrencyException;

}
