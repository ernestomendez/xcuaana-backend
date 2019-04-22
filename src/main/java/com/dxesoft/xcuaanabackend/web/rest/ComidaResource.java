package com.dxesoft.xcuaanabackend.web.rest;

import com.dxesoft.xcuaanabackend.domain.Meal;
import com.dxesoft.xcuaanabackend.service.ComidaService;
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
public class ComidaResource {

    private final Logger log = LoggerFactory.getLogger(ComidaResource.class);

    private final ComidaService comidaService;

    public ComidaResource(ComidaService comidaService) {
        this.comidaService = comidaService;
    }


    @GetMapping(path = "/user/comida",
            produces = { "application/json" })
    @Secured("ROLE_USER")
    public ResponseEntity<List<Meal>>findAll() {
        log.debug("REST request to get all the Horarios de comida");

        List<Meal> comidas = comidaService.findAll();

        return new ResponseEntity<List<Meal>>(comidas, HttpStatus.OK);
    }

    @PostMapping(path = "/admin/comida",
            produces = { "application/json" })
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Meal> saveMeal(@Valid @RequestBody Meal meal) throws URISyntaxException {
        log.debug("************************************************************\n\n\n\n");
        log.debug("Rest request to save a meal");
        log.debug("\n\n\n\n************************************************************");

        final Meal result = comidaService.saveMeal(meal);

        return ResponseEntity.created(new URI("/api/v1/admin/comida/" + result.getId()))
                .body(result);
    }
}
