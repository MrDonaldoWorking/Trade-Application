package com.example.user.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private double money;
    private final Role role;
    private final List<Integer> stockIds = new ArrayList<>();

    public User(final int id) {
        this.id = id;
        this.money = 0;
        this.role = Role.USER;
    }

    public User(final int id, final double money, final Role role) {
        this.id = id;
        this.money = money;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public double getMoney() {
        return money;
    }

    public void putMoney(final double amount) {
        money += amount;
    }

    public Role getRole() {
        return role;
    }

    public void addStock(final int stockId) {
        stockIds.add(stockId);
    }

    public List<Integer> getStockIds() {
        return stockIds;
    }
}
