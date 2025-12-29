package storage_app.dto;

import lombok.Data;
import storage_app.enums.IngredientType;
import storage_app.enums.UnitType;

@Data
public class IngredientResponseDTO {
    private Long id;
    private String name;
    private IngredientType type;
    private UnitType unit;
    private Double quantity;
}
