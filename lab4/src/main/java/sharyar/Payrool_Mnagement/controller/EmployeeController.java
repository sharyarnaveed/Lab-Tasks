package SafiUllah.Payrool_Mnagement.controller;

import SafiUllah.Payrool_Mnagement.entry.employeedata;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final Map<Long, employeedata> employeeDatabase = new HashMap<>();
    private long nextId = 1; // Auto-incrementing Employee ID

    // Add a new employee
    @PostMapping
    public ResponseEntity<employeedata> addEmployee(@RequestBody employeedata employee) {
        employee.setId(nextId++); // Auto-increment the ID
        employeeDatabase.put(employee.getId(), employee);
        return ResponseEntity.ok(employee);
    }

    // Get an employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<employeedata> getEmployeeById(@PathVariable Long id) {
        employeedata employee = employeeDatabase.get(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    // Update the entire employee record
    @PutMapping("/{id}")
    public ResponseEntity<employeedata> updateEmployee(@PathVariable Long id, @RequestBody employeedata updatedEmployee) {
        if (!employeeDatabase.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedEmployee.setId(id); // Ensure ID remains unchanged
        employeeDatabase.put(id, updatedEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Update only the salary
    @PatchMapping("/{id}/salary")
    public ResponseEntity<employeedata> updateSalary(@PathVariable Long id, @RequestBody Map<String, Double> updates) {
        employeedata employee = employeeDatabase.get(id);
        if (employee == null || !updates.containsKey("salary")) {
            return ResponseEntity.badRequest().body(null);
        }
        employee.setSalary(updates.get("salary"));
        return ResponseEntity.ok(employee);
    }

    // Update only the designation
    @PatchMapping("/{id}/designation")
    public ResponseEntity<employeedata> updateDesignation(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        employeedata employee = employeeDatabase.get(id);
        if (employee == null || !updates.containsKey("designation")) {
            return ResponseEntity.badRequest().body(null);
        }
        employee.setDesignation(updates.get("designation"));
        return ResponseEntity.ok(employee);
    }

    // Give a salary raise by a specific percentage
    @PatchMapping("/{id}/raise")
    public ResponseEntity<employeedata> giveSalaryRaise(@PathVariable Long id, @RequestBody Map<String, Double> updates) {
        employeedata employee = employeeDatabase.get(id);
        if (employee == null || !updates.containsKey("percentage")) {
            return ResponseEntity.badRequest().body(null);
        }
        double percentage = updates.get("percentage");
        double newSalary = employee.getSalary() * (1 + percentage / 100);
        employee.setSalary(newSalary);
        return ResponseEntity.ok(employee);
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        if (employeeDatabase.remove(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Employee deleted successfully.");
    }
}
