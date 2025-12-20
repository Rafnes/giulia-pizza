package storage_app.repository;

import storage_app.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    public Optional<Ingredient> findByNameAndType(String name, String type);
}
