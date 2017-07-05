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

	@Column(name = "NAME", nullable = false, length = 100)
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="CITIES_ID")
	private Ville ville;

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

	@Deprecated
	public Long getIdentifiantVille() {
		return this.ville.getId();
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

}