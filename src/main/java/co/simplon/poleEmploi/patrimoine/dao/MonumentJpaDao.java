package co.simplon.poleEmploi.patrimoine.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.simplon.poleEmploi.patrimoine.modele.Monument;

public class MonumentJpaDao implements MonumentDao {

	@Override
	public Monument getMonumentById(Long id) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BasePatrimoine");
		EntityManager em = emf.createEntityManager();
		
		return em.find(Monument.class, id);
	}

}
