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
 * The persistent class for the OBJEKT database table.
 * 
 */
@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Objekt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="OBJEKT_ID")
	private Long objektId;

	private String avaja;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date avatud;

	private String kommentaar;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date muudetud;

	private String muutja;

	private String nimetus;

	@Column(name="OBJEKT_LIIK_ID")
	private int objektLiikId;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to ObjektIntsidendi
	@OneToMany(mappedBy="objekt")
	private Set<ObjektIntsidendi> objektIntsidendis;

	//bi-directional many-to-one association to Piiririkkuja
	@OneToMany(mappedBy="objekt")
	private Set<Piiririkkuja> piiririkkujas;

    public Objekt() {
    }

	public Long getObjektId() {
		return this.objektId;
	}

	public void setObjektId(Long objektId) {
		this.objektId = objektId;
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

	public int getObjektLiikId() {
		return this.objektLiikId;
	}

	public void setObjektLiikId(int objektLiikId) {
		this.objektLiikId = objektLiikId;
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

	public Set<ObjektIntsidendi> getObjektIntsidendis() {
		return this.objektIntsidendis;
	}

	public void setObjektIntsidendis(Set<ObjektIntsidendi> objektIntsidendis) {
		this.objektIntsidendis = objektIntsidendis;
	}
	
	public Set<Piiririkkuja> getPiiririkkujas() {
		return this.piiririkkujas;
	}

	public void setPiiririkkujas(Set<Piiririkkuja> piiririkkujas) {
		this.piiririkkujas = piiririkkujas;
	}
	
}