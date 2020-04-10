package ray.springframework.sfrpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ray.springframework.sfrpetclinic.model.Owner;
import ray.springframework.sfrpetclinic.model.PetType;
import ray.springframework.sfrpetclinic.model.Vet;
import ray.springframework.sfrpetclinic.service.OwnerService;
import ray.springframework.sfrpetclinic.service.PetTypeService;
import ray.springframework.sfrpetclinic.service.VetService;

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
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Rajiv");
        owner1.setLastName("Das");

        Owner owner2 = new Owner();
        owner2.setFirstName("Mark");
        owner2.setLastName("Cocoo");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Added 2 Owners ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Lauren");
        vet1.setLastName("Riju");

        Vet vet2 = new Vet();
        vet2.setFirstName("Madan");
        vet2.setLastName("Yu");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Added 2 Vets ....");
    }
}