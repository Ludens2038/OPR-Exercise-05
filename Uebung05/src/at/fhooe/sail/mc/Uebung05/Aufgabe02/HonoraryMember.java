package at.fhooe.sail.mc.Uebung05.Aufgabe02;

public class HonoraryMember extends AbstractMember{

	public HonoraryMember(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getIncome() {
		return 0;
	}

	@Override
	public double getCost() {
		return 20;
	}

	@Override
	public double getSurplus() {
		return getIncome() - getCost();
	}

}
