package landlineFactory;

public class MonthlyLandlineFactory implements ILandlineFactory{
	
	@Override
	public ILandlineReciept createLandline() {
		return new MonthlyReciept();
	}

}
