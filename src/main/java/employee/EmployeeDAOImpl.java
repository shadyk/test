package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

public class EmployeeDAOImpl implements EmployeeDAO
{
	private DataSource dataSource;
	 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public void insert(Employee employee){
 
		String sql = "INSERT INTO TEST " +
				"(EMPID, FNAME, LNAME,YEARS_EXPERIENCE) VALUES (?, ?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employee.getEmployeeID());
			ps.setString(2, employee.getFirstname());
			ps.setString(3, employee.getLastname());
			ps.setInt(4, employee.getYearsOfExperience());

			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
 
	public Employee findById(int id){
 
		String sql = "SELECT * FROM TEST WHERE EMPID = ?";
 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Employee employee = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employee = new Employee(
					rs.getInt("EMPID"),
					rs.getString("FNAME"),
					rs.getString("LNAME"), 
					rs.getInt("YEARS_EXPERIENCE")
				);
			}
			rs.close();
			ps.close();
			return employee;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public ArrayList<Employee> getAllEmployees() {
		String sql = "SELECT emp.*, jobs.job_title FROM EMPLOYEES emp, JOBS jobs where emp.job_id = jobs.job_id";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			Employee employee = null;
			ResultSet rs = ps.executeQuery();
			ArrayList<Employee> array= new ArrayList<Employee>();
			while (rs.next()) {
				employee = new Employee(
					rs.getInt("EMPLOYEE_ID"),
					rs.getString("first_name") + " "+ rs.getString("last_name"),
					rs.getString("job_title"), 
					rs.getInt("EMPLOYEE_ID")
				);
				array.add(employee);
			}
			rs.close();
			ps.close();
			return array;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}
