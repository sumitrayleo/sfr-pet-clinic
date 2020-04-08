package ray.springframework.sfrpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ray.springframework.sfrpetclinic.model.Owner;
import ray.springframework.sfrpetclinic.model.Vet;
import ray.springframework.sfrpetclinic.service.OwnerService;
import ray.springframework.sfrpetclinic.service.VetService;

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
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Rajiv");
        owner1.setLastName("Das");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mark");
        owner2.setLastName("Cocoo");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Added 2 Owners ....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Lauren");
        vet1.setLastName("Riju");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Madan");
        vet2.setLastName("Yu");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Added 2 Vets ....");
    }
}