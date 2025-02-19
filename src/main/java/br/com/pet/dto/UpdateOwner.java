package br.com.pet.dto;

import br.com.pet.entity.Owner;

public class UpdateOwner {
    private Long id;
    private String name;
    private String phone;

    public UpdateOwner() {
    }

    public UpdateOwner(Owner update) {
        this.id = update.getId();
        this.name = update.getName();
        this.phone = update.getPhone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
