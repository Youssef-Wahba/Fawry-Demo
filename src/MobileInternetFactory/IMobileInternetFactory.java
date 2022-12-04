package MobileInternetFactory;

public interface IMobileInternetFactory {
	public IVodafoneService createVodafoneService();
	public IEtisalatService createEtisalatService();
}
