package at.fhooe.sail.mc.Uebung05.Aufgabe02;

public abstract class ActiveMember extends AbstractMember{
	
	public int activityLevel;

	public ActiveMember(String name, int activityLevel) {
		super(name);
		this.activityLevel = activityLevel;
	}
	
	public abstract double getIncome();

	public abstract double getCost();

	public abstract double getSurplus();

}
