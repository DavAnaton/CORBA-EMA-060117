package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import functions.Calculette;

public class TestCalculette {

	@Test
	public void addition() {
		Calculette c = new Calculette();
		c.presserBouton("4");
		c.presserBouton("+");
		c.presserBouton("5");
		c.presserBouton("=");
		double resultat = c.getResultat();
		assertEquals(9, resultat, 0.000000001);
	}
	
	@Test
	public void soustraction() {
		Calculette c = new Calculette();
		c.presserBouton("4");
		c.presserBouton("-");
		c.presserBouton("5");
		c.presserBouton("=");
		double resultat = c.getResultat();
		assertEquals(-1, resultat, 0.000000001);
	}
	
	@Test
	public void multiplication() {
		Calculette c = new Calculette();
		c.presserBouton("4");
		c.presserBouton("*");
		c.presserBouton("5");
		c.presserBouton("=");
		double resultat = c.getResultat();
		assertEquals(20, resultat, 0.000000001);
	}
//	
//	@Test
//	public void division() {
//		Calculette c = new Calculette();
//		c.presserBouton("4");
//		c.presserBouton("/");
//		c.presserBouton("5");
//		c.presserBouton("=");
//		double resultat = c.getResultat();
//		assertEquals(0.8, resultat, 0.000000001);
//	}

}
