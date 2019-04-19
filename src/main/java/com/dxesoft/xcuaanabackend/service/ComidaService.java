package com.dxesoft.xcuaanabackend.service;

import com.dxesoft.xcuaanabackend.domain.Meal;
import com.dxesoft.xcuaanabackend.repository.ComidaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComidaService {

    private final Logger log = LoggerFactory.getLogger(ComidaService.class);

    private final ComidaRepository comidaRepository;

    public ComidaService(ComidaRepository comidaRepository) {
        this.comidaRepository = comidaRepository;
    }

    public List<Meal> findAll() {
        log.debug("Request to find all the meals");

        return comidaRepository.findAll();
    }

    public Meal saveMeal(Meal meal) {
        log.debug("Request to create a meal");

        return comidaRepository.insert(meal);
    }
}
