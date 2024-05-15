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
        return storeRepository.save(store);
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Optional<Store> getStoreById(String storeId) {
        Optional<Store> storeOptional = storeRepository.findById(storeId);
        return Optional.ofNullable(storeOptional.orElse(null));
    }

    public Store updateStore(String storeId, Store updatedStore) {
        Optional<Store> storeOptional = storeRepository.findById(storeId);
        if (storeOptional.isPresent()) {
            Store existingStore = storeOptional.get();

            // Set the ID of the updated store
            updatedStore.setId(existingStore.getId());

            // Copy the properties from the updated store to the existing store
            // You can implement this logic based on your requirements
            // For simplicity, I'm assuming all properties will be copied
            existingStore.setName(updatedStore.getName());
            existingStore.setLogoImage(updatedStore.getLogoImage());
            existingStore.setPromo(updatedStore.isPromo());
            existingStore.setTimeToReachFromCurrentLocation(updatedStore.getTimeToReachFromCurrentLocation());
            existingStore.setDistanceInKM(updatedStore.getDistanceInKM());
            existingStore.setRating(updatedStore.getRating());
            existingStore.setDeliveryCharge(updatedStore.getDeliveryCharge());
            existingStore.setCategory(updatedStore.getCategory());
            existingStore.setSubCategory(updatedStore.getSubCategory());
            existingStore.setDiscountedItem(updatedStore.isDiscountedItem());
            existingStore.setDiscountTag(updatedStore.getDiscountTag());
            existingStore.setGiftTagText(updatedStore.getGiftTagText());

//             Save the updated store
            return storeRepository.save(existingStore);
        }
        return null;
    }

    public void deleteStore(String storeId) {
        storeRepository.deleteById(storeId);
    }

}
