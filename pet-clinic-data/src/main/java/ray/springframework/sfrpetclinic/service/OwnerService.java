package ray.springframework.sfrpetclinic.service;

import ray.springframework.sfrpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
