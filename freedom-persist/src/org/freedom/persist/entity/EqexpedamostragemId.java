package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EqexpedamostragemId generated by hbm2java
 */
@Embeddable
public class EqexpedamostragemId implements java.io.Serializable {

	private int ticket;
	private int coditexped;
	private int codamostragem;
	private short codfilial;
	private int codemp;

	public EqexpedamostragemId() {
	}

	public EqexpedamostragemId(int ticket, int coditexped, int codamostragem,
			short codfilial, int codemp) {
		this.ticket = ticket;
		this.coditexped = coditexped;
		this.codamostragem = codamostragem;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "TICKET", nullable = false)
	public int getTicket() {
		return this.ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	@Column(name = "CODITEXPED", nullable = false)
	public int getCoditexped() {
		return this.coditexped;
	}

	public void setCoditexped(int coditexped) {
		this.coditexped = coditexped;
	}

	@Column(name = "CODAMOSTRAGEM", nullable = false)
	public int getCodamostragem() {
		return this.codamostragem;
	}

	public void setCodamostragem(int codamostragem) {
		this.codamostragem = codamostragem;
	}

	@Column(name = "CODFILIAL", nullable = false)
	public short getCodfilial() {
		return this.codfilial;
	}

	public void setCodfilial(short codfilial) {
		this.codfilial = codfilial;
	}

	@Column(name = "CODEMP", nullable = false)
	public int getCodemp() {
		return this.codemp;
	}

	public void setCodemp(int codemp) {
		this.codemp = codemp;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EqexpedamostragemId))
			return false;
		EqexpedamostragemId castOther = (EqexpedamostragemId) other;

		return (this.getTicket() == castOther.getTicket())
				&& (this.getCoditexped() == castOther.getCoditexped())
				&& (this.getCodamostragem() == castOther.getCodamostragem())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getTicket();
		result = 37 * result + this.getCoditexped();
		result = 37 * result + this.getCodamostragem();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
