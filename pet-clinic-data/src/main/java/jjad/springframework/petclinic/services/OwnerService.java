package jjad.springframework.petclinic.services;

import jjad.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
