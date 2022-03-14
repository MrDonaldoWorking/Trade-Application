package com.example.trade.controller;

import com.example.trade.dao.TradeDao;
import com.example.trade.dao.TradeInMemoryDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.function.BiFunction;
import java.util.function.Consumer;

@RestController
@RequestMapping("/trade")
public class TradeController {
    private final TradeDao dao = new TradeInMemoryDao();

    @PostMapping("/add_company")
    public ResponseEntity<Integer> addCompany() {
        return ResponseEntity.ok(dao.addCompany());
    }

    private ResponseEntity<?> processBooleanMethod(final boolean result) {
        if (result) {
            return ResponseEntity.ok(null);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add_stock")
    public ResponseEntity<?> addStock(final int companyId, final int amount) {
        return processBooleanMethod(dao.addStock(companyId, amount));
    }

    @GetMapping("/get_amount/{companyId}")
    public ResponseEntity<Integer> getAmount(@PathVariable final int companyId) {
        return ResponseEntity.ok(dao.getCurrenAmount(companyId));
    }

    @GetMapping("/get_price/{companyId}")
    public ResponseEntity<Double> getPrice(@PathVariable final int companyId) {
        return ResponseEntity.ok(dao.getCurrentPrice(companyId));
    }

    @GetMapping("/buy/{companyId}/{amount}")
    public ResponseEntity<?> buy(@PathVariable final int companyId, @PathVariable final int amount) {
        return processBooleanMethod(dao.buyStock(companyId, amount));
    }

    @GetMapping("/sell/{companyId}/{amount}")
    public ResponseEntity<?> sell(@PathVariable final int companyId, @PathVariable final int amount) {
        return processBooleanMethod(dao.sellStock(companyId, amount));
    }

    @PostMapping("/change/{companyId}/{delta}")
    public ResponseEntity<?> change(@PathVariable final int companyId, @PathVariable final double delta) {
        return processBooleanMethod(dao.changePrice(companyId, delta));
    }
}
