package com.example.user.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private double money;
    private final Role role;
    private final List<Stock> stocks = new ArrayList<>();

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

    public void addStock(final int stockId, final int amount) {
        for (final Stock stock : stocks) {
            if (stock.getId() == stockId) {
                stocks.get(stockId).put(amount);
            }
        }
        stocks.add(new Stock(stockId, amount));
    }

    public List<Stock> getStocks() {
        return stocks;
    }
}
