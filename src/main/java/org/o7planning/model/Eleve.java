package org.o7planning.model;

import javax.persistence.*;
import java.util.List;



@Entity
public class Eleve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEleve;

	private String nom;
	private String prenom;

	//bi-directional many-to-one association to Noter
	@OneToMany(mappedBy="eleve")
	private List<Noter> noters;

	public Eleve() {
	}

	public Eleve(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getIdEleve() {
		return this.idEleve;
	}

	public void setIdEleve(Long idEleve) {
		this.idEleve = idEleve;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Noter> getNoters() {
		return this.noters;
	}

	public void setNoters(List<Noter> noters) {
		this.noters = noters;
	}

	public Noter addNoter(Noter noter) {
		getNoters().add(noter);
		noter.setEleve(this);

		return noter;
	}

	public Noter removeNoter(Noter noter) {
		getNoters().remove(noter);
		noter.setEleve(null);

		return noter;
	}

}