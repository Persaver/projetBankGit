package fr.banque;

public class CompteRemunere  extends Compte implements ICompteRemunere {

	private final double tauxMin = 0.0;
	private final double tauxMax = 1.0;
	private double taux = 0.0;

	public CompteRemunere() {
		super();
	}
	public CompteRemunere(double taux) {
		this();
		this.setTaux(taux);
	}
	public CompteRemunere(double taux, double solde){
		this();
		this.setSolde(solde);
		this.setTaux(taux);
	}
	public double getTaux(){
		return this.taux;
	}
	public void setTaux(double taux){
		if(this.tauxValable(taux)){
			this.taux = taux;
		}
		else {
			System.out.println("taux non valable");
		}
	}
	
	private boolean tauxValable(double taux){
		return taux > this.tauxMin && taux < this.tauxMax;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("CompteRemunere [taux=").append(taux);
		builder.append("]");
		
		return builder.toString();
	}
	public double calculerInterets() {
		double interets = this.getSolde()*this.taux;
		return interets ;
	}
	public void verserInterets(){
		double nSolde = this.getSolde() + this.calculerInterets();
		this.setSolde(nSolde);
	}

}
