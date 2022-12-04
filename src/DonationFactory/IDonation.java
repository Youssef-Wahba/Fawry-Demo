package DonationFactory;

import java.util.HashMap;

public interface IDonation {
	public String ProviderName = "Donations";
	public double getTotalAmount();
	public String getProviderName();
	public String getServiceName();
	public HashMap<String,String> getRequirements();
}