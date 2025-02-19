package br.com.pet.service;

import br.com.pet.dto.FindOwners;
import br.com.pet.dto.OwnerResponse;
import br.com.pet.dto.UpdateOwner;
import br.com.pet.entity.Owner;
import br.com.pet.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OwnerService {

     private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner RegisterOwner(OwnerResponse ownerResponse){
        var register = new Owner(ownerResponse);
        return ownerRepository.save(register);
    }

    public List<FindOwners> findOwners(){
        return ownerRepository.findAll().stream().map(FindOwners::new).toList();
    }

    public Owner findById(Long id){
        Optional<Owner> find = ownerRepository.findById(id);
        return find.orElseThrow();
    }

    public Owner updateOwner(UpdateOwner owner,long id){
        var update = new Owner(owner);
        update.setId(id);
        return ownerRepository.save(update);
    }

    public List<FindOwners>findByName(String name){
        return ownerRepository.findByName(name.trim().toUpperCase());
    }

    public void deletOwnerById(Long id){
        ownerRepository.deleteById(id);
    }
}
