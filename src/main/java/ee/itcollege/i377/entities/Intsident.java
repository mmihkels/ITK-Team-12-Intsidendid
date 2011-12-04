package ee.itcollege.i377.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the INTSIDENT database table.
 * 
 */
@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Intsident extends HistoryHandlerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INTSIDENT_ID")
	private Long intsidentId;

	@Column(name = "GPS_LATITUUD")
	private BigDecimal gpsLatituud;

	@Column(name = "GPS_LONGITUUD")
	private BigDecimal gpsLongituud;

	private String kirjeldus;

	private String kood;

	private String nimetus;

	@Temporal(TemporalType.DATE)
	@Column(name = "TOIMUMISE_ALGUS")
	@DateTimeFormat(style = "M-")
	private Date toimumiseAlgus;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "M-")
	@Column(name = "TOIMUMISE_LOPP")
	private Date toimumiseLopp;

	// bi-directional many-to-one association to IntsidendiLiik
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INTSIDENDI_LIIK_ID")
	private IntsidendiLiik intsidendiLiik;

	// bi-directional many-to-one association to Piiriloik
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PIIRILOIK_ID")
	private Piiriloik piiriloik;

	// bi-directional many-to-one association to IsikIntsidendi
	@OneToMany(mappedBy = "intsident")
	private Set<IsikIntsidendi> isikIntsidendis;

	// bi-directional many-to-one association to ObjektIntsidendi
	@OneToMany(mappedBy = "intsident")
	private Set<ObjektIntsidendi> objektIntsidendis;

	// bi-directional many-to-one association to PiirivalvurIntsidendi
	@OneToMany(mappedBy = "intsident")
	private Set<PiirivalvurIntsidendi> piirivalvurIntsidendis;

	// bi-directional many-to-one association to VahtkondIntsidendi
	@OneToMany(mappedBy = "intsident")
	private Set<VahtkondIntsidendi> vahtkondIntsidendis;

	public Intsident() {
	}

	public Long getIntsidentId() {
		return this.intsidentId;
	}

	public void setIntsidentId(Long intsidentId) {
		this.intsidentId = intsidentId;
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

	public BigDecimal getGpsLatituud() {
		return this.gpsLatituud;
	}

	public void setGpsLatituud(BigDecimal gpsLatituud) {
		this.gpsLatituud = gpsLatituud;
	}

	public BigDecimal getGpsLongituud() {
		return this.gpsLongituud;
	}

	public void setGpsLongituud(BigDecimal gpsLongituud) {
		this.gpsLongituud = gpsLongituud;
	}

	public String getKirjeldus() {
		return this.kirjeldus;
	}

	public void setKirjeldus(String kirjeldus) {
		this.kirjeldus = kirjeldus;
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

	public Date getToimumiseAlgus() {
		return this.toimumiseAlgus;
	}

	public void setToimumiseAlgus(Date toimumiseAlgus) {
		this.toimumiseAlgus = toimumiseAlgus;
	}

	public Date getToimumiseLopp() {
		return this.toimumiseLopp;
	}

	public void setToimumiseLopp(Date toimumiseLopp) {
		this.toimumiseLopp = toimumiseLopp;
	}

	public IntsidendiLiik getIntsidendiLiik() {
		return this.intsidendiLiik;
	}

	public void setIntsidendiLiik(IntsidendiLiik intsidendiLiik) {
		this.intsidendiLiik = intsidendiLiik;
	}

	public Piiriloik getPiiriloik() {
		return this.piiriloik;
	}

	public void setPiiriloik(Piiriloik piiriloik) {
		this.piiriloik = piiriloik;
	}

	public Set<ObjektIntsidendi> getObjektIntsidendis() {
		return this.objektIntsidendis;
	}

	public void setObjektIntsidendis(Set<ObjektIntsidendi> objektIntsidendis) {
		this.objektIntsidendis = objektIntsidendis;
	}

	public Set<PiirivalvurIntsidendi> getPiirivalvurIntsidendis() {
		return this.piirivalvurIntsidendis;
	}

	public void setPiirivalvurIntsidendis(
			Set<PiirivalvurIntsidendi> piirivalvurIntsidendis) {
		this.piirivalvurIntsidendis = piirivalvurIntsidendis;
	}

	public Set<VahtkondIntsidendi> getVahtkondIntsidendis() {
		return this.vahtkondIntsidendis;
	}

	public void setVahtkondIntsidendis(
			Set<VahtkondIntsidendi> vahtkondIntsidendis) {
		this.vahtkondIntsidendis = vahtkondIntsidendis;
	}

}