package itmo.deniill.service.services;

import itmo.deniill.OwnerDto;

import java.util.List;

public interface OwnerImmutableService {
    OwnerDto getOwnerById(int ownerId);
    List<OwnerDto> getAllOwners();
}
