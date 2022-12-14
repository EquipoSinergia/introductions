package proyecto.sinergia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proyecto.sinergia.entities.Employee;
import proyecto.sinergia.entities.Empresa;
import proyecto.sinergia.services.EmployeeService;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getEmployees(Model model){
        model.addAttribute("employees", employeeService.getEmployees());
        return "employees";
    }

    @GetMapping("/agregar-empleado")
    public String formularioCrearEmpresa(Employee employee){
        return "agregar-empleado";
    }


    @PostMapping("/employees")
    public String createEmployee(Employee employee){
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping(value = "/employees/eliminar/{id}")
    public String deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    @GetMapping("/employees/editar/{id}")
    public String getEmployeeById(@PathVariable("id") long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employees", employee);
        return "editar-empleado";
    }

    @PostMapping("/employees/actualizar/{id}")
    public String updateEmpleado(@PathVariable("id") long id, Employee employee){
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }


    /*

    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employee_id, @RequestBody Employee employee){
        return this.employeeService.updateEmployee(employee_id, employee);
    }
    */
}
