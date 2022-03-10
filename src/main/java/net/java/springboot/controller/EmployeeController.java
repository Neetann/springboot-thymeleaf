package net.java.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import net.java.springboot.model.Employee;
import net.java.springboot.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}

	@GetMapping("/newEmployeeForm")
	public String createEmployee(Model model) {
		Employee e = new Employee();
		model.addAttribute("employee", e);
		return "new_employee";

	}
	@PostMapping("/saveEmployee")
	public String saveEmployee( @ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";

	}
	/*
	 * @PostMapping("/employees") public Employee createEmployee(@RequestBody
	 * Employee employee) { return employeeRepository.save(employee);
	 * 
	 * }
	 * 
	 * @GetMapping("/employees/{id}") public ResponseEntity<Employee>
	 * getEmployeeById(@PathVariable Long id) { return
	 * ResponseEntity.ok(employeeRepository.findById(id) .orElseThrow(() -> new
	 * ResourceNotFoundException("Employee not found with id - " + id))); }
	 * 
	 * @PutMapping("/employees/{id}") public ResponseEntity<Employee>
	 * updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
	 * 
	 * Employee e = employeeRepository.findById(id) .orElseThrow(() -> new
	 * ResourceNotFoundException("Employee not found with id - " + id));
	 * e.setFirstname(employee.getFirstname());
	 * e.setLastName(employee.getLastName());
	 * e.setEmailId(employee.getEmailId());
	 * 
	 * return ResponseEntity.ok(employeeRepository.save(e));
	 * 
	 * }
	 * 
	 * @DeleteMapping("/employees/{id}") public ResponseEntity<Map<String,
	 * Boolean>> deleteEmployee(@PathVariable Long id) { Employee e =
	 * employeeRepository.findById(id) .orElseThrow(() -> new
	 * ResourceNotFoundException("Employee not found with id - " + id));
	 * 
	 * employeeRepository.delete(e); Map<String, Boolean> response = new
	 * HashMap<>(); response.put("deleted", Boolean.TRUE); return
	 * ResponseEntity.ok(response); }
	 */

}
