package ee.itcollege.i377.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * The persistent class for the PIIRILOIK database table.
 * 
 */
@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Piiriloik extends HistoryHandlerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PIIRILOIK_ID")
	private Long piiriloikId;

	@Column(name = "GPS_KOORDINAADID")
	private String gpsKoordinaadid;

	private String kood;

	private String nimetus;

	// bi-directional many-to-one association to Intsident
	@OneToMany(mappedBy = "piiriloik")
	private Set<Intsident> intsidents;

	// bi-directional many-to-one association to VahtkonndPiiriloigul
	@OneToMany(mappedBy = "piiriloik")
	private Set<VahtkonndPiiriloigul> vahtkonndPiiriloiguls;

	public Piiriloik() {
	}

	public Long getPiiriloikId() {
		return this.piiriloikId;
	}

	public void setPiiriloikId(Long piiriloikId) {
		this.piiriloikId = piiriloikId;
	}

	public String getGpsKoordinaadid() {
		return this.gpsKoordinaadid;
	}

	public void setGpsKoordinaadid(String gpsKoordinaadid) {
		this.gpsKoordinaadid = gpsKoordinaadid;
	}

	public String getKood() {
		return this.kood;
	}

	public void setKood(String kood) {
		this.kood = kood;
	}

	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}

	public Set<Intsident> getIntsidents() {
		return this.intsidents;
	}

	public void setIntsidents(Set<Intsident> intsidents) {
		this.intsidents = intsidents;
	}

	public Set<VahtkonndPiiriloigul> getVahtkonndPiiriloiguls() {
		return this.vahtkonndPiiriloiguls;
	}

	public void setVahtkonndPiiriloiguls(
			Set<VahtkonndPiiriloigul> vahtkonndPiiriloiguls) {
		this.vahtkonndPiiriloiguls = vahtkonndPiiriloiguls;
	}

}