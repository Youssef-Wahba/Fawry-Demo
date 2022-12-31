package com.example.fawrydemo.utils.Providers;

public class Etisalat implements IProvider{
    private final String name="Etisalat EG";
    private final double taxes=0.04;
    private final double additionalAmount=0.01;

    @Override
    public String getName() { return name; }
    @Override
    public double getTaxes() { return taxes; }
    @Override
    public double getAdditionalAmount() { return additionalAmount; }
}
