package br.com.pet.repository;


import br.com.pet.dto.FindOwners;
import br.com.pet.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
    @Query(value = "select o from Owner o where upper(trim(o.name)) like %?1% ")
    List<FindOwners> findByName(String name);
}
