package ray.springframework.sfrpetclinic.service.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ray.springframework.sfrpetclinic.model.Specialty;
import ray.springframework.sfrpetclinic.model.Vet;
import ray.springframework.sfrpetclinic.service.SpecialtyService;
import ray.springframework.sfrpetclinic.service.VetService;

import java.util.Set;

@Service
@Profile({"default", "mock"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {

        if(vet != null){
            vet.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null){
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(vet);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
