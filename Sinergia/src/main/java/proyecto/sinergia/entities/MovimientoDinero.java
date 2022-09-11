package proyecto.sinergia.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class MovimientoDinero {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "concept")
    private String conceptoMto;
    @Column(name = "amount")
    private float montoMto;
    //@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "employee_id")
    //@JsonIgnore
    private Employee employee;
    //@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    //@JsonIgnore
    private Empresa empresa;
    @CreatedDate
    @Column(name="created_At")
    @CreationTimestamp
    private LocalDateTime fechaCreacionMto;
    @LastModifiedDate
    @Column(name="updated_At")
    @UpdateTimestamp
    private LocalDateTime fechaActualizMto;


    public MovimientoDinero() {

    }

    public MovimientoDinero(String conceptoMto, float montoMto, Employee employee, Empresa empresa) {
        this.conceptoMto = conceptoMto;
        this.montoMto = montoMto;
        this.employee = employee;
        this.empresa = employee.getEmpresa();
    }

    public String getConceptoMto() {
        return conceptoMto;
    }

    public void setConceptoMto(String conceptoMto) {
        this.conceptoMto = conceptoMto;
    }

    public float getMontoMto() {
        return montoMto;
    }

    public void setMontoMto(float montoMto) {
        this.montoMto = montoMto;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getFechaCreacionMto() {
        return fechaCreacionMto;
    }

    public LocalDateTime getFechaActualizMto() {
        return fechaActualizMto;
    }
}
