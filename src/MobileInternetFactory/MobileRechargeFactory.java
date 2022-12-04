package MobileInternetFactory;

public class MobileRechargeFactory implements IMobileInternetFactory{
	@Override
	public IVodafoneService createVodafoneService() {
		return new VodafoneMobileRecharge();
	}
	
	@Override
	public IEtisalatService createEtisalatService() {
		return new EtisalatMobileRecharge();
	}

}
