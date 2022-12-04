package MobileInternetFactory;

import java.util.HashMap;

public interface IVodafoneService {
	public String ProviderName = "Vodafone EG";
	public double getTotalAmount();
	public String getProviderName();
	public String getServiceName();
	public HashMap<String,String> getRequirements();
}
