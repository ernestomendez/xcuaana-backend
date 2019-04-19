package com.dxesoft.xcuaanabackend.repository;

import com.dxesoft.xcuaanabackend.domain.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComidaRepository extends MongoRepository<Meal, String> {
}
