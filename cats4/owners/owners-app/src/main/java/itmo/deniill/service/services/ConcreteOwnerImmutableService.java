package itmo.deniill.service.services;

import itmo.deniill.OwnerDto;
import itmo.deniill.dao.entities.Owner;
import itmo.deniill.dao.repositories.OwnerRepository;
import itmo.deniill.service.mappers.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ConcreteOwnerImmutableService implements OwnerImmutableService {
    private final OwnerRepository ownerRepository;
    @Autowired
    public ConcreteOwnerImmutableService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
    @Override
    public OwnerDto getOwnerById(int ownerId) {
        return OwnerMapper.asDto(ownerRepository.findById(ownerId).orElseThrow());
    }

    @Override
    public List<OwnerDto> getAllOwners() {
        List<OwnerDto> owners = new ArrayList<>();
        for (Owner owner : ownerRepository.findAll()) {
            owners.add(OwnerMapper.asDto(owner));
        }
        return owners;
    }
}
