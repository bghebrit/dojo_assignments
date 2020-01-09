package com.codingdojo.hellobini;

public class Gorilla extends Mammal{
	
	public void throwSomething() {
		System.out.println("gorilla throws some bana");
		this.setEnergyLevel(this.getEnergyLevel()-5);
	}
	//throwSomething()
	//eatBananas()
	//climb()
	public void eatBananas() {
		System.out.println("gorilla eats bananas");
		this.setEnergyLevel(this.getEnergyLevel() + 10);
	}
	public void climb() {
		System.out.println("gorilla climbing");
		this.setEnergyLevel(this.getEnergyLevel()-10);
	}

}
