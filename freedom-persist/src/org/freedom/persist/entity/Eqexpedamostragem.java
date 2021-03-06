package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Eqexpedamostragem generated by hbm2java
 */
@Entity
@Table(name = "EQEXPEDAMOSTRAGEM", uniqueConstraints = @UniqueConstraint(columnNames = "SEQAMOSTRAGEM"))
public class Eqexpedamostragem implements java.io.Serializable {

	private EqexpedamostragemId id;
	private Eqitexpedicao eqitexpedicao;
	private BigDecimal pesoamost;
	private Date dataamost;
	private Date horaamost;
	private int seqamostragem;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;

	public Eqexpedamostragem() {
	}

	public Eqexpedamostragem(EqexpedamostragemId id,
			Eqitexpedicao eqitexpedicao, BigDecimal pesoamost, Date dataamost,
			Date horaamost, int seqamostragem, Date dtins, Date hins,
			String idusuins) {
		this.id = id;
		this.eqitexpedicao = eqitexpedicao;
		this.pesoamost = pesoamost;
		this.dataamost = dataamost;
		this.horaamost = horaamost;
		this.seqamostragem = seqamostragem;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Eqexpedamostragem(EqexpedamostragemId id,
			Eqitexpedicao eqitexpedicao, BigDecimal pesoamost, Date dataamost,
			Date horaamost, int seqamostragem, Date dtins, Date hins,
			String idusuins, Date dtalt, Date halt, String idusualt) {
		this.id = id;
		this.eqitexpedicao = eqitexpedicao;
		this.pesoamost = pesoamost;
		this.dataamost = dataamost;
		this.horaamost = horaamost;
		this.seqamostragem = seqamostragem;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "ticket", column = @Column(name = "TICKET", nullable = false)),
			@AttributeOverride(name = "coditexped", column = @Column(name = "CODITEXPED", nullable = false)),
			@AttributeOverride(name = "codamostragem", column = @Column(name = "CODAMOSTRAGEM", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public EqexpedamostragemId getId() {
		return this.id;
	}

	public void setId(EqexpedamostragemId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "TICKET", referencedColumnName = "TICKET", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODITEXPED", referencedColumnName = "CODITEXPED", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODFILIAL", referencedColumnName = "CODFILIAL", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP", nullable = false, insertable = false, updatable = false) })
	public Eqitexpedicao getEqitexpedicao() {
		return this.eqitexpedicao;
	}

	public void setEqitexpedicao(Eqitexpedicao eqitexpedicao) {
		this.eqitexpedicao = eqitexpedicao;
	}

	@Column(name = "PESOAMOST", nullable = false, precision = 15, scale = 5)
	public BigDecimal getPesoamost() {
		return this.pesoamost;
	}

	public void setPesoamost(BigDecimal pesoamost) {
		this.pesoamost = pesoamost;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATAAMOST", nullable = false, length = 10)
	public Date getDataamost() {
		return this.dataamost;
	}

	public void setDataamost(Date dataamost) {
		this.dataamost = dataamost;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HORAAMOST", nullable = false, length = 8)
	public Date getHoraamost() {
		return this.horaamost;
	}

	public void setHoraamost(Date horaamost) {
		this.horaamost = horaamost;
	}

	@Column(name = "SEQAMOSTRAGEM", unique = true, nullable = false)
	public int getSeqamostragem() {
		return this.seqamostragem;
	}

	public void setSeqamostragem(int seqamostragem) {
		this.seqamostragem = seqamostragem;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTINS", nullable = false, length = 10)
	public Date getDtins() {
		return this.dtins;
	}

	public void setDtins(Date dtins) {
		this.dtins = dtins;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HINS", nullable = false, length = 8)
	public Date getHins() {
		return this.hins;
	}

	public void setHins(Date hins) {
		this.hins = hins;
	}

	@Column(name = "IDUSUINS", nullable = false, length = 8)
	public String getIdusuins() {
		return this.idusuins;
	}

	public void setIdusuins(String idusuins) {
		this.idusuins = idusuins;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTALT", length = 10)
	public Date getDtalt() {
		return this.dtalt;
	}

	public void setDtalt(Date dtalt) {
		this.dtalt = dtalt;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HALT", length = 8)
	public Date getHalt() {
		return this.halt;
	}

	public void setHalt(Date halt) {
		this.halt = halt;
	}

	@Column(name = "IDUSUALT", length = 8)
	public String getIdusualt() {
		return this.idusualt;
	}

	public void setIdusualt(String idusualt) {
		this.idusualt = idusualt;
	}

}
