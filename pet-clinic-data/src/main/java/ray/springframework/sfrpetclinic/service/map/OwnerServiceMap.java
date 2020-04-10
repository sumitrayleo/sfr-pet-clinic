package ray.springframework.sfrpetclinic.service.map;

import org.springframework.stereotype.Service;
import ray.springframework.sfrpetclinic.model.Owner;
import ray.springframework.sfrpetclinic.service.OwnerService;
import ray.springframework.sfrpetclinic.service.PetService;
import ray.springframework.sfrpetclinic.service.PetTypeService;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if(owner != null){
            // if owner has any pets
            if(owner.getPets() != null){
                // iterate over each pets
                owner.getPets().forEach(pet ->{
                    // if PetType is set for each Pet; else throw RuntimeException
                    if(pet.getPetType() != null){
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    } else {
                        throw new RuntimeException("PetType is required!!");
                    }
                    // Make sure Pet is saved before saving the owner
                    if(pet.getId() == null){
                        pet.setId(petService.save(pet).getId());
                    }
                });
            }
            return super.save(owner);
        } else {
            return null;
        }

    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
