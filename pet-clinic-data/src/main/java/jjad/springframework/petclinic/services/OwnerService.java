package jjad.springframework.petclinic.services;

import jjad.springframework.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

    Owner findById(Long id);

}
