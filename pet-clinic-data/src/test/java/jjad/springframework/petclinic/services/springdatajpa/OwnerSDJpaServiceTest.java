package jjad.springframework.petclinic.services.springdatajpa;

import jjad.springframework.petclinic.model.Owner;
import jjad.springframework.petclinic.repositories.OwnerRepository;
import jjad.springframework.petclinic.repositories.PetRepository;
import jjad.springframework.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    public static final Long ID = 1L;
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;
    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        //given
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(ID).build());

        //when
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> returnedOwners = ownerSDJpaService.findAll();

        //then
        assertNotNull(returnedOwners);
        assertEquals(1, returnedOwners.size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById() {

        //when
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner returnedOwner = ownerSDJpaService.findById(ID);

        //then
        assertNotNull(returnedOwner);
        verify(ownerRepository, times(1)).findById(anyLong());
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(ID);

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        //given
        Owner expectedOwner = Owner.builder().lastName(LAST_NAME).build();

        //when
        when(ownerRepository.findByLastName(any())).thenReturn(expectedOwner);
        Owner returnedOwner = ownerSDJpaService.findByLastName(LAST_NAME);

        //then
        assertEquals(expectedOwner.getLastName(), returnedOwner.getLastName());
        verify(ownerRepository, times(1)).findByLastName(any());
    }
}