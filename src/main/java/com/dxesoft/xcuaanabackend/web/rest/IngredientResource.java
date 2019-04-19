package com.dxesoft.xcuaanabackend.web.rest;

import com.dxesoft.xcuaanabackend.domain.Ingredient;
import com.dxesoft.xcuaanabackend.service.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/ingredient",
            produces = { "application/json" })
    public ResponseEntity<List<Ingredient>>findAll() {
        log.debug("Rest request to find all ingredients");

        final List<Ingredient> ingredients = ingredientService.findAll();

        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @PostMapping(path = "/ingredient",
            produces = { "application/json" })
    public ResponseEntity<Ingredient> saveIngredient(@Valid @RequestBody Ingredient ingredient) throws URISyntaxException {
        log.debug("Rest request to create a new ingredient");

        final Ingredient result = ingredientService.saveIngredient(ingredient);

        return ResponseEntity.created(new URI("/api/v1/ingredient/" + result.getId()))
                .body(result);
    }
}
