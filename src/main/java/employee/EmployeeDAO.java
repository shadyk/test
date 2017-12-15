package employee;
import java.util.List;

public interface EmployeeDAO {
	
	 public void insert(Employee employee); 
     public Employee findById(int id);
     public List<Employee> getAllEmployees();
}

