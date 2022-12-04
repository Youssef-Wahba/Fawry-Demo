package MobileInternetFactory;

public interface IMobileInternetFactory {
	public IInternetPayment createInternetService();
	public IMobileRecharge createMobileService();
}
