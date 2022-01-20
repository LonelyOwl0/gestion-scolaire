package org.o7planning.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class FaireCour  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFaireCours;

	private Date volhoraire;

	//bi-directional many-to-one association to Classe
	@ManyToOne
	@JoinColumn(name="idClasse")
	private Classe classe;

	//bi-directional many-to-one association to Professeur
	@ManyToOne
	@JoinColumn(name="profId")
	private Professeur professeur;

	public FaireCour() {
	}

	public FaireCour(Date volhoraire, Classe classe, Professeur professeur) {
		super();
		this.volhoraire = volhoraire;
		this.classe = classe;
		this.professeur = professeur;
	}

	public Long getIdFaireCours() {
		return this.idFaireCours;
	}

	public void setIdFaireCours(Long idFaireCours) {
		this.idFaireCours = idFaireCours;
	}

	public Date getVolhoraire() {
		return this.volhoraire;
	}

	public void setVolhoraire(Date volhoraire) {
		this.volhoraire = volhoraire;
	}

	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Professeur getProfesseur() {
		return this.professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

}