package com.dxesoft.xcuaanabackend.domain;

import com.dxesoft.xcuaanabackend.domain.enumerated.MealType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Document
@Data
public class Meal implements Serializable {

    @Id
    private String id;

    @NotNull
    @Field("platillo")
    private String mealName;

    @NotNull
    @Field("date")
    private LocalDateTime mealDate;

    @NotNull
    @Field("type")
    private MealType type;


}
