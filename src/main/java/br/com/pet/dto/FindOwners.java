package br.com.pet.dto;

import br.com.pet.entity.Owner;
import br.com.pet.entity.Pet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FindOwners {
    private Long id;
    private String dateRegister = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    private String name;
    private String phone;
    private List<Pet>pets;

    public FindOwners() {
    }
    public FindOwners(Owner owner) {
        this.id = owner.getId();
        this.dateRegister = owner.getDateRegister();
        this.name = owner.getName();
        this.phone = owner.getPhone();
        this.pets = owner.getPets();

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
