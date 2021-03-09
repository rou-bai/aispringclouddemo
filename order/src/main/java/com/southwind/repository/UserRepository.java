package com.southwind.repository;

import com.southwind.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll(int index, int limit);
    public User findById(Long id);
    public int count();
    public void add(User user);
    public void update(User user);
    public void deleteById(Long id);
}
