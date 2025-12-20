package storage_app.service;

import org.springframework.stereotype.Service;
import storage_app.repository.IngredientBatchRepository;
import storage_app.repository.IngredientRepository;

@Service
public class StorageService {
    private final IngredientRepository ingredientRepository;
    private final IngredientBatchRepository batchRepository;

    public StorageService(IngredientRepository ingredientRepository, IngredientBatchRepository batchRepository) {
        this.ingredientRepository = ingredientRepository;
        this.batchRepository = batchRepository;
    }
}
