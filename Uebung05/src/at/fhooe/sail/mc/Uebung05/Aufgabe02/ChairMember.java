package at.fhooe.sail.mc.Uebung05.Aufgabe02;

public class ChairMember extends AbstractMember{
	
	public int competenceLevel;

	public ChairMember(String name, int competenceLevel) {
		super(name);
		this.competenceLevel = competenceLevel;
	}

	@Override
	public double getIncome() {
		return competenceLevel * 100;
	}

	@Override
	public double getCost() {
		return getIncome() * 0.2;
	}

	@Override
	public double getSurplus() {
		return getIncome() - getCost();
	}

}
