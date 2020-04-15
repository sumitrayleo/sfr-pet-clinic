package ray.springframework.sfrpetclinic.service.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ray.springframework.sfrpetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    private final Long ID = 1L;
    final String lastName = "Das";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Owner owner = Owner.builder().id(ID).build();
        owner.setLastName(lastName);
        ownerMapService.save(owner);
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ID);
        assertEquals(ID, owner.getId());
    }

    @Test
    void saveIdExists() {
        ownerMapService.save(Owner.builder().id(2L).build());
        assertEquals(2, ownerMapService.findAll().size());
    }

    @Test
    void saveNoIdExists() {
        Owner owner = ownerMapService.save(Owner.builder().build());
        assertNotNull(owner);
        assertNotNull(owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ID));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ID);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());
    }
}