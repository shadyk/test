package com.example.demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import employee.Employee;
import employee.EmployeeDAO;
import fileIO.EmployeeWriter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//@SpringBootApplication
public class StarterProjectApplication {
	static Scanner scanner;
	static EmployeeDAO employeeDAO;
//	private static ApplicationContext context;
	
	public static void main(String[] args) {
		
		scanner =new Scanner(System.in);
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		context.close();
		StarterProjectApplication.showMainScanner();
//		context = new ClassPathXmlApplicationContext("employeeBean.xml");
//		Employee e1 = context.getBean("emp1",Employee.class);
//		Employee e2 = context.getBean("emp2",Employee.class);
//		System.out.println(e1);
//		System.out.println(e2.toString());
	}
	
	public static void showMainScanner(){
		 System.out.println("Hello! Enter number of your transaction: \n1.Export To File\n2.Import From File\n3.Add Employee");
		   int mainOption = -1;
		   try {
			   mainOption=scanner.nextInt();
			   switch (mainOption) {
			case 1:
				StarterProjectApplication.exportFile();
				break;
				
			case 2:
				StarterProjectApplication.importFile();
				break;
			case 3:
				StarterProjectApplication.addEmployee();
				break;
			default:
				   System.out.println("Invalid Entry");  
				   break;
			}
		   }
		   catch (InputMismatchException e) {
			   System.out.println("Invalid Entry");  
		   }
		   
		   finally{
		   }
		
		   scanner.close();
	}
	
	public static void exportFile(){
		ArrayList<Employee> resultArray = employeeDAO.getAllEmployees();
        try {
        	EmployeeWriter.writeEmployees(resultArray);
        }
        catch (Exception e){
        	System.out.println("Error exporting data " + e.getMessage() );
        }
        System.out.println("Succes!");
	   StarterProjectApplication.showMainScanner();
	}
	
	public static void importFile(){
		ArrayList<Employee> employeeArray = EmployeeWriter.readFromFile();
        try {
        	for (Employee emp : employeeArray){
        		employeeDAO.insert(emp);
        	}
        }
        catch (Exception e){
        	System.out.println("Error importing data " + e.getMessage() );
        }
        System.out.println("Succes!");
	   StarterProjectApplication.showMainScanner();
	}
	
	public static void addEmployee(){
		System.out.println("Enter Employee id");  
	   int id = scanner.nextInt();
	   System.out.println("Enter Emp First name");  
	   String fname=scanner.next();
	   System.out.println("Enter Emp Last name");  
	   String lname=scanner.next();  
	   System.out.println("Enter Years of exp");  
	   int years=scanner.nextInt(); 
	   Employee newEmp = new Employee(id,fname,lname,years);
	   employeeDAO.insert(newEmp);
	   System.out.println("Succes!");
	   StarterProjectApplication.showMainScanner();
	}
	
}
