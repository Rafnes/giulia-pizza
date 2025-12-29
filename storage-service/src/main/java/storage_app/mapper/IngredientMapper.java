package storage_app.mapper;

import org.springframework.stereotype.Component;
import storage_app.dto.IngredientResponseDTO;
import storage_app.model.Ingredient;

@Component
public class IngredientMapper {
    public IngredientResponseDTO toIngredientResponse(Ingredient ingredient) {
        IngredientResponseDTO response = new IngredientResponseDTO();
        response.setId(ingredient.getId());
        response.setName(ingredient.getName());
        response.setUnit(ingredient.getUnit());
        response.setType(ingredient.getType());
        //response.setQuantity();
        return response;
    }
}
