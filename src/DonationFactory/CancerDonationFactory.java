package DonationFactory;

public class CancerDonationFactory implements IDonationFactory{
	@Override
	public IDonation createDonation() {
		return new CancerDonation();
	}
}