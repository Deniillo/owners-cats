package itmo.deniill.controller;

import itmo.deniill.CatDto;
import itmo.deniill.service.dto.UserDto;
import itmo.deniill.service.services.CatService;
import itmo.deniill.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats/")
public class CatController {

    private final CatService catService;
    private final UserService userService;

    @Autowired
    public CatController(CatService catService, UserService userService) {
        this.catService = catService;
        this.userService = userService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public void createCat(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody CatDto catDto) {
        UserDto user = userService.getUserByUsername(userDetails.getUsername());
        catService.createCat(catDto, user.getOwnerId());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public void deleteById(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable(value = "id") int catId) {
        UserDto user = userService.getUserByUsername(userDetails.getUsername());
        catService.deleteCatById(catId, user.getOwnerId());
    }

    @PutMapping("/{catId}/friend/{friendId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public void friendship(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable(value = "catId") int catId1,
            @PathVariable(value = "friendId") int catId2) {
        UserDto user = userService.getUserByUsername(userDetails.getUsername());
        catService.friendship(catId1, catId2, user.getOwnerId());
    }

    @DeleteMapping("/{catId}/not_friend/{friendId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public void unFriendship(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable(value = "catId") int catId1,
            @PathVariable(value = "friendId") int catId2) {
        UserDto user = userService.getUserByUsername(userDetails.getUsername());
        catService.unFriendship(catId1, catId2, user.getOwnerId());
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<CatDto> getCatsByCriteria(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "breed", required = false) String breed,
            @RequestParam(value = "colour", required = false) String colour,
            @RequestParam(value = "name", required = false) String name) {
        UserDto user = userService.getUserByUsername(userDetails.getUsername());
        return catService.getCatsByCriteria(id, name, breed, colour, String.valueOf(user.getOwnerId()));
    }

}