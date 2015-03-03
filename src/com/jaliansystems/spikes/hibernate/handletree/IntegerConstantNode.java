package com.jaliansystems.spikes.hibernate.handletree;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "ID")
public class IntegerConstantNode extends Node {

	private Long value;

	public IntegerConstantNode() {
	}

	public IntegerConstantNode(long value) {
		this.value = Long.valueOf(value);
	}

	@Override
	public Object process() {
		return value;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "(" + value + ")" ;
	}
}
