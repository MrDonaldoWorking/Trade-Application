package com.example.user.dao;

import com.example.user.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    /**
     * Adds new user
     * @return new user id in int
     */
    int addUser();

    /**
     * Puts amount of money to user's wallet
     * @param userId in int
     * @param amount in double
     * @return false if user with userId doesn't exist
     */
    boolean putMoney(final int userId, final double amount);

    /**
     * Returns user's bought stocks
     * @param userId in int
     * @return false if user with userId doesn't exist
     */
    List<Integer> getStocks(final int userId);


}
