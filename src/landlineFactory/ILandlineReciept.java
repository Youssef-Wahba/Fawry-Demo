package landlineFactory;

import java.util.HashMap;

public interface ILandlineReciept {
	public String providerName = "Landline-EG";
	public double getTotalAmount();
	public String getProviderName();
	public String getServiceName();
	public HashMap<String,String> getRequirements();
}
