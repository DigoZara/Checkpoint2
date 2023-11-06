package com.fiap.checkpoint2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping("/salary")
    public List<Employee> getEmployeesInSalaryRange(@RequestParam double minSalary, @RequestParam double maxSalary) {
        return employeeRepository.findBySalaryBetween(minSalary, maxSalary);
    }

    @GetMapping("/average-salary/{departmentId}")
    public Double getAverageSalaryByDepartment(@PathVariable Long departmentId) {
        return employeeRepository.findAverageSalaryByDepartment(departmentId);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(updatedEmployee.getName());
            employee.setTitle(updatedEmployee.getTitle());
            employee.setSalary(updatedEmployee.getSalary());
            employee.setManager(updatedEmployee.getManager());
            employee.setDepartment(updatedEmployee.getDepartment());
            return employeeRepository.save(employee);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
