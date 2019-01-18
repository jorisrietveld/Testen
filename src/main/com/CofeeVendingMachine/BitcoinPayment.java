package com.CofeeVendingMachine;

import java.math.BigDecimal;
import java.net.URL;

public class BitcoinPayment extends NetworkPayment
{
    public BitcoinPayment() throws Exception
    {
        super( new URL( "https://bitcoin.com" ) );
    }

    /**
     * Complete a order in the coffee vending machine by transacting owed money
     * from the customer of the beverage to the machines owner.
     *
     * @param amount The amount represented in a BigDecimal for floating point precession.
     */
    @Override
    public void pay( BigDecimal amount )
    {
        // Do nothing with it it always works.
    }

    /**
     * Checks if a payment method is available at the moment.
     *
     * @return The result of the check as a boolean.
     */
    @Override
    public boolean isAvailable()
    {
        return false;
    }
}
