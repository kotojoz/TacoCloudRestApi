package com.home.tacocloud.converters;

import com.home.tacocloud.domain.Ingredient;
import com.home.tacocloud.repositories.IngredientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

class IngredientByIdConverterTest {

    private IngredientByIdConverter converter;

    @BeforeEach
    public void setUp() {
        IngredientRepository ingredientRepository = mock(IngredientRepository.class);
        when(ingredientRepository.findById("AAAA"))
                .thenReturn(Optional.of(new Ingredient("AAAA", "TEST INGREDIENT", Ingredient.Type.CHEESE)));
        when(ingredientRepository.findById("ZZZZ"))
                .thenReturn(Optional.empty());
        this.converter = new IngredientByIdConverter(ingredientRepository);
    }

    @Test
    public void shouldReturnValueWhenPresent(){
        assertThat(converter.convert("AAAA"))
                .isEqualTo(new Ingredient("AAAA", "TEST INGREDIENT", Ingredient.Type.CHEESE));
    }

    @Test
    public void shouldReturnNullWhenMissing(){
        assertThat(converter.convert("ZZZZ")).isNull();
    }
}