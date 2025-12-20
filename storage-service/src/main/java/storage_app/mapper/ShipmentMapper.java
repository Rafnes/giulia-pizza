package storage_app.mapper;

import org.springframework.stereotype.Component;
import storage_app.dto.ShipmentItemRequestDTO;
import storage_app.dto.ShipmentRequestDTO;
import storage_app.model.IngredientBatch;
import storage_app.model.Shipment;
import storage_app.model.ShipmentItem;

import java.util.ArrayList;

@Component
public class ShipmentMapper {
    public Shipment toShipmentEntity(ShipmentRequestDTO dto) {
        Shipment shipment = new Shipment();
        shipment.setShipmentNumber(dto.getShipmentNumber());
        shipment.setSupplier(dto.getSupplier());
        shipment.setDeliveryDate(dto.getDeliveryDate());
        shipment.setItems(new ArrayList<>());
        return shipment;
    }

    public ShipmentItem toItemEntity(ShipmentItemRequestDTO dto,
                                     Shipment shipment,
                                     IngredientBatch ingredientBatch) {
        ShipmentItem item = new ShipmentItem();
        item.setShipment(shipment);
        item.setBatch(ingredientBatch);
        item.setReceivedQuantity(dto.getQuantity());
        item.setUnitPrice(dto.getPrice());
        return item;
    }
}
