package com.bridgelab.EmployeePayroll;

public class EmployeeAttendence {

	public static void main(String[] args) {

		int present = 1;
		double empCheck = Math.floor(Math.random() * 10) % 2;
		if (empCheck == present) {
			System.out.println("Employee is present");
		} else
			System.out.println("Employee is Absent");

	}

}
