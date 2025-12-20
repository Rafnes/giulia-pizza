package storage_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ShipmentRequestDTO {
    @NotBlank(message = "Номер поставки не может быть пустым")
    private String shipmentNumber;

    @NotNull(message = "Укажите дату поставки")
    private LocalDate deliveryDate;

    @NotBlank(message = "Название поставщика не может быть пустым")
    private String supplier;

    @NotNull(message = "Укажите товары в поставке")
    private List<ShipmentItemRequestDTO> items;
}
