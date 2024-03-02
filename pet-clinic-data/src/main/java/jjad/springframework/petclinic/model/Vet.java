package jjad.springframework.petclinic.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vets")
public class Vet extends Person{

    @Builder
    public Vet(Long id, String firstName, String lastName, Set<Specialty> specialties) {
        super(id, firstName, lastName);
        this.specialties = specialties;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialty",
                joinColumns = @JoinColumn(name = "vet_id"),
                inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();
}
