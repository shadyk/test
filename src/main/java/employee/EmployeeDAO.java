package employee;
import java.util.ArrayList;

public interface EmployeeDAO {
	
	 public void insert(Employee employee); 
     public Employee findById(int id);
     public ArrayList<Employee> getAllEmployees();
}

