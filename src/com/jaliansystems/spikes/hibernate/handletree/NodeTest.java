package com.jaliansystems.spikes.hibernate.handletree;


public class NodeTest {

	public static void main(String[] args) {
		try {
			IntegerConstantNode one = new IntegerConstantNode(1L);
			IntegerConstantNode two = new IntegerConstantNode(2L);
			// Check 1 > 2
			System.out.println("Value of `1 > 2` = "
					+ new BinOpNode(">", one, two).process());
			// Check 1 < 2
			BinOpNode entity = new BinOpNode("<", one, two);
			System.out.println("Value of `1 < 2` = "
					+ entity.process());
			HibernateInterface.saveEntities(entity);
			
			// Check whether the ids are updated
			System.out.println("Entity Saved: ");
			System.out.println("BinOp ID = " + entity.getId());
			System.out.println("One ID = " + one.getId());
			System.out.println("Two ID = " + two.getId());
			
			// Read back the node
			Node node = HibernateInterface.get(new Node(), entity.getId());
			System.out.println("NodeTest.main(): " + node);
			System.out.println("NodeTest.main(): " + node.process());
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}
