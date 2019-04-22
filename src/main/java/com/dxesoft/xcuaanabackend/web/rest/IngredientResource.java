package com.dxesoft.xcuaanabackend.web.rest;

import com.dxesoft.xcuaanabackend.domain.Ingredient;
import com.dxesoft.xcuaanabackend.service.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class IngredientResource {

    private final Logger log = LoggerFactory.getLogger(IngredientResource.class);

    private final IngredientService ingredientService;


    public IngredientResource(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(path = "/admin/ingredient",
            produces = { "application/json" })
    @Secured("ROLE_ADMIN")
    public ResponseEntity<List<Ingredient>>findAll() {
        log.debug("************************************************************\n\n\n\n");
        log.debug("Rest request to find all ingredients");
        log.debug("\n\n\n\n************************************************************");

        final List<Ingredient> ingredients = ingredientService.findAll();

        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @PostMapping(path = "/admin/ingredient",
            produces = { "application/json" })
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Ingredient> saveIngredient(@Valid @RequestBody Ingredient ingredient) throws URISyntaxException {
        log.debug("************************************************************\n\n\n\n");
        log.debug("Rest request to create a new ingredient");
        log.debug("\n\n\n\n************************************************************");

        final Ingredient result = ingredientService.saveIngredient(ingredient);

        return ResponseEntity.created(new URI("/api/v1/admin/ingredient/" + result.getId()))
                .body(result);
    }
}
