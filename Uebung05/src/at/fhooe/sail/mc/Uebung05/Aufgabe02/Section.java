package at.fhooe.sail.mc.Uebung05.Aufgabe02;

import at.fhooe.sail.mc.Uebung05.Aufgabe01.BinarySearchTree;

//subclass of the abstract member for sections
public class Section extends AbstractMember {
    private static int indent = 0;

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
    //ovveride the toString method of the abstract member to get the string representation of the section
    public String toString(boolean sorted) {
        Comparable<AbstractMember>[] member = tree.toArray(sorted);
        StringBuilder builder = new StringBuilder();
        builder.append("Union: " + name + ", Income: " + getIncome() + ", Cost: " + getCost() + ", Surplus: " + getSurplus() + "\n");

        // iterating through the members of the section and adding their string representation
        for (int i = 0; i < member.length; i++) {
            // checking if the member is a section or an abstract member
            if (member[i] instanceof Section) {
                indent++;
                builder.append(getIndent() + ((Section) member[i]).toString(sorted));
                indent--;
            } else if (member[i] instanceof AbstractMember) {
                indent++;
                builder.append(getIndent() + ((AbstractMember) member[i]).toString(true));
                indent--;
            }
        }

        return builder.toString();
    }

    // method to get the indent for the string representation
    private String getIndent() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            builder.append("  ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        TopAthlete axel = new TopAthlete("Axel", 10);
        TopAthlete christoph = new TopAthlete("Christoph", 10);


        HonoraryMember niklas = new HonoraryMember("Niklas");
        HonoraryMember emre = new HonoraryMember("Emre");

        ChairMember haris = new ChairMember("Haris", 10);
        ChairMember fabian = new ChairMember("Fabian", 10);

        Trainer eric = new Trainer("Eric", 10);
        Trainer holzi = new Trainer("Holzi", 10);

        AmateurAthlete sebastian = new AmateurAthlete("Sebastian", 10);
        AmateurAthlete jonas = new AmateurAthlete("Jonas", 10);


        SupportingMember Landeshauptmann = new SupportingMember("Landeshauptmann");

        Section vereinHagenberg = new Section("Verein Hagenberg");
        Section Dodlschach = new Section("Dodlschach");
        Section Fußball = new Section("Fußball");

        Dodlschach.addMember(axel);
        Dodlschach.addMember(niklas);
        Dodlschach.addMember(haris);
        Dodlschach.addMember(eric);
        Dodlschach.addMember(sebastian);

        Fußball.addMember(christoph);
        Fußball.addMember(emre);
        Fußball.addMember(fabian);
        Fußball.addMember(holzi);
        Fußball.addMember(jonas);

        vereinHagenberg.addMember(Dodlschach);
        vereinHagenberg.addMember(Fußball);
        vereinHagenberg.addMember(Landeshauptmann);

        Section Frauenfußball = new Section("Frauenfußball");
        Frauenfußball.addMember(new TopAthlete("Lena", 10));
        Frauenfußball.addMember(new TopAthlete("Sarah", 10));

        Fußball.addMember(Frauenfußball);

        System.out.println(vereinHagenberg.toString(true));
    }

}
