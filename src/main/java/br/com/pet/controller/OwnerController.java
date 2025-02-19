package br.com.pet.controller;

import br.com.pet.dto.FindOwners;
import br.com.pet.dto.OwnerResponse;
import br.com.pet.dto.UpdateOwner;
import br.com.pet.service.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @PostMapping
    @Operation(summary = "Endpoint responsibile for registration owner.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<OwnerResponse>registerOwner(@RequestBody OwnerResponse ownerResponse){
        var register = ownerService.RegisterOwner(ownerResponse);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(register.getId()).toUri();
        return ResponseEntity.created(uri).body(new OwnerResponse(register));
    }

    @GetMapping
    @Operation(summary = "Endpoint responsibile for find all owners.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<FindOwners>>findAllOwners(){
        var findAll = ownerService.findOwners();
        return ResponseEntity.ok(findAll);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Endpoint responsibile for find owner by id.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<FindOwners>findOwnerById(@PathVariable Long id){
        var find = ownerService.findById(id);
        return ResponseEntity.ok().body(new FindOwners(find));
    }


    @GetMapping("/nameOwner")
    @Operation(summary = "Endpoint responsibile for find owners by name.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<FindOwners>>findByName(@PathParam("name") String name){
        var findByName = ownerService.findByName(name);
        return ResponseEntity.ok().body(findByName);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Endpoint responsibile for update owner by id.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<UpdateOwner>updateOwner(@RequestBody UpdateOwner updateOwner,@PathVariable Long id){
        var update = ownerService.updateOwner(updateOwner,id);
        return ResponseEntity.ok().body(new UpdateOwner(update));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint responsibile for delete owner by id.")
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>deleteOwner(@PathVariable Long id){
         ownerService.deletOwnerById(id);
        return ResponseEntity.noContent().build();
    }
}
