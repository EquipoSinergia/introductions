package proyecto.sinergia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.sinergia.entities.Empresa;
import proyecto.sinergia.repositories.EmpresaRepository;
import proyecto.sinergia.services.EmpresaService;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @GetMapping("/empresas")
    public  List<Empresa> getEmpresas(){
        return this.empresaService.getEmpresas();
    }

    @PostMapping("/empresas")
    public Empresa createEmpresa(@RequestBody Empresa empresa){
        return this.empresaService.createEmpresa(empresa);
    }

    //Metodo para listar Empresas por su Id
    @GetMapping("/empresas/{id}")
    public Optional<Empresa> getEmpresaById(@PathVariable("id") long id){
        return this.empresaService.getEmpresaById(id);
    }

    @DeleteMapping(value = "/empresas/{id}")
    public void deleteEmpresa(@PathVariable("id") long id) {
        empresaService.deleteEmpresa(id);
    }






}
