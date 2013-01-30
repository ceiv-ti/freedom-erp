package org.freedom.persist.entity;

// Generated 30/01/2013 08:30:43 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EqcliforId generated by hbm2java
 */
@Embeddable
public class EqcliforId implements java.io.Serializable {

	private int codcli;
	private int codemp;
	private short codfilial;
	private int codfor;
	private int codempfr;
	private short codfilialfr;

	public EqcliforId() {
	}

	public EqcliforId(int codcli, int codemp, short codfilial, int codfor,
			int codempfr, short codfilialfr) {
		this.codcli = codcli;
		this.codemp = codemp;
		this.codfilial = codfilial;
		this.codfor = codfor;
		this.codempfr = codempfr;
		this.codfilialfr = codfilialfr;
	}

	@Column(name = "CODCLI", nullable = false)
	public int getCodcli() {
		return this.codcli;
	}

	public void setCodcli(int codcli) {
		this.codcli = codcli;
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

	@Column(name = "CODFOR", nullable = false)
	public int getCodfor() {
		return this.codfor;
	}

	public void setCodfor(int codfor) {
		this.codfor = codfor;
	}

	@Column(name = "CODEMPFR", nullable = false)
	public int getCodempfr() {
		return this.codempfr;
	}

	public void setCodempfr(int codempfr) {
		this.codempfr = codempfr;
	}

	@Column(name = "CODFILIALFR", nullable = false)
	public short getCodfilialfr() {
		return this.codfilialfr;
	}

	public void setCodfilialfr(short codfilialfr) {
		this.codfilialfr = codfilialfr;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EqcliforId))
			return false;
		EqcliforId castOther = (EqcliforId) other;

		return (this.getCodcli() == castOther.getCodcli())
				&& (this.getCodemp() == castOther.getCodemp())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodfor() == castOther.getCodfor())
				&& (this.getCodempfr() == castOther.getCodempfr())
				&& (this.getCodfilialfr() == castOther.getCodfilialfr());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodcli();
		result = 37 * result + this.getCodemp();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodfor();
		result = 37 * result + this.getCodempfr();
		result = 37 * result + this.getCodfilialfr();
		return result;
	}

}