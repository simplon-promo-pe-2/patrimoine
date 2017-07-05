package co.simplon.poleEmploi.patrimoine.modele;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "MONUMENTS")
@NamedQuery(name = "Monument.findAll", query = "SELECT m FROM Monument m")
public class Monument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long identifiant;

	@Column(name = "CITIES_ID", nullable = false)
	private int identifiantVille;

	@Column(name = "NAME", nullable = false, length = 100)
	private String nom;

	public Monument(String nom) {
		super();
		this.nom = nom;
	}

	public Monument() {
	}

	public Long getIdentifiant() {
		return this.identifiant;
	}

	public void setIdentifiant(Long identifiant) {
		this.identifiant = identifiant;
	}

	public int getIdentifiantVille() {
		return this.identifiantVille;
	}

	public void setIdentifiantVille(int citiesId) {
		this.identifiantVille = citiesId;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}