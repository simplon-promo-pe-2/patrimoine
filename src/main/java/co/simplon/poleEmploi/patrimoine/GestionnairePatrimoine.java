package co.simplon.poleEmploi.patrimoine;

import co.simplon.poleEmploi.patrimoine.dao.MonumentDao;
import co.simplon.poleEmploi.patrimoine.dao.MonumentJpaDao;
import co.simplon.poleEmploi.patrimoine.modele.Monument;

public class GestionnairePatrimoine {

	public static void main(String[] args) {
		MonumentDao monumentDao = new MonumentJpaDao();
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

}
