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
    @Column(name="createdAt")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name="updatedAt")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Profile(){

    }


}
