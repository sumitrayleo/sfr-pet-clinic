package ray.springframework.sfrpetclinic.service.sdjpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ray.springframework.sfrpetclinic.model.Owner;
import ray.springframework.sfrpetclinic.repository.OwnerRepository;
import ray.springframework.sfrpetclinic.repository.PetRepository;
import ray.springframework.sfrpetclinic.repository.PetTypeRepository;
import ray.springframework.sfrpetclinic.service.OwnerService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }
}