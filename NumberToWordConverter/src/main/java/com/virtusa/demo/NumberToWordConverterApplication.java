package com.virtusa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot application class containing the main method
 * 
 * <pre>
 * Changelog:
 * 
 * shobitgarg@virtusa.com - June 14, 2019 Initial version
 * </pre>
 * 
 * @author shobitgarg@virtusa.com
 */
@SpringBootApplication
public class NumberToWordConverterApplication {

	/**
     * The main method.
     * 
     * @param args.
     * @return null.
     */
	public static void main(String[] args) {
		SpringApplication.run(NumberToWordConverterApplication.class, args);
	}
}
