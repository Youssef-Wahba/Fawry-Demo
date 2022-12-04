package Discount;


public class SpecificDiscount extends Discount{
	
	private IApplyDiscount dis;
	private float discountPercent;
	
	public SpecificDiscount(IApplyDiscount dis,float discountPercent) {
		this.dis = dis;
		this.discountPercent = discountPercent;
	}
	
	@Override
	public double getTotalAmount() {
		return dis.getTotalAmount()-(dis.getTotalAmount()/100);
	}
	
	@Override
	public String getServiceName() {
		return dis.getServiceName()+" (discount "+discountPercent+"% applied)";
	}

}
