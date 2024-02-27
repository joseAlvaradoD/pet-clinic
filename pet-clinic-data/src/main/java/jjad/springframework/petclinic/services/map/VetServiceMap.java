package jjad.springframework.petclinic.services.map;

import jjad.springframework.petclinic.model.Vet;
import jjad.springframework.petclinic.services.SpecialtyService;
import jjad.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap
        extends AbstractMapService<Vet, Long>
        implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object != null){
            if(object.getSpecialties().size() > 0){
                object.getSpecialties().forEach(specialty -> {
                    if(specialty.getId() == null){
                        specialty.setId(specialtyService.save(specialty).getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }

    }

}