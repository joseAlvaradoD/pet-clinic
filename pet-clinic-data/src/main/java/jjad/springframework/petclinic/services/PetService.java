package jjad.springframework.petclinic.services;

import jjad.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll(Long id);

}
