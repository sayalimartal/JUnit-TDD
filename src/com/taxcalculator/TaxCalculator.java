package com.taxcalculator;

public class TaxCalculator {
	
	private String employeeName;
	private double employeeSalary;
	private boolean isIndian;
	
	public TaxCalculator(String employeeName, double employeeSalary, boolean isIndian) {
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.isIndian = isIndian;
	}
	
	//Calculate tax if no exception is thrown
	public double calculateTax() throws EmployeeNameInvalidException, TaxNotEligibleException, CountryNotValidException {
		double taxAmount = 0;
		if (isIndian==true) {
			if (employeeName.isEmpty()) 
				throw new EmployeeNameInvalidException("The employee name cannot be empty");
			else {
				if (employeeSalary>=1_00_000) 
					taxAmount=employeeSalary*0.08;
				else if(employeeSalary>=50_000) 
					taxAmount=employeeSalary*0.06;
				else if(employeeSalary>=30_000) 
					taxAmount=employeeSalary*0.05;
				else if(employeeSalary>=10_000) 
					taxAmount=employeeSalary*0.04;
				else 
					throw new TaxNotEligibleException("The employee does not need to pay tax");
			}
		}
		else 
			throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax.");
		return taxAmount;
	}
	
}