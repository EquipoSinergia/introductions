package proyecto.sinergia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import proyecto.sinergia.entities.Empresa;
import proyecto.sinergia.services.EmpresaService;

import java.util.List;

@RestController
public class EmpresaController {

    EmpresaService empresaService;

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




}
