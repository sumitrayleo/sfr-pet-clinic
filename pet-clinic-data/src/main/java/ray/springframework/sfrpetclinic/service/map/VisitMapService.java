package ray.springframework.sfrpetclinic.service.map;

import org.springframework.stereotype.Service;
import ray.springframework.sfrpetclinic.model.Visit;
import ray.springframework.sfrpetclinic.service.VisitService;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null ||
            visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit data!!");
        }
        return super.save(visit);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}