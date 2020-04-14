package ray.springframework.sfrpetclinic.service.sdjpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ray.springframework.sfrpetclinic.model.Vet;
import ray.springframework.sfrpetclinic.repository.VetRepository;
import ray.springframework.sfrpetclinic.service.VetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }
}
