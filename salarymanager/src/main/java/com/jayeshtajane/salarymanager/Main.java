package com.jayeshtajane.salarymanager;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jayeshtajane.salarymanager.employee.Employee;
import com.jayeshtajane.salarymanager.modal.attendence.Attendence;
import com.jayeshtajane.salarymanager.modal.employee.DeleteEmployee;
import com.jayeshtajane.salarymanager.modal.employee.SaveEmployee;
import com.jayeshtajane.salarymanager.modal.employee.UpdateEmployee;
import com.jayeshtajane.salarymanager.modal.salary.Salary;

/**
 * Servlet implementation class Main
 */
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String root;
	private String path;

    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("REQUEST : FILE = Main.java");
		root = request.getContextPath();
		path = request.getPathInfo();
		System.out.println(request.getPathInfo());
		
		String attendenceList = request.getParameter("attendence-list");
		String attendenceDate = request.getParameter("attendence-date");
		System.out.println("INFO : ATTENDENCE LIST = " + attendenceList);
		
		int empId = -1;
		if(request.getParameter("emp-id") != null)
			empId = Integer.parseInt(request.getParameter("emp-id"));
		Map m = request.getParameterMap();
		System.out.println("INFO : MAP LEN = " + m.size()); 
		
		//System.out.println("INFO : Main.java - empId = " + empId);
		
		if(path.equals("/attendence")) {
			GetData data = new GetData();
			String attendence = data.getAttendence();
			response.getWriter().append(attendence);
		}
		else if(path.equals("/attendence/save")) {
			new Attendence(attendenceList, attendenceDate).save();
		}
		else if(path.equals("/employee")) {
			GetData data = new GetData();
			String employee = data.getEmployee();
			response.getWriter().append(employee);
		}
		else if(path.equals("/employee/name")) {
			GetData data = new GetData();
			String employee = data.getEmployeeName(empId);
			response.getWriter().append(employee);
		}		
		else if(path.equals("/salary")) {
			GetData data = new GetData();
			String salary = data.getSalary();
			response.getWriter().append(salary);
		}
		else if(path.equals("/salary/pay")) {
			double amount = Double.parseDouble(request.getParameter("payable-amount"));
			Salary sal = new Salary();
			sal.pay(empId, amount);
		}
		else if(path.equals("/salary/pay-extra")) {
			double amount = Double.parseDouble(request.getParameter("payable-amount"));
			Salary sal = new Salary();
			sal.payExtra(empId, amount);
		}
		else if(path.equals("/history")) {
			GetData data = new GetData();
			String history = data.getHistory();
			response.getWriter().append(history);
		}
		else if(path.equals("/employee/update")) {
			Employee emp = new Employee();
			emp.setEmpId(empId); 
			emp.setEmpName(request.getParameter("emp-name"));
			emp.setEmpCity(request.getParameter("emp-city"));
			emp.setEmpContact(request.getParameter("emp-contact"));
			emp.setEmpSal(Double.parseDouble(request.getParameter("emp-sal"))); 
			
			System.out.println("INFO : Main.java update if Employee = \n" + emp);
			
			new UpdateEmployee(emp).update();
		}
		else if(path.equals("/employee/save")) {
			Employee emp = new Employee();
			emp.setEmpName(request.getParameter("emp-name"));
			emp.setEmpCity(request.getParameter("emp-city"));
			emp.setEmpContact(request.getParameter("emp-contact"));
			emp.setEmpSal(Double.parseDouble(request.getParameter("emp-sal"))); 
			
			System.out.println("INFO : Main.java save if Employee = \n" + emp);
			
			new SaveEmployee(emp).save();
		}
		else if(path.equals("/employee/delete")) {
			System.out.println("INFO : Main.java update if Employee id = \n" + empId);
			new DeleteEmployee(empId).delete();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}