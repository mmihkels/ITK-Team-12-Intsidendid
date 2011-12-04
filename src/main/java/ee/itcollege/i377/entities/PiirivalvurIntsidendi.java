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
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the PIIRIVALVUR_INTSIDENDIS database table.
 * 
 */
@Entity
@RooJavaBean
@RooToString
@RooEntity
@Table(name="PIIRIVALVUR_INTSIDENDIS")
public class PiirivalvurIntsidendi extends HistoryHandlerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PIIRIVALVUR_INTSIDENDIS_ID")
	private Long piirivalvurIntsidendisId;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date alates;

	private String kirjeldus;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date kuni;


	//bi-directional many-to-one association to Intsident
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="INTSIDENT_ID")
	private Intsident intsident;

	//bi-directional many-to-one association to Piirivalvur
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PIIRIVALVUR_ID")
	private Piirivalvur piirivalvur;

	//bi-directional many-to-one association to VahtkondIntsidendi
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VAHTKOND_INTSIDENDIS_ID")
	private VahtkondIntsidendi vahtkondIntsidendi;

    public PiirivalvurIntsidendi() {
    }

	public Long getPiirivalvurIntsidendisId() {
		return this.piirivalvurIntsidendisId;
	}

	public void setPiirivalvurIntsidendisId(Long piirivalvurIntsidendisId) {
		this.piirivalvurIntsidendisId = piirivalvurIntsidendisId;
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
	
	public Piirivalvur getPiirivalvur() {
		return this.piirivalvur;
	}

	public void setPiirivalvur(Piirivalvur piirivalvur) {
		this.piirivalvur = piirivalvur;
	}
	
	public VahtkondIntsidendi getVahtkondIntsidendi() {
		return this.vahtkondIntsidendi;
	}

	public void setVahtkondIntsidendi(VahtkondIntsidendi vahtkondIntsidendi) {
		this.vahtkondIntsidendi = vahtkondIntsidendi;
	}
	
}