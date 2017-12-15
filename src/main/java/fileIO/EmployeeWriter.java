package fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import employee.Employee;

public class EmployeeWriter {
	static String EXPORT_FILENAME = "/Users/shadyk/Desktop/employees_export.csv"; 
	static String IMPORT_FILENAME = "/Users/shadyk/Desktop/employees_import.csv"; 
	
    public static void writeEmployees(ArrayList<Employee> list) throws Exception {
        FileWriter writer = new FileWriter(EXPORT_FILENAME);
        for (Employee e : list){
        	FileManager.writeLine(writer, Arrays.asList(String.valueOf(e.getEmployeeID()), e.getFirstname(), e.getLastname(), String.valueOf(e.getYearsOfExperience())));
        }
        writer.flush();
        writer.close();
    }
    
    public static ArrayList<Employee> readFromFile(){
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Employee> employeeArray = new ArrayList<Employee>();
        try (BufferedReader br = new BufferedReader(new FileReader(IMPORT_FILENAME))) {

            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split(cvsSplitBy);
                Employee emp = new Employee(lineArray[0],lineArray[1],lineArray[2],lineArray[3]);
                employeeArray.add(emp);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        	return employeeArray;
    }
}
