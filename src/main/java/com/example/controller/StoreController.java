package com.example.controller;

import com.example.model.Store;
import com.example.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    // Create a new store
    @PostMapping("/api/stores")
    public ResponseEntity<?> addStore(@RequestBody Store store) {
        try {
            Store addedStore = storeService.addStore(store);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedStore);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add store: " + e.getMessage());
        }
    }

    // Retrieve all stores
    @GetMapping("/api/stores")
    public ResponseEntity<?> getAllStores() {
        try {
            List<Store> stores = storeService.getAllStores();
            return ResponseEntity.ok(stores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve stores: " + e.getMessage());
        }
    }

    // Retrieve a single store by ID
    @GetMapping("/api/stores/{storeId}")
    public ResponseEntity<?> getStoreById(@PathVariable String storeId) {
        try {
            Optional<Store> store = storeService.getStoreById(storeId);
            if (store.isPresent()) {
                return ResponseEntity.ok(store.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Store not found with id: " + storeId);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve store: " + e.getMessage());
        }
    }

    // Update an existing store
    @PutMapping("/api/stores/{storeId}")
    public ResponseEntity<?> updateStore(@PathVariable String storeId, @RequestBody Store store) {
        try {
            Store updatedStore = storeService.updateStore(storeId, store);
            if (updatedStore != null) {
                return ResponseEntity.ok(updatedStore);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Store not found with id: " + storeId);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update store: " + e.getMessage());
        }
    }

    // Delete a store by ID
    @DeleteMapping("/api/stores/{storeId}")
    public ResponseEntity<?> deleteStore(@PathVariable String storeId) {
        try {
            storeService.deleteStore(storeId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete store: " + e.getMessage());
        }
    }
}
