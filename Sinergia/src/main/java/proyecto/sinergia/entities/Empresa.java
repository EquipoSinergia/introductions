package proyecto.sinergia.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import java.time.*;
import java.util.List;


@Entity
@Table(name="Enterprise")
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
    @JsonIgnore
    @OneToMany(mappedBy = "empresa", orphanRemoval = true, cascade = {CascadeType.ALL})
    private List<Employee> user;

    //@JsonBackReference
    //@JsonIgnore
    //@OneToMany(mappedBy = "empresa", orphanRemoval = true, cascade = CascadeType.ALL)
    //private List<Transaction> movimientoDinero;
    @CreatedDate
    @Column(name="created_At", updatable = false)
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
    @LastModifiedDate
    @Column(name="updated_At")
    @UpdateTimestamp
    private LocalDateTime fechaActualizacion;


    public Empresa(){

    }

    public Empresa(String nombreEmpresa, String nitEmpresa, String direccionEmpresa, String telefonoEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.nitEmpresa = nitEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public long getId() {
        return id;
    }

    public List<Employee> getUser() {
        return user;
    }

    //public List<Transaction> getMovimientoDinero() {
    //    return movimientoDinero;
    //}




}
