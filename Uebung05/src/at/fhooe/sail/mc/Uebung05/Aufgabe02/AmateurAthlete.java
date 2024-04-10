package at.fhooe.sail.mc.Uebung05.Aufgabe02;

public class AmateurAthlete extends ActiveMember{

	public AmateurAthlete(String name, int activityLevel) {
		super(name, activityLevel);
	}

	@Override
	public double getIncome() {
		return 25 * 12;
	}

	@Override
	public double getCost() {
		return activityLevel * 2.5;
	}

	@Override
	public double getSurplus() {
		return getIncome() - getCost();
	}

}
