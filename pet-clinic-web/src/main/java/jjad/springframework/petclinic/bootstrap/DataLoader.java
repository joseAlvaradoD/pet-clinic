package jjad.springframework.petclinic.bootstrap;

import jjad.springframework.petclinic.model.Owner;
import jjad.springframework.petclinic.model.Pet;
import jjad.springframework.petclinic.model.PetType;
import jjad.springframework.petclinic.model.Vet;
import jjad.springframework.petclinic.services.OwnerService;
import jjad.springframework.petclinic.services.PetTypeService;
import jjad.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);
        System.out.println("Loaded Pet Types.......");

        Owner owner = new Owner();
        owner.setFirstName("Jose");
        owner.setLastName("Alvarado");
        owner.setAddress("123 ST");
        owner.setCity("Mexico City");
        owner.setTelephone("123456790");

        Pet josesPet = new Pet();
        josesPet.setPetType(savedDogPetType);
        josesPet.setOwner(owner);
        josesPet.setName("Rocky");
        josesPet.setBirthDate(LocalDate.now());

        ownerService.save(owner);

        owner = new Owner();
        owner.setFirstName("Jesus");
        owner.setLastName("Dominguez");
        owner.setAddress("444 ST");
        owner.setCity("Mexico City");
        owner.setTelephone("9123456780");

        Pet jesusPet = new Pet();
        jesusPet.setPetType(savedCatPetType);
        jesusPet.setOwner(owner);
        jesusPet.setName("Rosco");
        jesusPet.setBirthDate(LocalDate.now());

        ownerService.save(owner);

        System.out.println("Loaded Owners.......");

        Vet vet = new Vet();
        vet.setFirstName("Joe");
        vet.setLastName("Johnson");
        vetService.save(vet);

        vet = new Vet();
        vet.setFirstName("John");
        vet.setLastName("Smith");
        vetService.save(vet);

        System.out.println("Loaded Vets.......");
    }

}
