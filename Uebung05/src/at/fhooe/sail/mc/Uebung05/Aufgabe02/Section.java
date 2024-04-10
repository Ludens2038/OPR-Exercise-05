package at.fhooe.sail.mc.Uebung05.Aufgabe02;

import at.fhooe.sail.mc.Uebung05.Aufgabe01.*;

public class Section extends AbstractMember {

	private BinarySearchTree tree = new BinarySearchTree();

	public Section(String name) {
		super(name);
	}

	boolean addMember(AbstractMember m) {
		return tree.insert(m);
	}

	boolean removeMember(AbstractMember m) {
		return tree.remove(m);
	}

	boolean isMember(AbstractMember m) {
		return tree.find(m);
	}

	@Override
	public double getIncome() {
		AbstractMember[] member = (AbstractMember[]) tree.toArray(true);
		double income = 0.0;
		for(int i = 0; i < member.length; i++) {
			income += member[i].getIncome();
			}
		return income;
	}

	@Override
	public double getCost() {
		return 0;
	}

	@Override
	public double getSurplus() {
		return 0;
	}

}
