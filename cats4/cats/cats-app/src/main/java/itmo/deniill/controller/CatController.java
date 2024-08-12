package itmo.deniill.controller;

import itmo.deniill.CatDto;
import itmo.deniill.service.services.CatImmutableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats/")
public class CatController {

    private final CatImmutableService catImmutableService;

    @Autowired
    public CatController(CatImmutableService catImmutableService) {
        this.catImmutableService = catImmutableService;
    }

    @GetMapping
    public List<CatDto> getCatsByCriteria(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "breed", required = false) String breed,
            @RequestParam(value = "colour", required = false) String colour,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "ownerId", required = false) String ownerId) {
        return catImmutableService.getCatsByCriteria(id, name, breed, colour, ownerId);
    }

}