package com.southwind.repository;


import com.southwind.entity.Order;

import java.util.List;

public interface OrderRepository {
    public void add(Order order);
    public List<Order> findByUid(int index, int limit, Long uid);
    public int countByUid(Long uid);
}
