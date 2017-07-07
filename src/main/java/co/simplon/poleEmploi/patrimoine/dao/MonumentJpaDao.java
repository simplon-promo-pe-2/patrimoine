package co.simplon.poleEmploi.patrimoine.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.simplon.poleEmploi.patrimoine.modele.Monument;

public class MonumentJpaDao implements MonumentDao {

	private EntityManager cachedEntityManager = null;
	
	@Override
	public Monument getMonumentById(Long id) {
		EntityManager em = getEntityManager();

		return em.find(Monument.class, id);
	}

	@Override
	public void deleteMonumentById(Long id) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		Monument monument = getMonumentById(id);
		if (monument != null) {
			em.remove(monument);
		}
		em.getTransaction().commit();
		
	}

	private EntityManager getEntityManager() {
		if (cachedEntityManager == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BasePatrimoine");
			cachedEntityManager = emf.createEntityManager();
		}
		return cachedEntityManager;
	}

}
