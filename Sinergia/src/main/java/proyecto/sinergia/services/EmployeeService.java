package proyecto.sinergia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.sinergia.repositories.EmployeeRepository;
import proyecto.sinergia.repositories.EmpresaRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return this.empmployeeRepository.findAll();
    }

    public Employee createEmployee(Employee newEmployee){
        return this.employeeRepository.save(newEmployee);
    }

    public Optional<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        java.util.Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(((java.util.Optional<Employee>) optionalEmployee).isPresent()) {
            return Optional.of(optionalEmployee.get());
        }else
            return Optional.empty();
    }

    public void deleteEmployee(@PathVariable("id") long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
        if (optionalEmployee.isPresent()) {
            Employee updatedEmployee = optionalEmployee.get();
            updatedEmployee.setcorreoEmployee(employee.getcorreoEmployee());
            employeeRepository.save(updatedEmployee);
            return ResponseEntity.ok(updatedEmployee);
        }else
            return ResponseEntity.notFound().build();
    }
}
