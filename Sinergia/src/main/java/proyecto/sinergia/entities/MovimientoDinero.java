package proyecto.sinergia.entities;
import java.time.LocalDate;

public class MovimientoDinero {
    int nroTransaccion;
    LocalDate fechaCreacionMto;
    LocalDate fechaActualizMto;
    String conceptoMto;
    double montoMto;

    String usuario;

    public MovimientoDinero(int Nrotransaccion, LocalDate fechaCreacionMto, LocalDate fechaActualizMto, String ConceptoMto, double MontoMto, String usuario){
        this.nroTransaccion =Nrotransaccion;
        this.fechaCreacionMto=fechaCreacionMto;
        this.fechaActualizMto=fechaActualizMto;
        this.conceptoMto =ConceptoMto;
        this.montoMto =MontoMto;
        this.usuario = usuario;
    }

    public int getNroTransaccion(){
        return this.nroTransaccion;
    }

    public void setNroTransaccion(int Nrotransaccion) {
        this.nroTransaccion = nroTransaccion;
    }

    public LocalDate getfechaCreacionMto(){
        return this.fechaCreacionMto;
    }

    public void setfechaCreacionMto(LocalDate fechaCreacionMto) {
        this.fechaCreacionMto = fechaCreacionMto;
    }
    public LocalDate getfechaActualizMto(){
        return this.fechaActualizMto;
    }

    public void setfechaActualizMto(LocalDate fechaActualizMto) {
        this.fechaActualizMto = fechaActualizMto;
    }

    public String getConceptoMto(){
        return this.conceptoMto;
    }

    public void setConceptoMto(String ConceptoMto) {
        this.conceptoMto = ConceptoMto;
    }

    public double getMontoMto(){
        return this.montoMto;
    }

    public void setMontoMto(double MontoMto) {
        this.montoMto = MontoMto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
