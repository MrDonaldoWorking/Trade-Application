package com.example.user.dao;

import com.example.user.model.Role;
import com.example.user.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserInMemoryDao implements UserDao {
    private final List<User> users = new ArrayList<>();

    public UserInMemoryDao() {
        // Add admin by default
        users.add(new User(0, Double.MAX_VALUE, Role.ADMIN));
    }

    @Override
    public int addUser() {
        users.add(new User(users.size()));
        return users.size() - 1;
    }

    private boolean isUserNotExists(final int userId) {
        return userId >= users.size();
    }

    @Override
    public boolean putMoney(final int userId, final double amount) {
        if (isUserNotExists(userId)) {
            return false;
        }
        users.get(userId).putMoney(amount);
        return true;
    }

    @Override
    public List<Integer> getStocks(final int userId) {
        if (isUserNotExists(userId)) {
            return null;
        }
        return users.get(userId).getStockIds();
    }
}
