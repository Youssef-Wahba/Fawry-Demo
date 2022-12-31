package com.example.fawrydemo.utils.Providers;

public class We implements IProvider{
    private final String name="We EG";
    private final double taxes=0.01;
    private final double additionalAmount=0.001;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getTaxes() {
        return taxes;
    }

    @Override
    public double getAdditionalAmount() {
        return additionalAmount;
    }
}
