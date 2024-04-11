package at.fhooe.sail.mc.Uebung05.Aufgabe02;

import at.fhooe.sail.mc.Uebung05.Aufgabe01.*;

//subclass of the abstract member for sections
public class Section extends AbstractMember {

	// binary search tree to store the members of the section in a sorted order
	private BinarySearchTree<AbstractMember> tree = new BinarySearchTree();

	// constructor of the section
	public Section(String name) {
		super(name);
	}

	// method to add a member to the section
	boolean addMember(AbstractMember m) {
		// calling the insert method of the binary search tree to add the member
		return tree.insert(m);
	}

	// method to remove a member from the section
	boolean removeMember(AbstractMember m) {
		// calling the remove method of the binary search tree to remove the member
		return tree.remove(m);
	}

	// method to check if a member is a member of the section
	boolean isMember(AbstractMember m) {
		// calling the find method of the binary search tree to check if the member is a
		// member of the section
		return tree.find(m);
	}

	@Override
	// overriding the method of the abstract member to get the income of the section
	public double getIncome() {
		// calling the toArray method of the binary search tree to get the members of
		// the section
		Comparable<AbstractMember>[] member = tree.toArray(true);
		double income = 0.0;
		// iterating through the members of the section and adding their income
		for (int i = 0; i < member.length; i++) {
			// casting the member to an abstract member and calling the getIncome method
			income += ((AbstractMember) member[i]).getIncome();
		}
		return income;
	}

	@Override
	// overriding the method of the abstract member to get the cost of the section
	public double getCost() {
		// calling the toArray method of the binary search tree to get the members of
		// the section
		Comparable<AbstractMember>[] member = tree.toArray(true);
		double cost = 0.0;
		// iterating through the members of the section and adding their cost
		for (int i = 0; i < member.length; i++) {
			// casting the member to an abstract member and calling the getCost method
			cost += ((AbstractMember) member[i]).getCost();
		}
		return cost;
	}

	@Override
	// overriding the method of the abstract member to get the surplus of the
	// section
	public String toString(boolean sorted) {
		// calling the toArray method of the binary search tree to get the members of
		// the section
		Comparable<AbstractMember>[] member = tree.toArray(sorted);
		/*
		 * creating a string builder to build the string representation of the section
		 * adding the name, income, cost, surplus and the members of the section
		 */
		StringBuilder builder = new StringBuilder();
		builder.append("Name: " + name).append("\n");
		builder.append("Einnahmen: €" + getIncome()).append("\n");
		builder.append("Ausgaben: €" + getCost()).append("\n");
		builder.append("Überschuss: €" + getSurplus()).append("\n").append("\n");
		int spacer = 0;
		// iterating through the members of the section and adding their string
		// representation
		for (int i = 0; i < member.length; i++) {
			builder.append(((AbstractMember) member[i]).toString(true));
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		Section s = new Section("Dodlschach");
		s.addMember(new ChairMember("Haris", 100));
		s.addMember(new HonoraryMember("Nikolaus"));
		s.addMember(new TopAthlete("Axel", 10));

		Section s2 = new Section("Schach");
		s2.addMember(new ChairMember("Hermann", 100));
		s2.addMember(new HonoraryMember("Peter"));
		s2.addMember(new TopAthlete("Max", 10));

		Section sportverein = new Section("Sportverein");
		sportverein.addMember(s2);
		sportverein.addMember(s);
		sportverein.addMember(new ChairMember("Hans", 100));
		sportverein.addMember(new HonoraryMember("Paul"));
		sportverein.addMember(new TopAthlete("Fritz", 10));

		Section s4 = new Section("Fussball");
		s4.addMember(new ChairMember("Manuel", 100));
		s4.addMember(new HonoraryMember("Franz"));
		s4.addMember(new TopAthlete("Sepp", 10));

		sportverein.addMember(s4);

		System.out.println(sportverein.toString(true));
	}

}
