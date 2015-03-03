package com.jaliansystems.spikes.hibernate.handletree;


public class NodeTest {

	public static void main(String[] args) {
		try {
			// Create an entity for (1 + 2) > (2 + 3)
			Node multiop = new BinOpNode(">", new BinOpNode("+", new IntegerConstantNode(1), new IntegerConstantNode(2)),
					new BinOpNode("+", new IntegerConstantNode(2), new IntegerConstantNode(3)));
			// Save to DB
			HibernateInterface.saveEntities(multiop);
			System.out.println("Saved: The entity ID = " + multiop.getId());
			
			// Retrieve from the DB
			Node node = HibernateInterface.get(new Node(), multiop.getId());
			System.out.println("Retrieving from DB. Node = " + node);
			System.out.println("Processing node gives output:" + node.process());
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}
