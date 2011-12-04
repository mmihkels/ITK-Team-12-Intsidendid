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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * The persistent class for the KODAKONDSUS database table.
 * 
 */
@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Kodakondsus extends HistoryHandlerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "KODAKONDSUS_ID")
	private Long kodakondsusId;

	@Temporal(TemporalType.DATE)
	 @DateTimeFormat(style="M-")
	private Date alates;

	private String isikukood;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "M-")
	private Date kuni;

	// bi-directional many-to-one association to Piiririkkuja
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PIIRIRIKKUJA_ID")
	private Piiririkkuja piiririkkuja;

	// bi-directional many-to-one association to Riik
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RIIK_ID")
	private Riik riik;

	public Kodakondsus() {
	}

	public Long getKodakondsusId() {
		return this.kodakondsusId;
	}

	public void setKodakondsusId(Long kodakondsusId) {
		this.kodakondsusId = kodakondsusId;
	}

	public Date getAlates() {
		return this.alates;
	}

	public void setAlates(Date alates) {
		this.alates = alates;
	}

	public String getIsikukood() {
		return this.isikukood;
	}

	public void setIsikukood(String isikukood) {
		this.isikukood = isikukood;
	}

	public Date getKuni() {
		return this.kuni;
	}

	public void setKuni(Date kuni) {
		this.kuni = kuni;
	}

	public Piiririkkuja getPiiririkkuja() {
		return this.piiririkkuja;
	}

	public void setPiiririkkuja(Piiririkkuja piiririkkuja) {
		this.piiririkkuja = piiririkkuja;
	}

	public Riik getRiik() {
		return this.riik;
	}

	public void setRiik(Riik riik) {
		this.riik = riik;
	}

}