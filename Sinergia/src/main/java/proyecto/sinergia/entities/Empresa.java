package proyecto.sinergia.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.*;


@Entity
@Table(name="empresas")
public class Empresa {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name", unique = true)
    private String nombreEmpresa;
    @Column(name="document", unique = true)
    private String nitEmpresa;
    @Column(name="address")
    private String direccionEmpresa;
    @Column(name = "phone")
    private String telefonoEmpresa;
    @Column(name="createdAt")
    private LocalDate fechaCreacion;
    @Column(name="updatedAt")
    private LocalDate fechaActualizacion;

    public Empresa(){

    }

    public Empresa(String nombreEmpresa, String nitEmpresa, String direccionEmpresa, String telefonoEmpresa, LocalDate fechaCreacion, LocalDate fechaActualizacion) {
        this.nombreEmpresa = nombreEmpresa;
        this.nitEmpresa = nitEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
