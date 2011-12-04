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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * The persistent class for the VAHTKOND_INTSIDENDIS database table.
 * 
 */
@Entity
@RooJavaBean
@RooToString
@RooEntity
@Table(name = "VAHTKOND_INTSIDENDIS")
public class VahtkondIntsidendi extends HistoryHandlerEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VAHTKOND_INTSIDENDIS_ID")
	private Long vahtkondIntsidendisId;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "M-")
	private Date alates;

	private String kirjeldus;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "M-")
	private Date kuni;

	// bi-directional many-to-one association to PiirivalvurIntsidendi
	@OneToMany(mappedBy = "vahtkondIntsidendi")
	private Set<PiirivalvurIntsidendi> piirivalvurIntsidendis;

	// bi-directional many-to-one association to Intsident
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INTSIDENT_ID")
	private Intsident intsident;

	// bi-directional many-to-one association to Vahtkond
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VAHTKOND_ID")
	private Vahtkond vahtkond;

	public VahtkondIntsidendi() {
	}

	public Long getVahtkondIntsidendisId() {
		return this.vahtkondIntsidendisId;
	}

	public void setVahtkondIntsidendisId(Long vahtkondIntsidendisId) {
		this.vahtkondIntsidendisId = vahtkondIntsidendisId;
	}

	public Date getAlates() {
		return this.alates;
	}

	public void setAlates(Date alates) {
		this.alates = alates;
	}

	public Date getKuni() {
		return this.kuni;
	}

	public void setKuni(Date kuni) {
		this.kuni = kuni;
	}

	public Set<PiirivalvurIntsidendi> getPiirivalvurIntsidendis() {
		return this.piirivalvurIntsidendis;
	}

	public void setPiirivalvurIntsidendis(
			Set<PiirivalvurIntsidendi> piirivalvurIntsidendis) {
		this.piirivalvurIntsidendis = piirivalvurIntsidendis;
	}

	public Intsident getIntsident() {
		return this.intsident;
	}

	public void setIntsident(Intsident intsident) {
		this.intsident = intsident;
	}

	public Vahtkond getVahtkond() {
		return this.vahtkond;
	}

	public void setVahtkond(Vahtkond vahtkond) {
		this.vahtkond = vahtkond;
	}

}