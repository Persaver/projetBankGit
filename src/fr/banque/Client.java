package fr.banque;

import java.util.Arrays;

public class Client {
	private static int incNumeroClient;
	
	private final int maxCompte = 5;
	private String nom, prenom;
	private int numero;
	private Compte[] tabCompte = new Compte[0];
	
	public Client(String nom, String prenom) {
		this.numero = Client.incNumeroClient;
		this.nom = nom;
		this.prenom = prenom;
		Client.incNumeroClient++;
	}
	
	public void ajouterCompte(Compte compte) throws BanqueException{
		
		try{
		if(this.tabCompte.length < this.maxCompte){
			Compte[] nTab = new Compte[this.tabCompte.length + 1];
			for(int i = 0; i < this.tabCompte.length; i++){
				nTab[i]=this.tabCompte[i];
			}
			nTab[this.tabCompte.length] = compte;
			this.tabCompte = nTab;
		}else {
			throw new BanqueException();
			}
		}
		catch (BanqueException e) {
			System.out.println("Impossible de céer un nouveau compte");
		}
	}
	public  void retirerCompte(int numeroCompte) {
		if(this.tabCompte.length > 0){
			Compte[] nTab = new Compte[this.tabCompte.length - 1];
			for(int i = 0; i < this.tabCompte.length; i++){
				int j = 0;
				if(this.tabCompte[i].getNumero()== numeroCompte){
					continue;
				}
				nTab[j]=this.tabCompte[i];
				j++;
			}
			this.tabCompte = nTab;
		}
		else {
			System.out.println("Impossible de céer un nouveau compte");
		}
	}
	public Compte getCompte(int numeroCompte) {
		for(int i = 0;i < this.tabCompte.length; i++) {
			if (tabCompte[i].getNumero() == numeroCompte) {
				return tabCompte[i];
			}			
		}
		return null;
	}
	public void verserInterets() {
		Compte[] tabCompte = this.getComptes();
		for(Compte cmpt:tabCompte){
			if(cmpt instanceof ICompteRemunere){
				((CompteRemunere) cmpt).verserInterets();
			}
		}
	}
	public Compte[] getComptes() {
		return this.tabCompte;
	}
	public String getNom() {
		return this.nom;
	}
	public String getPrenom() {
		return this.prenom;
	}
	public int getNumero() {
		return this.numero;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", tabCompte=");
		builder.append(Arrays.toString(tabCompte));
		builder.append("]");
		return builder.toString();
	}
}
