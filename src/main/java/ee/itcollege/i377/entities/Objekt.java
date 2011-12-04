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
 * The persistent class for the OBJEKT database table.
 * 
 */
@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Objekt extends HistoryHandlerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OBJEKT_ID")
	private Long objektId;

	private String nimetus;

	@Column(name = "OBJEKT_LIIK_ID")
	private int objektLiikId;

	// bi-directional many-to-one association to ObjektIntsidendi
	@OneToMany(mappedBy = "objekt")
	private Set<ObjektIntsidendi> objektIntsidendis;

	// bi-directional many-to-one association to Piiririkkuja
	@OneToMany(mappedBy = "objekt")
	private Set<Piiririkkuja> piiririkkujas;

	public Objekt() {
	}

	public Long getObjektId() {
		return this.objektId;
	}

	public void setObjektId(Long objektId) {
		this.objektId = objektId;
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