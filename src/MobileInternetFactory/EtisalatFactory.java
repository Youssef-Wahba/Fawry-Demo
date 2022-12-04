package MobileInternetFactory;

public class EtisalatFactory implements IMobileInternetFactory{
	@Override
	public IInternetPayment createInternetService() {
		return new EtisalatInternetPayment();
	}
	
	@Override
	public IMobileRecharge createMobileService() {
		return new EtisalatMobileRecharge();
	}

}
