package br.com.pet.dto;

import br.com.pet.entity.Owner;
import br.com.pet.entity.Pet;
import br.com.pet.enums.Type;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class FindPets {
    private Long id;
    private Type type;
    private String name;
    private int age;
    private String race;
    private String observation;
    private Owner owners;

    public FindPets() {
    }

    public FindPets(Pet pet) {
        this.id = pet.getId();
        this.type = pet.getType();
        this.name = pet.getName();
        this.age = pet.getAge();
        this.race = pet.getRace();
        this.observation = pet.getObservation();
        this.owners = pet.getOwners();

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
