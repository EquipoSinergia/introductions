package proyecto.sinergia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.sinergia.entities.MovimientoDinero;
import proyecto.sinergia.services.MovimientoDineroService;
import java.util.List;
import java.util.Optional;

@RestController
public class MovimientoDineroController {

    @Autowired
    private MovimientoDineroService movimientoDineroService;

    public MovimientoDineroController(MovimientoDineroService movimientoDineroService){this.movimientoDineroService = movimientoDineroService;}

    @GetMapping("/transactions")
    public List<MovimientoDinero> getmovimientoDineros(){return this.movimientoDineroService.getMovimientoDineros();}

    @PostMapping("/transactions")
    public MovimientoDinero createMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero){return this.movimientoDineroService.createMovimientoDinero(movimientoDinero);
    }

    //Metodo para listar Movimiento de dinero por su Id
    @GetMapping("/transactions/{id}")
    public Optional<MovimientoDinero> getMovimientoDineroById(@PathVariable("id") long id){
        return this.movimientoDineroService.getMovimientoDineroById(id);
    }

    @DeleteMapping(value = "/transactions/{id}")
    public void deleteMovimientoDinero(@PathVariable("id") long id) {movimientoDineroService.deleteMovimientoDinero(id);}

    @PutMapping(value = "/transactions/{id}")
    public ResponseEntity<MovimientoDinero> updateMovimientoDinero(@PathVariable("id") long transaction_id, @RequestBody MovimientoDinero movimientoDinero){
        return this.movimientoDineroService.updateMovimientoDinero(transaction_id, movimientoDinero);
    }

}
