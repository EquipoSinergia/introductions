package proyecto.sinergia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.sinergia.entities.Employee;
import proyecto.sinergia.services.EmployeeService;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return this.employeeService.getEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){return this.employeeService.createEmployee(employee);
    }

    //Metodo para listar Empleados por su Id
    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") long id){
        return this.employeeService.getEmployeeById(id);
    }

    @DeleteMapping(value = "/employees/{id}")
    public void deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        return this.employeeService.updateEmployee(employee);
    }

}
