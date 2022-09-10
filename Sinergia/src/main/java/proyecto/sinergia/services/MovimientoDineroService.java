package proyecto.sinergia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.sinergia.repositories.MovimientoDineroRepository;

@Service
public class MovimientoDineroService {

    @Autowired
    private MovimientoDineroRepository movimientoDineroRepository;

    public MovimientoDineroService(MovimientoDineroRepository movimientoDineroRepository){this.movimientoDineroRepository = movimientoDineroRepository;}

    public List<MovimientoDinero> getMovimientoDineros(){
        return this.movimientoDineroRepository.findAll();
    }

    public MovimientoDinero createMovimientoDinero(MovimientoDinero newMovimientoDinero){return this.movimientoDineroRepository.save(newMovimientoDinero);
    }

    public Optional<MovimientoDinero> getMovimientoDineroById(@PathVariable("id") long movimientoDineroId){
        java.util.Optional<MovimientoDinero>optionalmovimientoDinero  movimientoDineroRepository.findById(movimientoDineroId);
        if(((java.util.Optional<MovimientoDinero>) optionalMovimientoDinero).isPresent()) {
            return Optional.of(optionalMovimientoDinero.get());
        }else
            return Optional.empty();
    }

    public void deleteMovimientoDinero(@PathVariable("id") long MovimientoDineroId){movimientoDineroRepository.deleteById(movimientoDineroId);
    }

    public ResponseEntity<MovimientoDinero> updateMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero){
        Optional<MovimientoDinero> optionalMovimientoDinero = movimientoDineroRepository.findById(movimientoDinero.getId());
        if (optionalMovimientoDinero.isPresent()) {
            MovimientoDinero updatedMovimientoDinero = optionalMovimientoDinero.get();
            updatedMovimientoDinero.setconceptoMtoMovimientoDinero(movimientoDinero.getconceptoMtoMovimientoDinero());
            updatedMovimientoDinero.setmontoMto(movimientoDinero.getmontoMtoMovimientoDinero());
            movimientoDineroRepository.save(updatedMovimientoDinero);
            return ResponseEntity.ok(updatedMovimientoDinero);
        }else
            return ResponseEntity.notFound().build();
    }




}
