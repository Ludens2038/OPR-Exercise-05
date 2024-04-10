package at.fhooe.sail.mc.Uebung05.Aufgabe02;

public class SupportingMember extends AbstractMember {

	public SupportingMember(String name) {
		super(name);
	}

	@Override
	public double getIncome() {
		return 100;
	}

	@Override
	public double getCost() {
		return 15;
	}

	@Override
	public double getSurplus() {
		return getIncome() - getCost();
	}

}
