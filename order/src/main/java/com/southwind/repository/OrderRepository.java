package com.southwind.repository;


import com.southwind.entity.Order;

import java.util.List;

public interface OrderRepository {
    public void add(Order order);
    public List<Order> findByUid(int index, int limit, Long uid);
    public int countByUid(Long uid);
    public List<Order> findByState(int index, int limit, int state);
    public void updateStateById(Long id, int state, Long aid);
    public int countByState(int state);
}
