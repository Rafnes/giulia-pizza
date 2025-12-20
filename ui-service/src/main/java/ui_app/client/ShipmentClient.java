package ui_app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import storage_app.dto.ShipmentRequestDTO;

@FeignClient(name = "storage-service", url = "${storage.service.url:http://localhost:8081}")
public interface ShipmentClient {

    @PostMapping("api/shipments")
    void receiveShipment(@RequestBody ShipmentRequestDTO dto);
}
