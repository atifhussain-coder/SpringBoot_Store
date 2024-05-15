package com.example.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stores")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Store {
    @Id
    private String id;
    private String name;
    private String logoImage;
    private boolean isPromo;
    private int timeToReachFromCurrentLocation;
    private double distanceInKM;
    private double rating;
    private double deliveryCharge;
    private String category;
    private String subCategory;
    private boolean isDiscountedItem;
    private String discountTag;
    private String giftTagText;
}
