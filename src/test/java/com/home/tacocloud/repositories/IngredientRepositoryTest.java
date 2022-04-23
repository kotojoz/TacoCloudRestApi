package com.home.tacocloud.repositories;

import com.home.tacocloud.domain.Ingredient;
import com.home.tacocloud.domain.Ingredient.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class IngredientRepositoryTest {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void findById(){
        Optional<Ingredient> flto = ingredientRepository.findById("FLTO");
        assertThat(flto.isPresent()).isTrue();
        assertThat(flto.get()).isEqualTo(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));

        Optional<Ingredient> xxxx = ingredientRepository.findById("XXXX");
        assertThat(xxxx.isEmpty()).isTrue();
    }

}