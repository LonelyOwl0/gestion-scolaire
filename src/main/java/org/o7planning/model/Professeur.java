package org.o7planning.model;


import javax.persistence.*;


import java.util.List;

@Entity
public class Professeur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long profId;

	private String email;
	private String nom;
	private String prenom;

	
	//bi-directional many-to-one association to FaireCour
	@OneToMany(mappedBy="professeur")
	private List<FaireCour> faireCours;

	//bi-directional many-to-one association to Matiere
	@OneToMany(mappedBy="professeur")
	private List<Matiere> matieres;

	//bi-directional many-to-one association to Noter
	@OneToMany(mappedBy="professeur")
	private List<Noter> noters;

	public Professeur() {
	}
	
	public Professeur(String email, String nom, String prenom) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getProfId() {
		return this.profId;
	}

	public void setProfId(Long profId) {
		this.profId = profId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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


	public List<FaireCour> getFaireCours() {
		return this.faireCours;
	}

	public void setFaireCours(List<FaireCour> faireCours) {
		this.faireCours = faireCours;
	}

	public FaireCour addFaireCour(FaireCour faireCour) {
		getFaireCours().add(faireCour);
		faireCour.setProfesseur(this);

		return faireCour;
	}

	public FaireCour removeFaireCour(FaireCour faireCour) {
		getFaireCours().remove(faireCour);
		faireCour.setProfesseur(null);

		return faireCour;
	}

	public List<Matiere> getMatieres() {
		return this.matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public Matiere addMatiere(Matiere matiere) {
		getMatieres().add(matiere);
		matiere.setProfesseur(this);

		return matiere;
	}

	public Matiere removeMatiere(Matiere matiere) {
		getMatieres().remove(matiere);
		matiere.setProfesseur(null);

		return matiere;
	}

	public List<Noter> getNoters() {
		return this.noters;
	}

	public void setNoters(List<Noter> noters) {
		this.noters = noters;
	}

	public Noter addNoter(Noter noter) {
		getNoters().add(noter);
		noter.setProfesseur(this);

		return noter;
	}

	public Noter removeNoter(Noter noter) {
		getNoters().remove(noter);
		noter.setProfesseur(null);

		return noter;
	}

}