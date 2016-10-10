package fr.banque;

public class CompteASeuil extends Compte implements ICompteASeuil{
	private double seuil = 0.0;

	public CompteASeuil(){
		super();
	}
	public CompteASeuil(double seuil){
		this();
		this.seuil = seuil;
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
			e.printStackTrace();
			System.out.println("Retrait impossible");
		}
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
}
