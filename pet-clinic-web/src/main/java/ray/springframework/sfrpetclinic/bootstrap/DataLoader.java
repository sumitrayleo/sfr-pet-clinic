package ray.springframework.sfrpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ray.springframework.sfrpetclinic.model.*;
import ray.springframework.sfrpetclinic.service.OwnerService;
import ray.springframework.sfrpetclinic.service.PetTypeService;
import ray.springframework.sfrpetclinic.service.SpecialtyService;
import ray.springframework.sfrpetclinic.service.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        // Setup PetType
        PetType savedDogPetType = getPetType("Dog");
        PetType savedCatPetType = getPetType("Cat");

        // Setup Specialties
        Specialty radiology = getSpecialty("Radiology");
        Specialty surgery = getSpecialty("Surgery");
        Specialty dentistry = getSpecialty("Dentistry");

        Owner owner1 = new Owner();
        owner1.setFirstName("Rajiv");
        owner1.setLastName("Das");
        owner1.setAddress("123 Lakerun ct");
        owner1.setCity("St Louis");
        owner1.setTelephone("12376543");

        Pet rajivsDog = new Pet();
        rajivsDog.setName("Kiko");
        rajivsDog.setDateOfBirth(LocalDate.now());
        rajivsDog.setOwner(owner1);
        rajivsDog.setPetType(savedDogPetType);
        owner1.getPets().add(rajivsDog);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mark");
        owner2.setLastName("Cocoo");
        owner2.setAddress("123 Lakerun ct");
        owner2.setCity("St Louis");
        owner2.setTelephone("12376543");

        Pet marksCast = new Pet();
        marksCast.setName("Milo");
        marksCast.setDateOfBirth(LocalDate.now());
        marksCast.setOwner(owner2);
        marksCast.setPetType(savedCatPetType);
        owner2.getPets().add(marksCast);
        ownerService.save(owner2);

        System.out.println("Added 2 Owners ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Lauren");
        vet1.setLastName("Riju");
        vet1.getSpecialties().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Madan");
        vet2.setLastName("Yu");
        vet2.getSpecialties().add(surgery);
        vetService.save(vet2);

        System.out.println("Added 2 Vets ....");
    }

    private Specialty getSpecialty(String specialtyDesc) {
        Specialty specialty = new Specialty();
        specialty.setDescription(specialtyDesc);
        return specialty;
    }

    private PetType getPetType(String petName) {
        PetType dog = new PetType();
        dog.setName(petName);
        return petTypeService.save(dog);
    }
}