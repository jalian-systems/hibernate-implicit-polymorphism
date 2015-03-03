package com.jaliansystems.spikes.hibernate.handletree;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "ID")
public class BinOpNode extends Node {

	private String op;
	@OneToOne(cascade=CascadeType.ALL)
	private Node leftNode;
	@OneToOne(cascade=CascadeType.ALL)
	private Node rightNode;

	public BinOpNode() {
	}
	
	public BinOpNode(String op, Node leftNode, Node rightNode) {
		this.op = op;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	@Override
	public Object process() {
		Object left = leftNode.process();
		Object right = rightNode.process();
		if (op.equals(">"))
			return isGreaterThan(left, right);
		else if (op.equals("<"))
			return isLessThan(left, right);
		else if (op.equals("=="))
			return isEquals(left, right);
		else if (op.equals("+"))
			return plus(left, right);
		else if (op.equals("-"))
			return minus(left, right);
		return null;
	}

	private Object minus(Object left, Object right) {
		assumeTrue(left instanceof Number);
		assumeTrue(right instanceof Number);
		return ((Number) left).longValue() - ((Number) right).longValue();
	}

	private Object plus(Object left, Object right) {
		assumeTrue(left instanceof Number);
		assumeTrue(right instanceof Number);
		return ((Number) left).longValue() + ((Number) right).longValue();
	}

	private Object isEquals(Object left, Object right) {
		assumeTrue(left instanceof Number);
		assumeTrue(right instanceof Number);
		return ((Number) left).longValue() == ((Number) right).longValue();
	}

	private Object isLessThan(Object left, Object right) {
		assumeTrue(left instanceof Number);
		assumeTrue(right instanceof Number);
		return ((Number) left).longValue() < ((Number) right).longValue();
	}

	private Object isGreaterThan(Object left, Object right) {
		assumeTrue(left instanceof Number);
		assumeTrue(right instanceof Number);
		return ((Number) left).longValue() > ((Number) right).longValue();
	}

	private void assumeTrue(boolean b) {
		if (!b)
			throw new RuntimeException("AssumeTrue failed");
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	@Override
	public String toString() {
		return "(" + op + ", " + leftNode + ", " + rightNode + ")";
	}
}
