package com.training.bean;

public class FeaturesBean {
	private String Name;
	public FeaturesBean() {
	}

	public FeaturesBean(String Name) {
		super();
		this.Name = Name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

		@Override
	public String toString() {
		return "FeaturesBean [Name=" + Name + "]";
	}

}
