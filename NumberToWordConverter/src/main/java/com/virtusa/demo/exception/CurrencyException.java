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
package com.virtusa.demo.exception;

/**
 * CurrencyException Class for exception handling.
 * 
 * @author shobitgarg@virtusa.com
 */
public class CurrencyException extends Exception {

    /**
     * Variable of type Exception.
     */
    private Exception ex;

    /**
     * static variable
     */
    private static final long serialVersionUID = 1L;

    /**
     * Method to get Exception.
     * 
     * @return Exception
     */
    public Exception getEx() {
        return ex;
    }

    /**
     * Method to set Exception.
     * 
     * @param ex
     *            is of type Exception
     */
    public void setEx(Exception ex) {
        this.ex = ex;
    }

    /**
     * Constructor for CurrencyException.
     */
    public CurrencyException() {
        super();
    }

    /**
     * Converter Exception method to set the Exception.
     * 
     * @see java.lang.Throwable#Throwable(String)
     * @param iException
     *            is of type Exception
     */
    public CurrencyException(Exception ex) {
        this.ex = ex;
    }

}
