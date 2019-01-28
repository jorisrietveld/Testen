package com.CofeeVendingMachine;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Inventory
{

    private Map<Orderable, Integer> currentInventory;

    private Predicate<Map.Entry<Orderable, Integer>> inventoryNotEmpty = entry -> entry.getValue() > 0;

    /**
     * Initiate a empty inventory.
     */
    public Inventory()
    {
        currentInventory = new LinkedHashMap<>();
    }

    /**
     * Initiate the inventory that already has some items in stock.
     *
     * @param initialInventory Initial stock.
     */
    public Inventory( Map<Orderable, Integer> initialInventory )
    {
        currentInventory = new LinkedHashMap<>( initialInventory );
    }

    /**
     * Add new stock or update existing stock in the inventory.
     *
     * @param product The new or existing product that gets new stock.
     * @param amount  The amount of stock to add.
     */
    public void addProduct( Orderable product, Integer amount )
    {
        currentInventory.put( product, currentInventory.getOrDefault( product, 0 ) + amount );
    }

    /**
     * @param product The product to check.
     *
     * @return The current stock in inventory.
     */
    public int getStockOfProduct( Orderable product )
    {
        return currentInventory.getOrDefault( product, 0 );
    }


    /**
     * Checks if a product exists in this inventory.
     *
     * @param product The product to check.
     *
     * @return The answer of the check.
     */
    public boolean hasProduct( Orderable product )
    {
        return currentInventory.containsKey( product );
    }

    public List<Beverage> getBeverages()
    {
        return this.currentInventory.entrySet().stream()
                                    .filter( inventoryNotEmpty )
                                    .filter( e -> e.getKey() instanceof Beverage )
                                    .map( e -> (Beverage)e )
                                    .collect( Collectors.toList() );
    }

    public List<Addition> getAdditions()
    {
        return this.currentInventory.entrySet().stream()
                                    .filter( inventoryNotEmpty )
                                    .filter( e -> e.getKey() instanceof Addition )
                                    .map( e -> (Addition)e )
                                    .collect( Collectors.toList() );
    }
}
