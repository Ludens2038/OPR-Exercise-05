package at.fhooe.sail.mc.Uebung05.Aufgabe02;

public abstract class AbstractMember implements Comparable<AbstractMember> {

	public String name;

	public AbstractMember(String name) {
		this.name = name;
	}

	public abstract double getIncome();

	public abstract double getCost();

	public abstract double getSurplus();
	
	public String toString(boolean ascending) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Name: " + name).append("\n");
		builder.append("Einnahmen: €" + getIncome()).append("\n");
		builder.append("Ausgaben: €" + getCost()).append("\n");
		builder.append("Überschuss: €" + getSurplus()).append("\n").append("\n");
		
		return builder.toString();
	}

	@Override
	public int compareTo(AbstractMember o) {
		return this.name.compareTo(o.name);
	}

}
