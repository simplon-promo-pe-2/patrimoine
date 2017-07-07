package co.simplon.poleEmploi.patrimoine.dao;

import co.simplon.poleEmploi.patrimoine.modele.Monument;

public interface MonumentDao {
	Monument getMonumentById(Long id);

	void deleteMonumentById(Long id);

	Monument createMonument(Monument monument, Long identifiantVille);
}
