package jjad.springframework.petclinic.bootstrap;

import jjad.springframework.petclinic.model.Owner;
import jjad.springframework.petclinic.model.Vet;
import jjad.springframework.petclinic.services.OwnerService;
import jjad.springframework.petclinic.services.VetService;
import jjad.springframework.petclinic.services.map.OwnerServiceMap;
import jjad.springframework.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
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
        vet.setFirstName("Jose");
        vet.setLastName("Alvarado");
        vetService.save(vet);

        vet = new Vet();
        vet.setId(2L);
        vet.setFirstName("Jesus");
        vet.setLastName("Dominguez");
        vetService.save(vet);

        System.out.println("Loaded Vets.......");
    }

}
