package br.com.pet.dto;

import br.com.pet.entity.Owner;
import br.com.pet.entity.Pet;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OwnerResponse {

    private String dateRegister = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    private String name;
    private String phone;
    private List<Pet> pets;

    public OwnerResponse() {
    }

    public OwnerResponse(Owner register) {
        this.dateRegister = register.getDateRegister();
        this.name = register.getName();
        this.phone = register.getPhone();
        this.pets = register.getPets();
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
