package ee.itcollege.i377.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * The persistent class for the PIIRIRIKKUJA database table.
 * 
 */
@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Piiririkkuja extends HistoryHandlerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PIIRIRIKKUJA_ID")
	private Long piiririkkujaId;

	private String eesnimi;

	private String isikukood;

	@Column(name = "PEREK_NIMI")
	private String perekNimi;

	private String sugu;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "M-")
	private Date synniaeg;

	// bi-directional many-to-one association to IsikIntsidendi
	@OneToMany(mappedBy = "piiririkkuja")
	private Set<IsikIntsidendi> isikIntsidendis;

	// bi-directional many-to-one association to Objekt
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBJEKT_ID")
	private Objekt objekt;

	// bi-directional many-to-one association to Kodakondsus
	@OneToMany(mappedBy = "piiririkkuja")
	private Set<Kodakondsus> kodakondsuses;

	public Piiririkkuja() {
	}

	public Long getPiiririkkujaId() {
		return this.piiririkkujaId;
	}

	public void setPiiririkkujaId(Long piiririkkujaId) {
		this.piiririkkujaId = piiririkkujaId;
	}

	public String getEesnimi() {
		return this.eesnimi;
	}

	public void setEesnimi(String eesnimi) {
		this.eesnimi = eesnimi;
	}

	public String getIsikukood() {
		return this.isikukood;
	}

	public void setIsikukood(String isikukood) {
		this.isikukood = isikukood;
	}

	public String getPerekNimi() {
		return this.perekNimi;
	}

	public void setPerekNimi(String perekNimi) {
		this.perekNimi = perekNimi;
	}

	public String getSugu() {
		return this.sugu;
	}

	public void setSugu(String sugu) {
		this.sugu = sugu;
	}

	public Date getSynniaeg() {
		return this.synniaeg;
	}

	public void setSynniaeg(Date synniaeg) {
		this.synniaeg = synniaeg;
	}

	public Objekt getObjekt() {
		return this.objekt;
	}

	public void setObjekt(Objekt objekt) {
		this.objekt = objekt;
	}

	public Set<Kodakondsus> getKodakondsuses() {
		return this.kodakondsuses;
	}

	public void setKodakondsuses(Set<Kodakondsus> kodakondsuses) {
		this.kodakondsuses = kodakondsuses;
	}

	/**
	 * @return the isikIntsidendis
	 */
	public Set<IsikIntsidendi> getIsikIntsidendis() {
		return isikIntsidendis;
	}

	/**
	 * @param isikIntsidendis the isikIntsidendis to set
	 */
	public void setIsikIntsidendis(Set<IsikIntsidendi> isikIntsidendis) {
		this.isikIntsidendis = isikIntsidendis;
	}

}