package fr.banque;

public class CompteASeuilRemunere extends CompteRemunere implements ICompteASeuil, ICompteRemunere{
	
	private double seuil = 0.0;
	
	public CompteASeuilRemunere() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public CompteASeuilRemunere(double taux,double solde){
		super(taux,solde);
	}
	
	public CompteASeuilRemunere(double taux,double solde,double seuil){
		this(taux,solde);
		this.setSeuil(seuil);
	}

	@Override
	public double getSeuil() {
		// TODO Auto-generated method stub
		return this.seuil;
	}

	@Override
	public void setSeuil(double unSeuil) {
		// TODO Auto-generated method stub
		this.seuil = unSeuil;
		
	}
	public void retirer(double valeur) throws BanqueException{
		try{
			if(this.getSolde() - valeur > this.seuil ){
				super.retirer(valeur);
			}else{
				throw new BanqueException();
			}
		}
		catch (BanqueException e){
//			e.printStackTrace();
			System.out.println("Retrait impossible");
		}
	}

}
