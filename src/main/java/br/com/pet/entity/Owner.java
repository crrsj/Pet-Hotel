package br.com.pet.entity;


import br.com.pet.dto.OwnerResponse;
import br.com.pet.dto.UpdateOwner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Entity
@Table(name = "tb_owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateRegister = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    private String name;
    private String phone;
    @JsonIgnore
    @OneToMany(mappedBy = "owners",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Pet>pets;

    public Owner() {
    }

    public Owner(OwnerResponse ownerResponse) {
        this.dateRegister = ownerResponse.getDateRegister();
        this.name = ownerResponse.getName();
        this.phone = ownerResponse.getPhone();
        this.pets = ownerResponse.getPets();
    }

    public Owner(UpdateOwner owner) {
        this.id = owner.getId();
        this.name  = owner.getName();;
        this.phone = owner.getPhone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
