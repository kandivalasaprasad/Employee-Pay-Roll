package com.bridgelab.EmployeePayroll;

import java.util.ArrayList;

public class EmployeeWage_12 implements EmployeeService {
	
		public static final int IS_PART_TIME = 1;
		public static final int IS_FULL_TIME = 2;

		private int numOfCompany = 0;
		private ArrayList<CompanyEmployeeWage> companyEmpWageList;

		public EmployeeWage_12() {
			companyEmpWageList = new ArrayList<CompanyEmployeeWage>();
		}

		public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
			CompanyEmployeeWage companyEmpWage = new CompanyEmployeeWage(company, empRatePerHour, numOfWorkingDays,
					maxHoursPerMonth);
			companyEmpWageList.add(companyEmpWage);
		}

		public void computeEmpWage() {
			for (int i = 0; i < companyEmpWageList.size(); i++) {

				CompanyEmployeeWage companyEmpWage = companyEmpWageList.get(i);
				companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
				System.out.println(companyEmpWage);
			}
		}

		@Override
		public int getTotalWage(String company) {
			int totalWage = 0;
			for (int i = 0; i < companyEmpWageList.size(); i++) {
				if (company.equals(companyEmpWageList.get(i).getCompany())) {
					totalWage = companyEmpWageList.get(i).getTotalEmpWage();
					return totalWage;
				}

			}
			return 0;
		}

		private int computeEmpWage(CompanyEmployeeWage companyEmpWage) {
			// variables
			int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
			// Computation
			while (totalEmpHrs <= companyEmpWage.getMaxHoursPerMonth()
					&& totalWorkingDays < companyEmpWage.getNumOfWorkingDays()) {
				totalWorkingDays++;
				int empCheck = (int) Math.floor(Math.random() * 10) % 3;

				switch (empCheck) {
				case IS_PART_TIME:
					empHrs = 4;
					break;
				case IS_FULL_TIME:
					empHrs = 8;
					break;
				default:
					empHrs = 0;
				}
				totalEmpHrs += empHrs;
				System.out.println("Day#: " + totalWorkingDays + " Emp Hr: " + empHrs);
			}
			return totalEmpHrs * companyEmpWage.getEmpRatePerHour();
		}

		public static void main(String[] args) {
			EmployeeWage_12 employeeWage = new EmployeeWage_12();
			employeeWage.addCompanyEmpWage("DMart", 20, 2, 10);
			employeeWage.addCompanyEmpWage("jio", 10, 4, 20);
			employeeWage.computeEmpWage();
			System.out.println("Total Wage for DMart Company:" + employeeWage.getTotalWage("DMart")) ;
		}

}
