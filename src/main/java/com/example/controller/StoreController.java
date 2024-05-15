package com.example.controller;

import com.example.model.Store;
import com.example.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    // Create a new store
    @PostMapping("/api/stores")
    public Store addStore(@RequestBody Store store) {
        return storeService.addStore(store);
    }

    // Retrieve all stores
    @GetMapping("/api/stores")
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    // Retrieve a single store by ID
    @GetMapping("/api/stores/test")
    public String getTest() {
        return "testing API";
    }

    // Retrieve a single store by ID
    @GetMapping("/api/stores/{storeId}")
    public Optional<Store> getStoreById(@PathVariable String storeId) {
        return storeService.getStoreById(storeId);
    }

    // Update an existing store
    @PutMapping("/api/stores/{storeId}")
    public Store updateStore(@PathVariable String storeId, @RequestBody Store store) {
        return storeService.updateStore(storeId, store);
    }

    // Delete a store by ID
    @DeleteMapping("/api/stores/{storeId}")
    public void deleteStore(@PathVariable String storeId) {
        storeService.deleteStore(storeId);
    }
}
