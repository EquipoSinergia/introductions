package proyecto.sinergia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    //Atributos
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "email", unique = true)
    private String correo;

    //@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    //@JsonIgnore
    private Empresa empresa;

    //@JsonBackReference
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MovimientoDinero> movimientosDinero;
    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Enum_RoleName rol;
    @CreatedDate
    @Column(name="created_At")
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
    @LastModifiedDate
    @Column(name="updated_At")
    @UpdateTimestamp
    private LocalDateTime fechaActualizacion;

    //constructor

    public Employee(){

    }

    public Employee(String correo, Empresa empresa, Enum_RoleName rol) {
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Enum_RoleName getRol() {
        return rol;
    }

    public void setRol(Enum_RoleName rol) {
        this.rol = rol;
    }

    public long getId() {
        return id;
    }

    public List<MovimientoDinero> getMovimientosDinero() {
        return movimientosDinero;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
}
