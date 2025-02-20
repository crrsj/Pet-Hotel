package br.com.pet.dto;

import br.com.pet.entity.Owner;
import br.com.pet.entity.Pet;
import br.com.pet.enums.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PetDto {

    private Type type;
    @NotBlank(message = "cannot be blank !")
    private String name;
    @NotNull(message = "cannot be null !")
    private int age;
    @NotBlank(message = "cannot be blank !")
    private String race;
    private String observation;
    private Owner owners;

    public PetDto() {
    }

    public PetDto(Pet register) {
        this.type = register.getType();
        this.name = register.getName();
        this.age = register.getAge();
        this.race = register.getRace();
        this.observation = register.getObservation();
        this.owners = register.getOwners();
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
