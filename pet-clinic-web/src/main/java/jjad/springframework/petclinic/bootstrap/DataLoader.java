package jjad.springframework.petclinic.bootstrap;

import jjad.springframework.petclinic.model.Owner;
import jjad.springframework.petclinic.model.Vet;
import jjad.springframework.petclinic.services.OwnerService;
import jjad.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService){
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Jose");
        owner.setLastName("Alvarado");
        ownerService.save(owner);

        owner = new Owner();
        owner.setId(2L);
        owner.setFirstName("Jesus");
        owner.setLastName("Dominguez");
        ownerService.save(owner);

        System.out.println("Loaded Owners.......");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Joe");
        vet.setLastName("Johnson");
        vetService.save(vet);

        vet = new Vet();
        vet.setId(2L);
        vet.setFirstName("John");
        vet.setLastName("Smith");
        vetService.save(vet);

        System.out.println("Loaded Vets.......");
    }

}
