package itmo.deniill.service.services;

import itmo.deniill.OwnerDto;

import java.util.List;

public interface OwnerService {
    void createOwner(OwnerDto ownerDto);
    OwnerDto getOwnerById(int ownerId);
    List<OwnerDto> getOwners();
    void deleteOwnerById(int ownerId);
}
