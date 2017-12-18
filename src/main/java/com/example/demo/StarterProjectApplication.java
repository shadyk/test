package com.example.demo;


import org.apache.log4j.Logger;
//import org.springframework.context.ApplicationContext;
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
	final static Logger logger = Logger.getLogger(StarterProjectApplication.class);
	
	public static void main(String[] args) {
		
		scanner =new Scanner(System.in);
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");


		
		context.close();
		StarterProjectApplication.showMainScanner();
//		context = new ClassPathXmlApplicationContext("employeeBean.xml");
//		Employee e1 = context.getBean("emp1",Employee.class);
//		Employee e2 = context.getBean("emp2",Employee.class);
	}
	
	public static void showMainScanner(){
		logger.info("\nHello! Enter number of your transaction: \n1.Export To File\n2.Import From File\n3.Add Employee");
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
				logger.error("Invalid Entry");  
				   break;
			}
		   }
		   catch (InputMismatchException e) {
			   logger.error("Invalid Entry");
			   StarterProjectApplication.showMainScanner();
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
        	logger.error("Error exporting data " + e.getMessage());
        }
	   logger.info("Success");
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
        	logger.error("Error importing data " + e.getMessage());
        }
	   logger.info("Success");
	   StarterProjectApplication.showMainScanner();
	}
	
	public static void addEmployee(){
		logger.info("Enter Employee id");  
	   int id = scanner.nextInt();
	   logger.info("Enter Emp First name");  
	   String fname=scanner.next();
	   logger.info("Enter Emp Last name");  
	   String lname=scanner.next();  
	   logger.info("Enter Years of exp");  
	   int years=scanner.nextInt(); 
	   Employee newEmp = new Employee(id,fname,lname,years);
	   employeeDAO.insert(newEmp);
	   logger.info("Succes!");
	   StarterProjectApplication.showMainScanner();
	}
	
}
