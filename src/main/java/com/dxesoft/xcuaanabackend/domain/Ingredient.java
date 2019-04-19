package com.dxesoft.xcuaanabackend.domain;

import com.dxesoft.xcuaanabackend.domain.enumerated.MealGroup;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document
@Data
public class Ingredient implements Serializable {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private MealGroup mealGroup;
}
