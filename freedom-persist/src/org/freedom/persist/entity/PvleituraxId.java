package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PvleituraxId generated by hbm2java
 */
@Embeddable
public class PvleituraxId implements java.io.Serializable {

	private int codemp;
	private short codfilial;
	private int codcaixa;
	private Date dtlx;

	public PvleituraxId() {
	}

	public PvleituraxId(int codemp, short codfilial, int codcaixa, Date dtlx) {
		this.codemp = codemp;
		this.codfilial = codfilial;
		this.codcaixa = codcaixa;
		this.dtlx = dtlx;
	}

	@Column(name = "CODEMP", nullable = false)
	public int getCodemp() {
		return this.codemp;
	}

	public void setCodemp(int codemp) {
		this.codemp = codemp;
	}

	@Column(name = "CODFILIAL", nullable = false)
	public short getCodfilial() {
		return this.codfilial;
	}

	public void setCodfilial(short codfilial) {
		this.codfilial = codfilial;
	}

	@Column(name = "CODCAIXA", nullable = false)
	public int getCodcaixa() {
		return this.codcaixa;
	}

	public void setCodcaixa(int codcaixa) {
		this.codcaixa = codcaixa;
	}

	@Column(name = "DTLX", nullable = false, length = 10)
	public Date getDtlx() {
		return this.dtlx;
	}

	public void setDtlx(Date dtlx) {
		this.dtlx = dtlx;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PvleituraxId))
			return false;
		PvleituraxId castOther = (PvleituraxId) other;

		return (this.getCodemp() == castOther.getCodemp())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodcaixa() == castOther.getCodcaixa())
				&& ((this.getDtlx() == castOther.getDtlx()) || (this.getDtlx() != null
						&& castOther.getDtlx() != null && this.getDtlx()
						.equals(castOther.getDtlx())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodemp();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodcaixa();
		result = 37 * result
				+ (getDtlx() == null ? 0 : this.getDtlx().hashCode());
		return result;
	}

}
