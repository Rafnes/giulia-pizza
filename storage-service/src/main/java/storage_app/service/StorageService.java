package storage_app.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import storage_app.dto.ShipmentItemRequestDTO;
import storage_app.dto.ShipmentRequestDTO;
import storage_app.mapper.ShipmentMapper;
import storage_app.model.Ingredient;
import storage_app.model.IngredientBatch;
import storage_app.model.Shipment;
import storage_app.model.ShipmentItem;
import storage_app.repository.IngredientBatchRepository;
import storage_app.repository.IngredientRepository;
import storage_app.repository.ShipmentRepository;

import java.time.LocalDate;

@Service
public class StorageService {
    private final IngredientRepository ingredientRepository;
    private final IngredientBatchRepository batchRepository;
    private final ShipmentRepository shipmentRepository;
    private final ShipmentMapper shipmentMapper;

    public StorageService(IngredientRepository ingredientRepository,
                          IngredientBatchRepository batchRepository, ShipmentRepository shipmentRepository,
                          ShipmentMapper shipmentMapper) {
        this.ingredientRepository = ingredientRepository;
        this.batchRepository = batchRepository;
        this.shipmentRepository = shipmentRepository;
        this.shipmentMapper = shipmentMapper;
    }

    @Transactional
    public void receiveShipment(ShipmentRequestDTO requestDTO) {
        Shipment shipment = new Shipment();
        shipmentMapper.toShipmentEntity(requestDTO);
        for (ShipmentItemRequestDTO itemDTO : requestDTO.getItems()) {
            Ingredient ingredient = ingredientRepository.findByNameAndType(itemDTO.getName(), String.valueOf(itemDTO.getType()))
                    .orElseGet(() -> {
                        Ingredient newIngredient = new Ingredient();
                        newIngredient.setName(itemDTO.getName());
                        newIngredient.setType(itemDTO.getType());
                        newIngredient.setUnit(itemDTO.getUnit());
                        return ingredientRepository.save(newIngredient);
                    });

            IngredientBatch batch = batchRepository.findByIngredientAndBatchNumber(ingredient, itemDTO.getBatchNumber()).
                    orElseGet(() -> {
                        IngredientBatch newBatch = new IngredientBatch();
                        newBatch.setIngredient(ingredient);
                        newBatch.setBatchNumber(itemDTO.getBatchNumber());
                        newBatch.setQuantity(0.0);
                        newBatch.setExpirationDate(LocalDate.now().plusYears(1));
                        newBatch.setReceivedDate(requestDTO.getDeliveryDate());
                        return batchRepository.save(newBatch);
                    });
            ShipmentItem item = shipmentMapper.toItemEntity(itemDTO, shipment, batch);
            shipment.getItems().add(item);

            batch.setQuantity(batch.getQuantity() + itemDTO.getQuantity());
            batchRepository.save(batch);
        }
        shipmentRepository.save(shipment);
    }
}
