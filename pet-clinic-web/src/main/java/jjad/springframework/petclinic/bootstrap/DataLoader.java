package jjad.springframework.petclinic.bootstrap;

import jjad.springframework.petclinic.model.*;
import jjad.springframework.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        radiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        surgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        dentistry = specialtyService.save(dentistry);

        System.out.println("Loaded Specialties.......");

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

        owner.getPets().add(josesPet);

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

        owner.getPets().add(jesusPet);

        ownerService.save(owner);

        System.out.println("Loaded Owners.......");

        Visit visit = new Visit();
        visit.setPet(jesusPet);
        visit.setDescription("Sneezy kitty");
        visit.setDate(LocalDate.now());

        visitService.save(visit);

        System.out.println("Loaded Visits.......");

        Vet vet = new Vet();
        vet.setFirstName("Joe");
        vet.setLastName("Johnson");
        vet.getSpecialties().add(surgery);
        vet.getSpecialties().add(radiology);

        vetService.save(vet);

        vet = new Vet();
        vet.setFirstName("John");
        vet.setLastName("Smith");
        vet.getSpecialties().add(dentistry);
        vetService.save(vet);

        System.out.println("Loaded Vets.......");
    }

}
