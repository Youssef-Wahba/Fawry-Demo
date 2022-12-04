package DonationFactory;

public class NGODonationFactory implements IDonationFactory{
	@Override
	public IDonation createDonation() {
		return new NGODonation();
	}

}
