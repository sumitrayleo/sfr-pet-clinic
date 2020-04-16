package ray.springframework.sfrpetclinic.service.sdjpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ray.springframework.sfrpetclinic.model.Owner;
import ray.springframework.sfrpetclinic.repository.OwnerRepository;
import ray.springframework.sfrpetclinic.repository.PetRepository;
import ray.springframework.sfrpetclinic.repository.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {
    public static final String LAST_NAME = "Ray";

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerJpaService service;

    Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = new Owner();
        returnedOwner.setId(1L);
        returnedOwner.setLastName(LAST_NAME);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);
        Owner owner = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
        Owner owner = service.findById(1L);

        assertNotNull(owner);
        assertEquals(1L, owner.getId());
        verify(ownerRepository).findById(anyLong());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().build();
        when(ownerRepository.save(any())).thenReturn(returnedOwner);
        Owner savedOwner = service.save(owner);

        assertNotNull(savedOwner);
        assertEquals(1L, savedOwner.getId());
        verify(ownerRepository).save(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> returnedOwners = service.findAll();

        assertNotNull(returnedOwners);
        assertEquals(2, returnedOwners.size());
        verify(ownerRepository).findAll();
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void delete() {
        service.delete(returnedOwner);

        verify(ownerRepository).delete(any());
    }
}