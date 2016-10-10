package fr.banque;

public class Compte {
	
	private static  int incNumCompte = 0;
	
	private int numero = 0;
	private double solde = 0;
	
	public Compte(){
		this.numero = Compte.incNumCompte;
		Compte.incNumCompte++;
	}
	public Compte(int solde) {
		this();
		this.solde = solde;
	}
	public void ajouter(double valeur) {
		this.solde+=valeur;
	}
	
	public void retirer(double valeur) throws BanqueException{
			this.setSolde(valeur);
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public int getNumero() {
		return this.numero;
	}
	
	public double getSolde(){
		return this.solde;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compte [numero=");
		builder.append(numero);
		builder.append(", solde=");
		builder.append(solde);
		builder.append("]");
		return builder.toString();
	}
}
