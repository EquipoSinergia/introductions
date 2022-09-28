package proyecto.sinergia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import proyecto.sinergia.entities.Employee;
import proyecto.sinergia.repositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return this.employeeRepository.findAll();
    }

    public void createEmployee(Employee newEmployee){
        employeeRepository.save(newEmployee);
    }

    public Employee getEmployeeById(@PathVariable("id") long employeeId){
        return employeeRepository.findById(employeeId).get();
    }

    public void deleteEmployee(@PathVariable("id") long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employee_id ,@RequestBody Employee employee){
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee_id);
        if (optionalEmployee.isPresent()) {
            Employee updatedEmployee = optionalEmployee.get();
            updatedEmployee.setCorreo(employee.getCorreo());
            updatedEmployee.setRol(employee.getRol());
            employeeRepository.save(updatedEmployee);
            return ResponseEntity.ok(updatedEmployee);
        }else
            return ResponseEntity.notFound().build();
    }
}
