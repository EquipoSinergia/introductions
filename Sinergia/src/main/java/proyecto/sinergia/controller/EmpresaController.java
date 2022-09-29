package proyecto.sinergia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proyecto.sinergia.entities.Empresa;
import proyecto.sinergia.services.EmpresaService;

import java.util.Optional;

@Controller
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @GetMapping("/enterprises")
    public String getEmpresas(Model model){
        model.addAttribute("empresas", empresaService.getEmpresas());
        return "enterprises";
    }

    @GetMapping("/agregar-empresa")
    public String formularioCrearEmpresa(Empresa empresa){
        return "agregar-empresa";
    }

    @PostMapping("/enterprises")
    public String createEmpresa(Empresa empresa){
        empresaService.createEmpresa(empresa);
        return "redirect:/enterprises";
    }

    @GetMapping("/enterprises/eliminar/{id}")
    public String deleteEmpresa(@PathVariable("id") long id) {
        empresaService.deleteEmpresa(id);
        return "redirect:/enterprises";
    }

    @GetMapping("/enterprises/editar/{id}")
    public String editarEmpresa(@PathVariable("id") long id, Model model) {
        Empresa empresa = empresaService.getEmpresaById(id);
        model.addAttribute("empresa", empresa);
        return "editar-empresa";
    }

    @PostMapping("/enterprises/actualizar/{id}")
    public String updateEmpresa(@PathVariable("id") long id, Empresa empresa) {
        empresaService.updateEmpresa(id, empresa);
        return "redirect:/enterprises";
    }

    /*
    //Metodo para listar Empresas por su Id
    @GetMapping("/enterprises/{id}")
    public Optional<Empresa> getEmpresaById(@PathVariable("id") long id){
        return this.empresaService.getEmpresaById(id);
    }

    /*@GetMapping("/enterprises/{id}/movements")
    public List<Transaction> getTransactionsByEmpresaId(@PathVariable("id") long id){
        return this.empresaService.getTransactionsByEmpresaId(id);
    }*/

}
