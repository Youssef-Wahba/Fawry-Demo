package DonationFactory;

public class SchoolDonationFactory implements IDonationFactory{
	@Override
	public IDonation createDonation() {
		return new SchoolDonation();
	}
}
