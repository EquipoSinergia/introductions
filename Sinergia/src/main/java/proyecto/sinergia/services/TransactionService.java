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

    public List<Transaction> getTransaction(){
        return this.transactionRepository.findAll();
    }

    public void createTransaction(Transaction newTransaction){
        transactionRepository.save(newTransaction);
    }

    public Transaction getTransactionById(@PathVariable("id") long transactionId){
        return transactionRepository.findById(transactionId).get();
    }

    public void deleteTransaction(@PathVariable("id") long transactionId){
        transactionRepository.deleteById(transactionId);
    }

    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") long transaction_id, @RequestBody Transaction transaction){
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transaction_id);
        if (optionalTransaction.isPresent()) {
            Transaction updatedTransaction = optionalTransaction.get();
            updatedTransaction.setConceptoMto(transaction.getConceptoMto());
            updatedTransaction.setMontoMto(transaction.getMontoMto());
            transactionRepository.save(updatedTransaction);
            return ResponseEntity.ok(updatedTransaction);
        }else
            return ResponseEntity.notFound().build();
    }




}
