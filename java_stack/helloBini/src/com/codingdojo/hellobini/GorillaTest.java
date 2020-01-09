package com.codingdojo.hellobini;

public class GorillaTest  {
	public static void main(String[] args) {
		Gorilla g = new Gorilla();
		g.throwSomething();
		g.throwSomething();
		g.throwSomething();
		g.eatBananas();
		g.eatBananas();
		g.climb();
		
		System.out.print("gorilla energy level is ");
		g.displayEnergy();
		
	}

}
