package MobileInternetFactory;

public class InternetPaymentFactory implements IMobileInternetFactory {
	@Override
	public IVodafoneService createVodafoneService() {
		return new VodafoneInternetPayment();
	}
	
	@Override
	public IEtisalatService createEtisalatService() {
		return new EtisalatInternetPayment();
	}

}
