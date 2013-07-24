package com.summer.vshoppingcart.domain;

public enum Type {

	CHURIDAR("Churidar"), SAREE("Saree"), DRESS("Dress");

	public static final Type[] ALL = { CHURIDAR, SAREE, DRESS };

	private final String name;

	public static Type forName(final String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null for type");
		}
		if (name.toUpperCase().equals("CHURIDAR")) {
			return CHURIDAR;
		} else if (name.toUpperCase().equals("SAREE")) {
			return SAREE;
		} else if (name.toUpperCase().equals("DRESS")) {
			return DRESS;
		}
		throw new IllegalArgumentException("Name \"" + name
				+ "\" does not correspond to any Type");
	}

	private Type(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return getName();
	}

}
