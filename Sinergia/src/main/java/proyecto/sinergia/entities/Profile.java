package proyecto.sinergia.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="profile")
public class Profile {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "image")
    private String image;
    @Column(name = "phone")
    private String phone;
    @CreatedDate
    @Column(name="created_At")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name="updated_At")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;

    public Profile(){

    }

    public Profile(String image, String phone, Employee employee) {
        this.image = image;
        this.phone = phone;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
