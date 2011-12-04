package ee.itcollege.i377.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the VAHTKOND database table.
 * 
 */
@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Vahtkond implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VAHTKOND_ID")
	private Long vahtkondId;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date alates;

	private String avaja;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date avatud;

	private String kommentaar;

	private String kood;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date kuni;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date muudetud;

	private String muutja;

	private String nimetus;

	@Column(name="PIIRIPUNKT_ID")
	private int piiripunktId;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="F-")
	private Date suletud;

	private String sulgeja;

	@Column(name="VAEOSA_ID_ID")
	private int vaeosaIdId;

	//bi-directional many-to-one association to VahtkondIntsidendi
	@OneToMany(mappedBy="vahtkond")
	private Set<VahtkondIntsidendi> vahtkondIntsidendis;

	//bi-directional many-to-one association to VahtkonndPiiriloigul
	@OneToMany(mappedBy="vahtkond")
	private Set<VahtkonndPiiriloigul> vahtkonndPiiriloiguls;

    public Vahtkond() {
    }

	public Long getVahtkondId() {
		return this.vahtkondId;
	}

	public void setVahtkondId(Long vahtkondId) {
		this.vahtkondId = vahtkondId;
	}

	public Date getAlates() {
		return this.alates;
	}

	public void setAlates(Date alates) {
		this.alates = alates;
	}

	public String getAvaja() {
		return this.avaja;
	}

	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}

	public Date getAvatud() {
		return this.avatud;
	}

	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public String getKood() {
		return this.kood;
	}

	public void setKood(String kood) {
		this.kood = kood;
	}

	public Date getKuni() {
		return this.kuni;
	}

	public void setKuni(Date kuni) {
		this.kuni = kuni;
	}

	public Date getMuudetud() {
		return this.muudetud;
	}

	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}

	public String getMuutja() {
		return this.muutja;
	}

	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}

	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}

	public int getPiiripunktId() {
		return this.piiripunktId;
	}

	public void setPiiripunktId(int piiripunktId) {
		this.piiripunktId = piiripunktId;
	}

	public Date getSuletud() {
		return this.suletud;
	}

	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}

	public String getSulgeja() {
		return this.sulgeja;
	}

	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

	public int getVaeosaIdId() {
		return this.vaeosaIdId;
	}

	public void setVaeosaIdId(int vaeosaIdId) {
		this.vaeosaIdId = vaeosaIdId;
	}

	public Set<VahtkondIntsidendi> getVahtkondIntsidendis() {
		return this.vahtkondIntsidendis;
	}

	public void setVahtkondIntsidendis(Set<VahtkondIntsidendi> vahtkondIntsidendis) {
		this.vahtkondIntsidendis = vahtkondIntsidendis;
	}
	
	public Set<VahtkonndPiiriloigul> getVahtkonndPiiriloiguls() {
		return this.vahtkonndPiiriloiguls;
	}

	public void setVahtkonndPiiriloiguls(Set<VahtkonndPiiriloigul> vahtkonndPiiriloiguls) {
		this.vahtkonndPiiriloiguls = vahtkonndPiiriloiguls;
	}
	
}