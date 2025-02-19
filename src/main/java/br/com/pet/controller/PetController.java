package br.com.pet.controller;

import br.com.pet.dto.FindPets;
import br.com.pet.dto.PetDto;
import br.com.pet.dto.UpdatePets;
import br.com.pet.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/{ownerId}")
    @Operation(summary = "Endpoint responsibile for registration pet by ownerId.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<PetDto>registerPet(@RequestBody PetDto petDto, @PathVariable Long ownerId){
        var register = petService.registerPet(petDto,ownerId);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(register.getId()).toUri();
        return ResponseEntity.created(uri).body(new PetDto(register));
    }

    @GetMapping
    @Operation(summary = "Endpoint responsibile for find all pets.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<FindPets>>findAllPets(){
        var find = petService.findAllPets();
        return ResponseEntity.ok(find);
    }

    @GetMapping("/findName")
    @Operation(summary = "Endpoint responsibile for find pet by name.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<FindPets>>findPetsByName(@PathParam("name")String name){
        var find = petService.findByName(name);
        return ResponseEntity.ok(find);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Endpoint responsibile for find pet by id.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<FindPets>findById(@PathVariable Long id){
        var find = petService.findById(id);
        return ResponseEntity.ok().body(new FindPets(find));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Endpoint responsibile for update pet by id.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<UpdatePets>updatePet(@RequestBody UpdatePets updatePets,@PathVariable Long id){
        var update = petService.updatePet(updatePets,id);
        return ResponseEntity.ok(new UpdatePets(update));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint responsibile for delete pet by id.")
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>deletePet(@PathVariable Long id){
        petService.deletePets(id);
        return ResponseEntity.noContent().build();
    }
}
