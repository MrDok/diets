package com.home.diets.db.services;

import com.home.diets.db.models.Shop;

/**
 * Created by user on 28.05.2017.
 */
public interface ShopService{
    Shop getShopById(Long id);
    Shop getShopByName(String name);
    void addShop(Shop shop);
}
