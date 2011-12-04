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
 * The persistent class for the RIIK database table.
 * 
 */
@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Riik extends HistoryHandlerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RIIK_ID")
	private Long riikId;

	@Column(name = "ANSI_KOOD")
	private String ansiKood;

	@Column(name = "ISO_KOOD")
	private String isoKood;

	// bi-directional many-to-one association to Kodakondsus
	@OneToMany(mappedBy = "riik")
	private Set<Kodakondsus> kodakondsuses;

	public Riik() {
	}

	public Long getRiikId() {
		return this.riikId;
	}

	public void setRiikId(Long riikId) {
		this.riikId = riikId;
	}

	public String getAnsiKood() {
		return this.ansiKood;
	}

	public void setAnsiKood(String ansiKood) {
		this.ansiKood = ansiKood;
	}

	public String getIsoKood() {
		return this.isoKood;
	}

	public void setIsoKood(String isoKood) {
		this.isoKood = isoKood;
	}

	public Set<Kodakondsus> getKodakondsuses() {
		return this.kodakondsuses;
	}

	public void setKodakondsuses(Set<Kodakondsus> kodakondsuses) {
		this.kodakondsuses = kodakondsuses;
	}

}