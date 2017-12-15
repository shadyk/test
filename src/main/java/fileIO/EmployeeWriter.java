package fileIO;

import java.io.FileWriter;
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
}
