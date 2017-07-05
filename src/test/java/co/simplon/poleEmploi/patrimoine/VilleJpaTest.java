package co.simplon.poleEmploi.patrimoine;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import co.simplon.poleEmploi.patrimoine.modele.Ville;

public class VilleJpaTest {

	@Test
	public void l_ensemble_des_monuments_de_Paris_est_accessible() {
		// GIVEN
		Long idRecherche = 3685L;
		
		// WHEN
		EntityManager em = getEntityManager();
		Ville paris = em.find(Ville.class, idRecherche);
		
		// THEN
		assertEquals(4, paris.getMonuments().size());
	}
	
	@Test
	public void la_ville_d_identifiant_25925_doit_etre_Forstfeld() {
		// GIVEN
		Long idRecherche = 25925L;

		// WHEN
		EntityManager em = getEntityManager();
		Ville ville = em.find(Ville.class, idRecherche);

		// THEN
		assertEquals(idRecherche, ville.getId());
		assertEquals("Forstfeld", ville.getNom());
		assertEquals(48.85, ville.getLatitude(), 0);
		assertEquals(8.033333, ville.getLongitude(), 0);
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BasePatrimoine");
		EntityManager em = emf.createEntityManager();
		return em;
	}
}
