//Exception thrown if employee is not Indian
package com.taxcalculator;

public class CountryNotValidException extends Exception {
	
	public CountryNotValidException(String message) {
		super(message);
	}

}
