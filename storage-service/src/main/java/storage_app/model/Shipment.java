package storage_app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shipment")
@Data
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipment_number", unique = true, nullable = false)
    private String shipmentNumber;

    @Column(name = "supplier", nullable = false)
    private String supplier;

    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShipmentItem> items = new ArrayList<>();
}