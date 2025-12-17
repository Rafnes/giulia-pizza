package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ingredient_batch")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Column(name = "production_date")
    private LocalDate productionDate;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "batch_number")
    private String batchNumber;

    @Column(name = "received_date", nullable = false)
    private LocalDate receivedDate;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IngredientBatch that = (IngredientBatch) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(ingredient, that.ingredient) && Objects.equals(quantity, that.quantity) && Objects.equals(productionDate, that.productionDate) && Objects.equals(expirationDate, that.expirationDate) && Objects.equals(supplier, that.supplier) && Objects.equals(batchNumber, that.batchNumber) && Objects.equals(receivedDate, that.receivedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, ingredient, quantity, productionDate, expirationDate, supplier, batchNumber, receivedDate);
    }

    @Override
    public String toString() {
        return "IngredientBatch{" +
                "uuid=" + uuid +
                ", ingredient=" + ingredient +
                ", quantity=" + quantity +
                ", productionDate=" + productionDate +
                ", expirationDate=" + expirationDate +
                ", supplier='" + supplier + '\'' +
                ", batchNumber='" + batchNumber + '\'' +
                ", receivedDate=" + receivedDate +
                '}';
    }
}
