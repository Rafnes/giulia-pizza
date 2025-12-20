package storage_app.model;

import storage_app.enums.IngredientType;
import storage_app.enums.UnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "ingredient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private IngredientType type;

    @Column(name = "unit", nullable = false)
    @Enumerated(EnumType.STRING)
    private UnitType unit;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && type == that.type && unit == that.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, unit);
    }

    @Override
    public String toString() {
        return "Ingredient: "+
                "id = " + id +
                ", name = '" + name + '\'' +
                ", type = " + type +
                ", unit = " + unit +
                '}';
    }
}
