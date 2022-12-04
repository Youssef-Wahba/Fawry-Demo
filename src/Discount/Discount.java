package Discount;

import fawryDemo.IService;


public abstract class Discount	implements IApplyDiscount{	
	@Override
	public abstract double getTotalAmount();
	@Override
	public abstract String getServiceName();
}