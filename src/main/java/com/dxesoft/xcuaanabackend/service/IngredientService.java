package com.dxesoft.xcuaanabackend.service;

import com.dxesoft.xcuaanabackend.domain.Ingredient;
import com.dxesoft.xcuaanabackend.repository.IngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final Logger log = LoggerFactory.getLogger(IngredientService.class);

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findAll() {
        log.debug("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n\n\n\n");
        log.debug("Request to find all ingredients");
        log.debug("\n\n\n\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        return ingredientRepository.findAll();
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        log.debug("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n\n\n\n");
        log.debug("Request to save an Ingredient");
        log.debug("\n\n\n\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");


        return ingredientRepository.save(ingredient);
    }
}
