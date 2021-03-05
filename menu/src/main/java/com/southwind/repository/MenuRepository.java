package com.southwind.repository;

import com.southwind.entity.Menu;

import java.util.List;

public interface MenuRepository {
    public List<Menu> findAll(int index, int limit);

    public int count();

    public Menu findById(Long id);

    public void add(Menu menu);

    public void update(Menu menu);

    public void deleteById(long id);
}
