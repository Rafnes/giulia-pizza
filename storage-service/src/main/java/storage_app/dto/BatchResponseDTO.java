package storage_app.dto;

import lombok.Data;
import storage_app.enums.IngredientType;

import java.time.LocalDate;

@Data
public class BatchResponseDTO {
    private Integer id;
    private String name;
    private IngredientType type;
    private String batchNumber;
    private Double quantity;
    private LocalDate productionDate;
    private LocalDate expirationDate;
    private LocalDate receivedDate;
    private String supplier;
}
