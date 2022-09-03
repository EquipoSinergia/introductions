package proyecto.sinergia.services;

import org.springframework.stereotype.Service;
import proyecto.sinergia.entities.Empresa;
import proyecto.sinergia.repositories.EmpresaRepository;

import java.util.List;

@Service
public class EmpresaService {
    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getEmpresas(){
        return this.empresaRepository.findAll();
    }
}
