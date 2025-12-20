package storage_app.dto;

import lombok.Data;
import storage_app.enums.IngredientType;
import storage_app.enums.UnitType;

import java.math.BigDecimal;

@Data
public class ShipmentItemRequestDTO {
    private String batchNumber;
    private String name;
    private IngredientType type;
    private UnitType unit;
    private BigDecimal price;
    private Double quantity;
}
