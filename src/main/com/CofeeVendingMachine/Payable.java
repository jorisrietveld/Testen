package com.CofeeVendingMachine;

import java.math.BigDecimal;

public interface Payable
{
    /**
     * Complete a order in the coffee vending machine by transacting owed money
     * from the customer of the beverage to the machines owner.
     *
     * @param amount The amount represented in a BigDecimal for floating point precession.
     */
    void pay( BigDecimal amount );

    /**
     * Checks if a payment method is available at the moment.
     *
     * @return The result of the check as a boolean.
     */
    boolean isAvailable();

    /**
     * Checks if this method is disabled.
     * @return
     */
    boolean isDisabled();

    void toggleMethod();
}
