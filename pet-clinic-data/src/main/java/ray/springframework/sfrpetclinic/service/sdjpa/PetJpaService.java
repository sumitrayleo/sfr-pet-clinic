package ray.springframework.sfrpetclinic.service.sdjpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ray.springframework.sfrpetclinic.model.Pet;
import ray.springframework.sfrpetclinic.repository.PetRepository;
import ray.springframework.sfrpetclinic.service.PetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService {

    private final PetRepository petRepository;

    public PetJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }
}
