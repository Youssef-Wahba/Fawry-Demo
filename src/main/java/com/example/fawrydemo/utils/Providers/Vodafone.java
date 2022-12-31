package com.example.fawrydemo.utils.Providers;

public class Vodafone implements IProvider{
    private final String name="Vodafone EG";
    private final double taxes=0.09;
    private final double additionalAmount=0.007;

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public double getTaxes() {
        return this.taxes;
    }
    @Override
    public double getAdditionalAmount() {
        return this.additionalAmount;
    }
}
