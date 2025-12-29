package storage_app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import storage_app.model.Ingredient;
import storage_app.model.IngredientBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IngredientBatchRepository extends JpaRepository<IngredientBatch, Integer> {
    Optional<IngredientBatch> findByIngredientAndBatchNumber(Ingredient ingredient, String batchNumber);

    Page<IngredientBatch> findAll(Pageable pageable);

    Page<IngredientBatch> findByIngredientId(Long ingredientId, Pageable pageable);
}
