package MobileInternetFactory;

public class VodafoneFactory implements IMobileInternetFactory {
	@Override
	public IInternetPayment createInternetService() {
		return new VodafoneInternetPayment();
	}
	
	@Override
	public IMobileRecharge createMobileService() {
		return new VodafoneMobileRecharge();
	}

}
