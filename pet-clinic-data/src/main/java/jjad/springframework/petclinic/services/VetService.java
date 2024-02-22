package jjad.springframework.petclinic.services;

import jjad.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet pet);

    Set<Vet> findAll(Long id);

}
