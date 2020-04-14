package ray.springframework.sfrpetclinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ray.springframework.sfrpetclinic.model.Vet;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}
