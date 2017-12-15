package com.example.demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import employee.Employee;
import employee.EmployeeDAO;

import java.util.InputMismatchException;
import java.util.Scanner;

//@SpringBootApplication
public class StarterProjectApplication {
	static Scanner scanner;
//	private static ApplicationContext context;
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
        Employee employee1 = new Employee(199,"sss","ssss",32);
        try{
        employee1.writeEmployee();
        }
        catch (Exception e){
        	System.out.println("couldn't write employee \n"+ e.getMessage() );  
        }
//        employeeDAO.insert(employee1);
        Employee employee2 = employeeDAO.findById(199);
        System.out.println(employee2);	
		context.close();
		
		
		context = new ClassPathXmlApplicationContext("employeeBean.xml");
		scanner =new Scanner(System.in);
		
		Employee e1 = context.getBean("emp1",Employee.class);
		Employee e2 = context.getBean("emp2",Employee.class);
		System.out.println(e1);
		System.out.println(e2.toString());
		
		   
	   System.out.println("Hello! Enter number of your transaction: \n1.Export To File\n2.Import From File\n3.Add Employee");
	   
	   int mainOption = -1;
	   try {
		   mainOption=scanner.nextInt();
		   switch (mainOption) {
		case 1:
			
			break;
			
		case 2:
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
			   
	}
	
	public void export(){
			
	}
	
}
