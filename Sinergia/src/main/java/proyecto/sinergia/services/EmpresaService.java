package proyecto.sinergia.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import proyecto.sinergia.entities.Empresa;
import proyecto.sinergia.repositories.EmpresaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getEmpresas(){
        return this.empresaRepository.findAll();
    }

    public Empresa createEmpresa(Empresa newEmpresa){
        return this.empresaRepository.save(newEmpresa);
    }

    public Optional<Empresa> getEmpresaById(@PathVariable("id") Long empresaId){
        java.util.Optional<Empresa> optionalEmpresa = empresaRepository.findById(empresaId);
        if(((java.util.Optional<Empresa>) optionalEmpresa).isPresent()) {
            return Optional.of(optionalEmpresa.get());
        }else
            return Optional.empty();
    }

}
