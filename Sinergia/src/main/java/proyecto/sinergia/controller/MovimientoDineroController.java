package proyecto.sinergia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import proyecto.sinergia.services.MovimientoDineroService;

@RestController
public class MovimientoDineroController {

    @Autowired
    private MovimientoDineroService movimientoDineroService;

    public MovimientoDineroController(MovimientoDineroService movimientoDineroService){this.movimientoDineroService = movimientoDineroService;}

    @GetMapping("/MovimientoDineros")
    public  List<MovimientoDinero> getmovimientoDineros(){return this.movimientoDineroService.getmovimientoDineros();}

    @PostMapping("/MovimientoDineros")
    public MovimientoDinero createMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero){return this.movimientoDineroService.createMovimientoDinero(movimientoDinero);
    }

    //Metodo para listar Movimiento de dinero por su Id
    @GetMapping("/MovimientoDineros/{id}")
    public Optional<MovimientoDinero> getMovimientoDineroById(@PathVariable("id") long id){
        return this.MovimientoDineroService.getMovimientoDineroById(id);
    }

    @DeleteMapping(value = "/MovimientoDineros/{id}")
    public void deleteMovimientoDinero(@PathVariable("id") long id) {movimientoDineroService.deleteMovimientoDinero(id);}

    @PutMapping(value = "/MovimientoDineros/{id}")
    public ResponseEntity<MovimientoDinero> updateMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero){
        return this.movimientoDineroService.updateMovimientoDinero(movimientoDinero);
    }

}
