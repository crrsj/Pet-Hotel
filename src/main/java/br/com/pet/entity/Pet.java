package br.com.pet.entity;

import br.com.pet.dto.PetDto;
import br.com.pet.dto.UpdatePets;
import br.com.pet.enums.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String name;
    private int age;
    private String race;
    private String observation;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owners;

    public Pet() {
    }

    public Pet(PetDto petDto) {
        this.type = petDto.getType();
        this.name = petDto.getName();
        this.age = petDto.getAge();
        this.race = petDto.getRace();
        this.observation = petDto.getObservation();
    }

    public Pet(UpdatePets updatePets) {
        this.id = updatePets.getId();
        this.type = updatePets.getType();
        this.name = updatePets.getName();
        this.age = updatePets.getAge();
        this.race = updatePets.getRace();
        this.observation = updatePets.getObservation();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Owner getOwners() {
        return owners;
    }

    public void setOwners(Owner owners) {
        this.owners = owners;
    }
}





