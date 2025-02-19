package br.com.pet.repository;

import br.com.pet.dto.FindPets;
import br.com.pet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Long> {
    List<FindPets> findByName(String Name);
}
