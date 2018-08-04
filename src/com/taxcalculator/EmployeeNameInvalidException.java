//Exception thrown if employee name is null or empty
package com.taxcalculator;

public class EmployeeNameInvalidException extends Exception {

	public EmployeeNameInvalidException(String message) {
		super(message);
	}
	
}
