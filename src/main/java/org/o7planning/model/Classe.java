package org.o7planning.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Classe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClasse;

	private int numSalle;

	//bi-directional many-to-one association to FaireCour
	@OneToMany(mappedBy="classe")
	private List<FaireCour> faireCours;

	public Classe() {
	}

	public Classe(int numSalle) {
		super();
		this.numSalle = numSalle;
	}

	public Long getIdClasse() {
		return this.idClasse;
	}

	public void setIdClasse(Long idClasse) {
		this.idClasse = idClasse;
	}

	public int getNumSalle() {
		return this.numSalle;
	}

	public void setNumSalle(int numSalle) {
		this.numSalle = numSalle;
	}

	public List<FaireCour> getFaireCours() {
		return this.faireCours;
	}

	public void setFaireCours(List<FaireCour> faireCours) {
		this.faireCours = faireCours;
	}

	public FaireCour addFaireCour(FaireCour faireCour) {
		getFaireCours().add(faireCour);
		faireCour.setClasse(this);

		return faireCour;
	}

	public FaireCour removeFaireCour(FaireCour faireCour) {
		getFaireCours().remove(faireCour);
		faireCour.setClasse(null);

		return faireCour;
	}

}