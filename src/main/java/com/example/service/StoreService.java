package com.example.service;

import com.example.model.Store;
import com.example.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Store addStore(Store store) {
        try {
            return storeRepository.save(store);
        } catch (Exception e) {
            // Log the exception or perform any other error handling
            throw new RuntimeException("Failed to add store", e);
        }
    }

    public List<Store> getAllStores() {
        try {
            return storeRepository.findAll();
        } catch (Exception e) {
            // Log the exception or perform any other error handling
            throw new RuntimeException("Failed to retrieve stores", e);
        }
    }

    public Optional<Store> getStoreById(String storeId) {
        try {
            Optional<Store> storeOptional = storeRepository.findById(storeId);
            return Optional.ofNullable(storeOptional.orElse(null));
        } catch (Exception e) {
            // Log the exception or perform any other error handling
            throw new RuntimeException("Failed to retrieve store by ID: " + storeId, e);
        }
    }

    public Store updateStore(String storeId, Store updatedStore) {
        try {
            Optional<Store> storeOptional = storeRepository.findById(storeId);
            if (storeOptional.isPresent()) {
                Store existingStore = storeOptional.get();
                // Update existingStore properties
                // ...
                return storeRepository.save(existingStore);
            } else {
                throw new IllegalArgumentException("Store not found with ID: " + storeId);
            }
        } catch (Exception e) {
            // Log the exception or perform any other error handling
            throw new RuntimeException("Failed to update store with ID: " + storeId, e);
        }
    }

    public void deleteStore(String storeId) {
        try {
            storeRepository.deleteById(storeId);
        } catch (Exception e) {
            // Log the exception or perform any other error handling
            throw new RuntimeException("Failed to delete store with ID: " + storeId, e);
        }
    }
}
