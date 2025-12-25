package storage_app.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import storage_app.dto.ShipmentRequestDTO;
import storage_app.dto.ShipmentResponseDTO;
import storage_app.service.StorageService;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    private final StorageService storageService;

    public ShipmentController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public ResponseEntity<ShipmentResponseDTO> receiveShipment(@Valid @RequestBody ShipmentRequestDTO dto) {
        storageService.receiveShipment(dto);
        return ResponseEntity.ok().build();
    }
}