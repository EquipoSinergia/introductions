package proyecto.sinergia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import proyecto.sinergia.entities.Empresa;
import proyecto.sinergia.repositories.EmpresaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getEmpresas(){
        return this.empresaRepository.findAll();
    }

    public void createEmpresa(Empresa empresa){
        empresaRepository.save(empresa);
    }

    public Optional<Empresa> getEmpresaById(@PathVariable("id") long empresaId){
        java.util.Optional<Empresa> optionalEmpresa = empresaRepository.findById(empresaId);
        if(((java.util.Optional<Empresa>) optionalEmpresa).isPresent()) {
            return Optional.of(optionalEmpresa.get());
        }else
            return Optional.empty();
    }

    public void deleteEmpresa(@PathVariable("id") long empresaId){
        empresaRepository.deleteById(empresaId);
    }

    public ResponseEntity<Empresa> updateEmpresa(@RequestBody Empresa empresa){
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(empresa.getId());
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

}
