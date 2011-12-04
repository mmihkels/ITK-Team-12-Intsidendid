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
public class Vahtkond extends HistoryHandlerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VAHTKOND_ID")
	private Long vahtkondId;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date alates;

	private String kood;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date kuni;

	private String nimetus;

	@Column(name="PIIRIPUNKT_ID")
	private int piiripunktId;

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