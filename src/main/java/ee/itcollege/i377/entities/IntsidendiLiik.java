package ee.itcollege.i377.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * The persistent class for the INTSIDENDI_LIIK database table.
 * 
 */
@Entity
@RooJavaBean
@RooToString
@RooEntity
@Table(name = "INTSIDENDI_LIIK")
public class IntsidendiLiik extends HistoryHandlerEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INTSIDENDI_LIIK_ID")
	private Long intsidendiLiikId;

	private String kood;

	private String nimetus;

	// bi-directional many-to-one association to Intsident
	@OneToMany(mappedBy = "intsidendiLiik")
	private Set<Intsident> intsidents;

	public IntsidendiLiik() {
	}

	public Long getIntsidendiLiikId() {
		return this.intsidendiLiikId;
	}

	public void setIntsidendiLiikId(Long intsidendiLiikId) {
		this.intsidendiLiikId = intsidendiLiikId;
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

}