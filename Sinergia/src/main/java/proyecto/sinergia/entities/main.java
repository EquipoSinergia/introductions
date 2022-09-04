package proyecto.sinergia.entities;
import java.time.*;

public class main {

    public static void main(String[] args) {

        Empresa sinergia = new Empresa("sinergia", "CALLE 1 32 23", "545321", "900254864");

        System.out.println("Se crea la empresa "+sinergia.getNombreEmpresa()+" ubicada en la dirección " + sinergia.getDireccionEmpresa() + "con teléfono " + sinergia.getTelefonoEmpresa()+" y tiene NIT "+sinergia.getNitEmpresa());

        Empleado juanperez = new Empleado(1,"Juan Perez","juanperez@sinergia.com", "Sinergia","Administrador");

        System.out.println("El empleado con id "+juanperez.getId()+" se llama "+juanperez.getNombre()+", su correo electrónico es: "+juanperez.getCorreo()+" pertenece a la empresa "+juanperez.getEmpresa()+" con el rol "+juanperez.getRol());

        MovimientoDinero transaccion1 = new MovimientoDinero (1, LocalDate.of(2022, 8, 24), LocalDate.of(2022, 8, 26), "pagoAgosto", 545000,"juan.perez");

        System.out.println("fecha de creacion "+ transaccion1.getfechaCreacionMto());

    }
}
