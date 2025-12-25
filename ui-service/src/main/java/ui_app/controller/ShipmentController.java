package ui_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import storage_app.dto.ShipmentRequestDTO;
import ui_app.client.ShipmentClient;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {
    private final ShipmentClient client;

    public ShipmentController(ShipmentClient client) {
        this.client = client;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("shipmentDTO", new ShipmentRequestDTO());
        return "shipments/create";
    }

    @PostMapping
    public String submitCreateForm(@ModelAttribute ShipmentRequestDTO dto, Model model) {
        try {
            client.receiveShipment(dto);
            model.addAttribute("success", "Поставка успешно принята!");
            return "shipments/create";
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка: " + e.getMessage());
            return "shipments/create";
        }
    }
}