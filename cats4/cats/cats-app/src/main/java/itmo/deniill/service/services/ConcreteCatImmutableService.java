package itmo.deniill.service.services;

import itmo.deniill.CatDto;
import itmo.deniill.dao.entities.Cat;
import itmo.deniill.dao.repositories.CatRepository;
import itmo.deniill.service.mappers.CatMapper;
import itmo.deniill.service.specification.CatFields;
import itmo.deniill.service.specification.CatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static itmo.deniill.service.specification.CatSpecification.getSpecificationFromFilters;

@Service
@Transactional(readOnly = true)
public class ConcreteCatImmutableService implements CatImmutableService {
    private final CatRepository catRepository;

    @Autowired
    public ConcreteCatImmutableService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public List<CatDto> getCatsByCriteria(String id, String name, String breed, String colour, String ownerId) {
        ArrayList<CatFilter> catFilters = new ArrayList<>();
        if(id != null) {
            catFilters.add(new CatFilter(CatFields.id, id));
        }
        if (breed != null) {
            catFilters.add(new CatFilter(CatFields.breed, breed));
        }
        if (colour != null) {
            catFilters.add(new CatFilter(CatFields.colour, colour));
        }
        if (name != null) {
            catFilters.add(new CatFilter(CatFields.name, name));
        }
        if(ownerId != null) {
            catFilters.add(new CatFilter(CatFields.ownerId, ownerId));
        }
        Specification<Cat> specification = getSpecificationFromFilters(catFilters);
        List<Cat> cats = catRepository.findAll(specification);
        ArrayList<CatDto> catDto = new ArrayList<>();
        for (Cat cat : cats) {
            catDto.add(CatMapper.asDto(cat));
        }
        return catDto;
    }
}
