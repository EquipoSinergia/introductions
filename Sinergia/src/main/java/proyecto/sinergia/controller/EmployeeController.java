package proyecto.sinergia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import proyecto.sinergia.services.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;





}
