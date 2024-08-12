package itmo.deniill.controller;

import itmo.deniill.CatDto;
import itmo.deniill.service.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats/admin/")
public class CatAdminController {

    private final CatService catService;

    @Autowired
    public CatAdminController(CatService catService) {
        this.catService = catService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void createCat(
            @RequestBody CatDto catDto) {
        catService.createCat(catDto, null);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(
            @PathVariable(value = "id") int catId) {
        catService.deleteCatById(catId, null);
    }

    @PutMapping("/{catId}/friend/{friendId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void friendship(
            @PathVariable(value = "catId") int catId1,
            @PathVariable(value = "friendId") int catId2) {
        catService.friendship(catId1, catId2, null);
    }

    @DeleteMapping("/{catId}/not_friend/{friendId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void unFriendship(
            @PathVariable(value = "catId") int catId1,
            @PathVariable(value = "friendId") int catId2) {
        catService.unFriendship(catId1, catId2, null);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<CatDto> getCatsByCriteria(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "breed", required = false) String breed,
            @RequestParam(value = "colour", required = false) String colour,
            @RequestParam(value = "name", required = false) String name) {
        return catService.getCatsByCriteria(id, name, breed, colour, null);
    }

}