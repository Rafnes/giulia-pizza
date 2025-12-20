package ui_app.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import storage_app.dto.ShipmentRequestDTO;
import ui_app.client.ShipmentClient;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {
    private final ShipmentClient shipmentClient;

    public ShipmentController(ShipmentClient shipmentClient) {
        this.shipmentClient = shipmentClient;
    }

    @PostMapping
    public String createShipment(
            @Valid @ModelAttribute("shipmentDTO") ShipmentRequestDTO requestDTO,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "shipments/create";
        }

        try {
            shipmentClient.receiveShipment(requestDTO);
            model.addAttribute("success", "Поставка успешно принята");
            return "redirect:/shipments";
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка: " + e.getMessage());
            return "shipments/create";
        }
    }
}
