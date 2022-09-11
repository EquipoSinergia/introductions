package proyecto.sinergia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import proyecto.sinergia.entities.MovimientoDinero;
import proyecto.sinergia.repositories.MovimientoDineroRepository;

import java.util.List;
import java.util.Optional;

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
        java.util.Optional<MovimientoDinero> optionalMovimientoDinero = movimientoDineroRepository.findById(movimientoDineroId);
        if(((java.util.Optional<MovimientoDinero>) optionalMovimientoDinero).isPresent()) {
            return Optional.of(optionalMovimientoDinero.get());
        }else
            return Optional.empty();
    }

    public void deleteMovimientoDinero(@PathVariable("id") long movimientoDineroId){movimientoDineroRepository.deleteById(movimientoDineroId);
    }

    public ResponseEntity<MovimientoDinero> updateMovimientoDinero(@PathVariable("id") long transaction_id, @RequestBody MovimientoDinero movimientoDinero){
        Optional<MovimientoDinero> optionalMovimientoDinero = movimientoDineroRepository.findById(transaction_id);
        if (optionalMovimientoDinero.isPresent()) {
            MovimientoDinero updatedMovimientoDinero = optionalMovimientoDinero.get();
            updatedMovimientoDinero.setConceptoMto(movimientoDinero.getConceptoMto());
            updatedMovimientoDinero.setMontoMto(movimientoDinero.getMontoMto());
            movimientoDineroRepository.save(updatedMovimientoDinero);
            return ResponseEntity.ok(updatedMovimientoDinero);
        }else
            return ResponseEntity.notFound().build();
    }




}
