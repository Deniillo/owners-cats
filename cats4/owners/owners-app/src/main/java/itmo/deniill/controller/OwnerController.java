package itmo.deniill.controller;

import itmo.deniill.OwnerDto;
import itmo.deniill.service.services.OwnerImmutableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners/")
public class OwnerController {
    private final OwnerImmutableService ownerImmutableService;

    @Autowired
    public OwnerController(OwnerImmutableService ownerImmutableService) {
        this.ownerImmutableService = ownerImmutableService;
    }

    @GetMapping(value = "/{id}")
    public OwnerDto getOwnerById(@PathVariable(value = "id") int ownerId) {
        return ownerImmutableService.getOwnerById(ownerId);
    }

    @GetMapping()
    public List<OwnerDto> findAllOwners() {
        return ownerImmutableService.getAllOwners();
    }
}