package ray.springframework.sfrpetclinic.service;

import java.util.Set;

public interface CrudService<T, ID> {
    T findById(ID id);
    T save(T t);
    Set<T> findAll();
}
