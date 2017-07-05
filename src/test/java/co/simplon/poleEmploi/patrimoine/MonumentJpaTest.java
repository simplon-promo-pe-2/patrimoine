package co.simplon.poleEmploi.patrimoine;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import co.simplon.poleEmploi.patrimoine.modele.Monument;

public class MonumentJpaTest {

	@Test
	public void le_monument_d_identifiant_5_doit_etre_Tour_Eiffel() {
		// GIVEN
		Long idRecherche = 5L;

		// WHEN
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BasePatrimoine");
		EntityManager em = emf.createEntityManager();
		Monument monument = em.find(Monument.class, idRecherche);

		// THEN
		assertEquals(idRecherche, monument.getIdentifiant());
		assertEquals("Tour Eiffel", monument.getNom());
		assertEquals(new Long(3685), monument.getVille().getId());
		assertEquals("Palis", monument.getVille().getNom());
	}
}
