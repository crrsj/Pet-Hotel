package br.com.pet.service;


import br.com.pet.dto.FindPets;
import br.com.pet.dto.PetDto;
import br.com.pet.dto.UpdatePets;
import br.com.pet.entity.Owner;
import br.com.pet.entity.Pet;
import br.com.pet.repository.OwnerRepository;
import br.com.pet.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public PetService(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    public Pet registerPet(PetDto petDto, Long ownerId){
        var register = new Pet(petDto);
        var owner = ownerRepository.findById(ownerId).orElseThrow();
        register.setOwners(owner);
        return petRepository.save(register);
    }

    public List<FindPets>findAllPets(){
        return petRepository.findAll().stream().map(FindPets::new).toList();
    }

    public Pet findById(Long id){
        Optional<Pet> findPet = petRepository.findById(id);
        return findPet.orElseThrow();
    }

    public Pet updatePet(UpdatePets updatePets,Long id){
        var update = new Pet(updatePets);
        update.setId(id);
        return petRepository.save(update);
    }

    public List<FindPets>findByName(String name){
        return petRepository.findByName(name.trim().toUpperCase());

    }



    public void deletePets(Long id){
        petRepository.findById(id);
    }
}
