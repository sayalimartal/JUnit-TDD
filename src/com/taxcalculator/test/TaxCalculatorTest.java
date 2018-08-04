//JUnit Test Case for TaxCalculator
package com.taxcalculator.test;

import org.junit.Assert;
import org.junit.Test;

import com.taxcalculator.CountryNotValidException;
import com.taxcalculator.EmployeeNameInvalidException;
import com.taxcalculator.TaxCalculator;
import com.taxcalculator.TaxNotEligibleException;

public class TaxCalculatorTest {
	
	//Test if employee is Indian
	@Test (expected = CountryNotValidException.class)
	public void TestIndian() throws EmployeeNameInvalidException, TaxNotEligibleException, CountryNotValidException{
		
		TaxCalculator taxCalculator = new TaxCalculator("Ron",34000,false);
		double tax = taxCalculator.calculateTax();
	}
	
	//Test tax eligibilty
	@Test (expected = TaxNotEligibleException.class)
	public void TestTaxEligibility() throws EmployeeNameInvalidException, TaxNotEligibleException, CountryNotValidException {
		TaxCalculator taxCalculator = new TaxCalculator("Tim",1000,true);
		double tax = taxCalculator.calculateTax();
	}
	
	//Test to calculate tax amount
	@Test 
	public void TestTaxAmount() throws EmployeeNameInvalidException, TaxNotEligibleException, CountryNotValidException {
		TaxCalculator taxCalculator = new TaxCalculator("Jack",55000,true);
		double tax = taxCalculator.calculateTax();
		Assert.assertEquals(3300, tax,0);
	}
	
	//Test for empty employee name
	@Test (expected = EmployeeNameInvalidException.class)
	public void TestEmployeeName() throws EmployeeNameInvalidException, TaxNotEligibleException, CountryNotValidException {
		TaxCalculator taxCalculator = new TaxCalculator("",30000,true);
		double tax = taxCalculator.calculateTax();
	}

}
