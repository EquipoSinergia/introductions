package proyecto.sinergia.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import proyecto.sinergia.entities.Empresa;
import proyecto.sinergia.repositories.EmpresaRepository;
import proyecto.sinergia.repositories.TransactionRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getEmpresas(){
        return this.empresaRepository.findAll();
    }

    public void createEmpresa(Empresa empresa){
        empresaRepository.save(empresa);
    }

    public Empresa getEmpresaById(@PathVariable("id") long empresaId){
        return empresaRepository.findById(empresaId).get();
    }

    public void deleteEmpresa(@PathVariable("id") long empresaId){
        empresaRepository.deleteById(empresaId);
    }

    public ResponseEntity<Empresa> updateEmpresa(@PathVariable("id") long id, @RequestBody Empresa empresa){
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
        if (optionalEmpresa.isPresent()) {
            Empresa updatedEmpresa = optionalEmpresa.get();
            updatedEmpresa.setNombreEmpresa(empresa.getNombreEmpresa());
            updatedEmpresa.setNitEmpresa(empresa.getNitEmpresa());
            updatedEmpresa.setDireccionEmpresa(empresa.getDireccionEmpresa());
            updatedEmpresa.setTelefonoEmpresa(empresa.getTelefonoEmpresa());
            empresaRepository.save(updatedEmpresa);
            return ResponseEntity.ok(updatedEmpresa);
        }else
            return ResponseEntity.notFound().build();
    }

    /*public List<Transaction> getTransactionsByEmpresaId(@PathVariable("id") long empresaId){
        return empresaRepository.findById(empresaId).get().getMovimientoDinero();

        Optional<List<Transaction>> optionalEmpresa = empresaRepository.findById(empresaId);
        if(((java.util.Optional<List<Transaction>>) optionalEmpresa).isPresent()) {
            return Optional.of(optionalEmpresa.get().getMovimientoDinero());
        }else
            return Optional.empty();*/


}
