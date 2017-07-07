package co.simplon.poleEmploi.patrimoine;

import co.simplon.poleEmploi.patrimoine.dao.MonumentDao;
import co.simplon.poleEmploi.patrimoine.dao.MonumentJpaDao;
import co.simplon.poleEmploi.patrimoine.modele.Monument;

public class GestionnairePatrimoine {

	public static void main(String[] args) {
		MonumentDao monumentDao = new MonumentJpaDao();
		int nbArguments = args.length;
		
		if (nbArguments > 0) {
			Long idMonument = null;
	
			try {
				idMonument = Long.parseLong(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Le premier paramètre d'appel n'est pas un long : " + e.getMessage());
				System.exit(-1);
			}
	
			Monument monument = monumentDao.getMonumentById(idMonument);
			if (monument != null) {
				System.out.println("Monument correspondant à l'id " + idMonument + " : " + monument);
			} else {
				System.out.println("Aucun monument correspondant à l'id " + idMonument);
			}
		}
		
		if (nbArguments > 1) {
			Long idMonument = null;
			
			try {
				idMonument = Long.parseLong(args[1]);
			} catch (NumberFormatException e) {
				System.err.println("Le second paramètre d'appel n'est pas un long : " + e.getMessage());
				System.exit(-1);
			}
			
			monumentDao.deleteMonumentById(idMonument);
			System.out.println("Le monument d'id " + idMonument + " a été supprimé");
		}
		
		Monument nouveauMonument = new Monument("La montagne des singes");
		Monument monumentCree = monumentDao.createMonument(nouveauMonument, 13L);
		System.out.println("Le monument créé est le suivant : " + monumentCree);
		
		
	}

}
