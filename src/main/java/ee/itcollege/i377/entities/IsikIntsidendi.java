package ee.itcollege.i377.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the ISIK_INTSIDENDIS database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@Table(name = "ISIK_INTSIDENDIS")
public class IsikIntsidendi extends HistoryHandlerEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ISIK_INTSIDENDIS_ID")
	private Long isikIntsidendisId;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "M-")
	private Date alates;

	private String kirjeldus;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "M-")
	private Date kuni;

	// bi-directional many-to-one association to Intsident
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INTSIDENT_ID")
	private Intsident intsident;

	// bi-directional many-to-one association to Piiririkkuja
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PIIRIRIKKUJA_ID")
	private Piiririkkuja piiririkkuja;

	public IsikIntsidendi() {
	}

	public Long getIsikIntsidendisId() {
		return this.isikIntsidendisId;
	}

	public void setIsikIntsidendisId(Long isikIntsidendisId) {
		this.isikIntsidendisId = isikIntsidendisId;
	}

	public Date getAlates() {
		return this.alates;
	}

	public void setAlates(Date alates) {
		this.alates = alates;
	}

	public String getKirjeldus() {
		return this.kirjeldus;
	}

	public void setKirjeldus(String kirjeldus) {
		this.kirjeldus = kirjeldus;
	}

	public Date getKuni() {
		return this.kuni;
	}

	public void setKuni(Date kuni) {
		this.kuni = kuni;
	}

	public Intsident getIntsident() {
		return this.intsident;
	}

	public void setIntsident(Intsident intsident) {
		this.intsident = intsident;
	}

	public Piiririkkuja getPiiririkkuja() {
		return this.piiririkkuja;
	}

	public void setPiiririkkuja(Piiririkkuja piiririkkuja) {
		this.piiririkkuja = piiririkkuja;
	}


	

	

	

}