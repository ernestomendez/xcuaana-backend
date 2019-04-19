package com.dxesoft.xcuaanabackend.repository;

import com.dxesoft.xcuaanabackend.domain.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {
}
