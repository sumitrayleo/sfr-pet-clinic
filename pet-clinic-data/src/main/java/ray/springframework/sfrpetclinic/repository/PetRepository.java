package ray.springframework.sfrpetclinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ray.springframework.sfrpetclinic.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
