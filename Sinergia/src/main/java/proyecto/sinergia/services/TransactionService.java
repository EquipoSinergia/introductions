package proyecto.sinergia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import proyecto.sinergia.entities.Transaction;
import proyecto.sinergia.repositories.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){this.transactionRepository = transactionRepository;}

    public List<Transaction> getMovimientoDineros(){
        return this.transactionRepository.findAll();
    }

    public void createMovimientoDinero(Transaction newTransaction){
        transactionRepository.save(newTransaction);
    }

    public Optional<Transaction> getMovimientoDineroById(@PathVariable("id") long movimientoDineroId){
        java.util.Optional<Transaction> optionalMovimientoDinero = transactionRepository.findById(movimientoDineroId);
        if(((java.util.Optional<Transaction>) optionalMovimientoDinero).isPresent()) {
            return Optional.of(optionalMovimientoDinero.get());
        }else
            return Optional.empty();
    }

    public void deleteMovimientoDinero(@PathVariable("id") long movimientoDineroId){
        transactionRepository.deleteById(movimientoDineroId);
    }

    public ResponseEntity<Transaction> updateMovimientoDinero(@PathVariable("id") long transaction_id, @RequestBody Transaction transaction){
        Optional<Transaction> optionalMovimientoDinero = transactionRepository.findById(transaction_id);
        if (optionalMovimientoDinero.isPresent()) {
            Transaction updatedTransaction = optionalMovimientoDinero.get();
            updatedTransaction.setConceptoMto(transaction.getConceptoMto());
            updatedTransaction.setMontoMto(transaction.getMontoMto());
            transactionRepository.save(updatedTransaction);
            return ResponseEntity.ok(updatedTransaction);
        }else
            return ResponseEntity.notFound().build();
    }




}
