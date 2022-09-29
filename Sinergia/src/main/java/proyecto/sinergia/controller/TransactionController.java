package proyecto.sinergia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proyecto.sinergia.entities.Transaction;
import proyecto.sinergia.services.TransactionService;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService){this.transactionService = transactionService;}

    @GetMapping("/transactions")
    public String getTransations(Model model){
        model.addAttribute("transactions", transactionService.getTransaction());
        return "transactions";
    }

    @GetMapping("/agregar-transaction")
    public String formularioCrearTransaction(Transaction transaction){
        return "agregar-transaction";
    }


    @PostMapping("/transactions")
    public String createMovimientoDinero(Transaction transaction){
        transactionService.createTransaction(transaction);
        return "redirect:/transactions";
    }

    @GetMapping(value = "/transactions/eliminar/{id}")
    public String deleteTransaction(@PathVariable("id") long id) {
        transactionService.deleteTransaction(id);
        return "redirect:/transactions";
    }

    /*

    //Metodo para listar Movimiento de dinero por su Id
    @GetMapping("/transactions/{id}")
    public Optional<Transaction> getMovimientoDineroById(@PathVariable("id") long id){
        return this.movimientoDineroService.getMovimientoDineroById(id);
    }



    @PutMapping(value = "/transactions/{id}")
    public ResponseEntity<Transaction> updateMovimientoDinero(@PathVariable("id") long transaction_id, @RequestBody Transaction movimientoDinero){
        return this.movimientoDineroService.updateMovimientoDinero(transaction_id, movimientoDinero);
    }

     */

}
