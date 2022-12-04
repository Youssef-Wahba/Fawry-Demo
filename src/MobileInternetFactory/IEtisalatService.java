package MobileInternetFactory;

import java.util.HashMap;

public interface IEtisalatService {
	public String ProviderName = "Etisalat EG";
	public double getTotalAmount();
	public String getProviderName();
	public String getServiceName();
	public HashMap<String,String> getRequirements();
}
