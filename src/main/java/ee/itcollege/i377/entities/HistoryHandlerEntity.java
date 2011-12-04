package ee.itcollege.i377.entities;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;

@MappedSuperclass
public class HistoryHandlerEntity {
	
	private String avaja;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date avatud;
    
    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
    private Date muudetud;

	private String muutja;
	
	@Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date suletud;

	private String sulgeja;
	
	private String kommentaar;

	/**
	 * @return the avaja
	 */
	public String getAvaja() {
		return avaja;
	}

	/**
	 * @param avaja the avaja to set
	 */
	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}

	/**
	 * @return the avatud
	 */
	public Date getAvatud() {
		return avatud;
	}

	/**
	 * @param avatud the avatud to set
	 */
	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}

	/**
	 * @return the muudetud
	 */
	public Date getMuudetud() {
		return muudetud;
	}

	/**
	 * @param muudetud the muudetud to set
	 */
	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}

	/**
	 * @return the muutja
	 */
	public String getMuutja() {
		return muutja;
	}

	/**
	 * @param muutja the muutja to set
	 */
	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}

	/**
	 * @return the suletud
	 */
	public Date getSuletud() {
		return suletud;
	}

	/**
	 * @param suletud the suletud to set
	 */
	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}

	/**
	 * @return the sulgeja
	 */
	public String getSulgeja() {
		return sulgeja;
	}

	/**
	 * @param sulgeja the sulgeja to set
	 */
	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

	/**
	 * @return the kommentaar
	 */
	public String getKommentaar() {
		return kommentaar;
	}

	/**
	 * @param kommentaar the kommentaar to set
	 */
	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}
	
	@PrePersist
	public void setCreated() {
		String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
		Date now = new Date();
		setOpen(currentUser, now);
		setModified(currentUser, now);
		setTemporaryClosedDate();
	}
	
	@PreUpdate
	public void setUpdated() {
		String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
		Date now = new Date();
		setModified(currentUser, now);
	}
	
	@PreRemove
	public void preventRemoval() {
		throw new SecurityException("Removal of objects from DB is prohibited!");
	}
	
	private void setOpen(String user, Date date) {
		this.avaja = user;
		this.avatud = date;
	}
	
	private void setModified(String user, Date date) {
		this.muutja = user;
		this.muudetud = date;
	}
	
	private void setTemporaryClosedDate() {
		Date tempDate = new Date();
		
		this.suletud = tempDate;
	}
	
	public void close() {
		Date now = new Date();
		String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
		this.suletud = now;
		this.sulgeja = currentUser;
	}

}
