package itmo.deniill.controller;

import itmo.deniill.OwnerDto;
import itmo.deniill.service.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners/")
public class OwnerController {
    private final OwnerService ownerService;
    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public void createOwner(
            @RequestBody OwnerDto ownerDto) {
        ownerService.createOwner(ownerDto);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public OwnerDto getOwnerById(@PathVariable(value = "id") int ownerId) {
        return ownerService.getOwnerById(ownerId);
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public List<OwnerDto> findAllOwners() {
        return ownerService.getOwners();
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void removeOwner(@PathVariable(value = "id") int ownerId) {
        ownerService.deleteOwnerById(ownerId);
    }

}