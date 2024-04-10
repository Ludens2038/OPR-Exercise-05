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
		return 0;
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
