package proyecto.sinergia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.sinergia.entities.Empresa;
import proyecto.sinergia.entities.MovimientoDinero;
import proyecto.sinergia.services.EmpresaService;
import java.util.List;
import java.util.Optional;

@RestController
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @GetMapping("/enterprises")
    public  List<Empresa> getEmpresas(){
        return this.empresaService.getEmpresas();
    }

    @PostMapping("/enterprises")
    public void createEmpresa(@RequestBody Empresa empresa){
        empresaService.createEmpresa(empresa);
    }

    //Metodo para listar Empresas por su Id
    @GetMapping("/enterprises/{id}")
    public Optional<Empresa> getEmpresaById(@PathVariable("id") long id){
        return this.empresaService.getEmpresaById(id);
    }

    @DeleteMapping(value = "/enterprises/{id}")
    public void deleteEmpresa(@PathVariable("id") long id) {
        empresaService.deleteEmpresa(id);
    }

    @PutMapping(value = "/enterprises/{id}")
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable("id") long id, @RequestBody Empresa empresa){
        return this.empresaService.updateEmpresa(id, empresa);
    }

    /*@GetMapping("/enterprises/{id}/movements")
    public List<MovimientoDinero> getTransactionsByEmpresaId(@PathVariable("id") long id){
        return this.empresaService.getTransactionsByEmpresaId(id);
    }*/

}
