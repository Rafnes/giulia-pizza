package storage_app.dto;

import lombok.Data;

@Data
public class ShipmentResponseDTO {
    private Long shipmentId;
    private String shipmentNumber;
    private String status;
}
