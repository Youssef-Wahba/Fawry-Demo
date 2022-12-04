package landlineFactory;

public class QuarterLandlineFactory implements ILandlineFactory{
	@Override
	public ILandlineReciept createLandline() {
		return new QuarterReciept();
	}

}