package org.o7planning.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Matiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matiereId;

	private String nom;
	
	private Long idproff;

	//bi-directional many-to-one association to Professeur
	@ManyToOne
	@JoinColumn(name="profId")
	private Professeur professeur;

	//bi-directional many-to-one association to Noter
	@OneToMany(mappedBy="matiere")
	private List<Noter> noters;

	public Matiere() {
	}

	public Matiere(String nom) {
		super();
		this.nom = nom;
	}
	
	public Matiere(String nom, Professeur professeur) {
		super();
		this.nom = nom;
		this.professeur = professeur;
	}
	
	public Long getMatiereId() {
		return this.matiereId;
	}

	public void setMatiereId(Long matiereId) {
		this.matiereId = matiereId;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Professeur getProfesseur() {
		return this.professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	/*
	public List<Noter> getNoters() {
		return this.noters;
	}

	public void setNoters(List<Noter> noters) {
		this.noters = noters;
	}

	public Noter addNoter(Noter noter) {
		getNoters().add(noter);
		noter.setMatiere(this);

		return noter;
	}

	public Noter removeNoter(Noter noter) {
		getNoters().remove(noter);
		noter.setMatiere(null);

		return noter;
	}
	 */

	public Long getIdproff() {
		return idproff;
	}

	public void setIdproff(Long idproff) {
		this.idproff = idproff;
	}

	public List<Noter> getNoters() {
		return noters;
	}

	public void setNoters(List<Noter> noters) {
		this.noters = noters;
	}
	
}