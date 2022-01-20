package org.o7planning.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Noter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNote;

	private Date date;
	private float note;
	
	private Long idprof, idelevee, idmatiere;

	//bi-directional many-to-one association to Professeur
	@ManyToOne
	@JoinColumn(name="profId")
	private Professeur professeur;

	//bi-directional many-to-one association to Matiere
	@ManyToOne
	@JoinColumn(name="matiereId")
	private Matiere matiere;

	//bi-directional many-to-one association to Eleve
	@ManyToOne
	@JoinColumn(name="idEleve")
	private Eleve eleve;

	public Noter() {
	}

	public Noter(Long idNote, Date date, float note, Professeur professeur, Matiere matiere, Eleve eleve) {
		super();
		this.date = date;
		this.note = note;
		this.professeur = professeur;
		this.matiere = matiere;
		this.eleve = eleve;
	}
	
	public Noter(Date date, float note, Long idprof, Long idelevee, Long idmatiere) {
		super();
		this.date = date;
		this.note = note;
		this.idprof = idprof;
		this.idelevee = idelevee;
		this.idmatiere = idmatiere;
	}

	public Long getIdNote() {
		return this.idNote;
	}

	public void setIdNote(Long idNote) {
		this.idNote = idNote;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getNote() {
		return this.note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	public Professeur getProfesseur() {
		return this.professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Eleve getEleve() {
		return this.eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Long getIdprof() {
		return idprof;
	}

	public void setIdprof(Long idprof) {
		this.idprof = idprof;
	}

	public Long getIdelevee() {
		return idelevee;
	}

	public void setIdelevee(Long ideleve) {
		this.idelevee = ideleve;
	}

	public Long getIdmatiere() {
		return idmatiere;
	}

	public void setIdmatiere(Long idmatiere) {
		this.idmatiere = idmatiere;
	}

}