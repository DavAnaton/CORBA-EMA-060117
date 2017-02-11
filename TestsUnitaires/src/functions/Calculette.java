package functions;

public class Calculette {
	// Attributs
	private String operande;
	private double resultat;
	private String value;
	
	// Constructeurs
	public Calculette(){
		this.operande = null;
		this.resultat = 0;
		this.value = "";
	}
	
	// Getters & Setters
	public double getResultat(){
		return this.resultat;
	}
	
	public void setOperande(String operande){
		this.operande = operande;
	}
	
	// Methodes
	public void presserBouton(String bouton){
		switch(bouton){
		case "+":
		case "-":
		case "*":
		case "/":
			this.operande = bouton;
			this.resultat = Double.parseDouble(this.value);
			this.value = "";
			break;
		case "=":
			System.out.print(this.resultat + " " + this.operande + " " + this.value + " = ");
			this.calculer();
			System.out.println(this.resultat);
			break;
		default:
			this.value += bouton;
		}
	}
	
	private void additionner(){
		this.resultat += Double.parseDouble(this.value);
		this.value = "";
	}

	private void soustraire(){
		this.value += "1";
		this.resultat -= Double.parseDouble(this.value);
		this.value = "";
	}

	private void diviser(){
		this.resultat /= Double.parseDouble(this.value);
		this.value = "";
	}

	private void multiplier(){
		this.resultat *= Double.parseDouble(this.value);
		this.value = "";
	}
	private void calculer(){
		switch(this.operande){
		case "+":
			this.additionner();
			break;
		case "-":
			this.soustraire();
			break;
		case "*":
			this.multiplier();
			break;
		case "/":
			this.diviser();
			break;
		}
	}
}
