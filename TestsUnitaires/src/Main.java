import java.util.Scanner;

import functions.Calculette;

public class Main {

	public static void main(String[] args) {
		Calculette c = new Calculette();
		Scanner in = new Scanner(System.in);
		
		do{
			String bouton = in.next();
			c.presserBouton(bouton);
		}while(true);
	}

}
