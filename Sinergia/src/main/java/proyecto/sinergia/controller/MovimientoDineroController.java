package proyecto.sinergia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import proyecto.sinergia.services.MovimientoDineroService;

@RestController
public class MovimientoDineroController {

    @Autowired
    private MovimientoDineroService movimientoDineroService;



}
