package ray.springframework.sfrpetclinic.service.sdjpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ray.springframework.sfrpetclinic.model.Visit;
import ray.springframework.sfrpetclinic.repository.VisitRepository;
import ray.springframework.sfrpetclinic.service.VisitService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitJpaService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }
}