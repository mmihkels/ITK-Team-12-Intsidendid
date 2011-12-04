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
 * The persistent class for the PIIRIVALVUR database table.
 * 
 */
@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Piirivalvur extends HistoryHandlerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PIIRIVALVUR_ID")
	private Long piirivalvurId;

	private String eesnimed;

	private String isikukood;

	private String perekonnanimi;

	@Column(name = "SODURI_KOOD")
	private String soduriKood;

	private String sugu;

	// bi-directional many-to-one association to PiirivalvurIntsidendi
	@OneToMany(mappedBy = "piirivalvur")
	private Set<PiirivalvurIntsidendi> piirivalvurIntsidendis;

	public Piirivalvur() {
	}

	public Long getPiirivalvurId() {
		return this.piirivalvurId;
	}

	public void setPiirivalvurId(Long piirivalvurId) {
		this.piirivalvurId = piirivalvurId;
	}

	public String getEesnimed() {
		return this.eesnimed;
	}

	public void setEesnimed(String eesnimed) {
		this.eesnimed = eesnimed;
	}

	public String getIsikukood() {
		return this.isikukood;
	}

	public void setIsikukood(String isikukood) {
		this.isikukood = isikukood;
	}

	public String getPerekonnanimi() {
		return this.perekonnanimi;
	}

	public void setPerekonnanimi(String perekonnanimi) {
		this.perekonnanimi = perekonnanimi;
	}

	public String getSoduriKood() {
		return this.soduriKood;
	}

	public void setSoduriKood(String soduriKood) {
		this.soduriKood = soduriKood;
	}

	public String getSugu() {
		return this.sugu;
	}

	public void setSugu(String sugu) {
		this.sugu = sugu;
	}

	public Set<PiirivalvurIntsidendi> getPiirivalvurIntsidendis() {
		return this.piirivalvurIntsidendis;
	}

	public void setPiirivalvurIntsidendis(
			Set<PiirivalvurIntsidendi> piirivalvurIntsidendis) {
		this.piirivalvurIntsidendis = piirivalvurIntsidendis;
	}

}