package ui_app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import storage_app.dto.ShipmentRequestDTO;

@FeignClient(name = "storage-service", url = "${storage.service.url:http://localhost:8081}")
public interface ShipmentClient {

    @PostMapping("/shipments")
    ResponseEntity<Void> receiveShipment(@RequestBody ShipmentRequestDTO dto);
}
