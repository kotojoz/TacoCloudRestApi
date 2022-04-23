package com.home.tacocloud.repositories;

import com.home.tacocloud.domain.TacoOrder;
import com.home.tacocloud.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
