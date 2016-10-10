
import fr.banque.BanqueException;
import fr.banque.Client;
import fr.banque.Compte;
import fr.banque.CompteASeuilRemunere;
import fr.banque.CompteRemunere;

public class Run {

	public static void main(String[] args) throws BanqueException {
		// TODO Auto-generated method stub
		Compte compt1 = new Compte(200);
		Compte compt2 = new Compte(500);
		Compte compt3 = new Compte(100);
		
		System.out.println(compt1.toString());
		
		compt1.ajouter(2400);
		System.out.println(compt1.toString());

		compt2.retirer(50);
		System.out.println(compt2.toString());
		
		Client clt1 = new Client("robert","dudul");
		
		System.out.println(clt1.toString());
		try {
			clt1.ajouterCompte(compt1);
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(clt1.toString());
		clt1.ajouterCompte(compt2);
		System.out.println(clt1.toString());
		clt1.retirerCompte(compt1.getNumero());
		System.out.println(clt1.toString());
		
		Compte[] tabCompte = clt1.getComptes();
		System.out.println("for compte");
		for (Compte compte: tabCompte){
			System.out.println(compte.toString());
		}
		CompteRemunere cmptR = new CompteRemunere(0.05,100);
		System.out.println(cmptR);
		clt1.ajouterCompte(cmptR);
		System.out.println(cmptR);
		clt1.verserInterets();
		tabCompte = clt1.getComptes();
		System.out.println("for compte");
		for (Compte compte: tabCompte){
			System.out.println(compte.toString());
		}
		
		CompteASeuilRemunere cmptSR = new CompteASeuilRemunere(0.05, 2000, -100);
		System.out.println(cmptSR);
		
		clt1.ajouterCompte(cmptSR);
		
		clt1.verserInterets();
		
		tabCompte = clt1.getComptes();
		System.out.println("for compte");
		for (Compte compte: tabCompte){
			System.out.println(compte.toString());
		}
		clt1.ajouterCompte(compt3);
		clt1.ajouterCompte(compt3);
		clt1.ajouterCompte(compt3);
		clt1.ajouterCompte(compt3);
		cmptSR.retirer(100000);
		
		CompteASeuilRemunere cmptS = new CompteASeuilRemunere();
		cmptS.retirer(10000);
	}
	

}
