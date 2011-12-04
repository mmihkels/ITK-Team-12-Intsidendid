// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.i377.entities;

import ee.itcollege.i377.entities.ObjektIntsidendi;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ObjektIntsidendi_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager ObjektIntsidendi.entityManager;
    
    @Version
    @Column(name = "version")
    private Integer ObjektIntsidendi.version;
    
    public Integer ObjektIntsidendi.getVersion() {
        return this.version;
    }
    
    public void ObjektIntsidendi.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void ObjektIntsidendi.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void ObjektIntsidendi.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ObjektIntsidendi attached = ObjektIntsidendi.findObjektIntsidendi(this.objektIntsidendisId);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void ObjektIntsidendi.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void ObjektIntsidendi.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public ObjektIntsidendi ObjektIntsidendi.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ObjektIntsidendi merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager ObjektIntsidendi.entityManager() {
        EntityManager em = new ObjektIntsidendi().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long ObjektIntsidendi.countObjektIntsidendis() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ObjektIntsidendi o", Long.class).getSingleResult();
    }
    
    public static List<ObjektIntsidendi> ObjektIntsidendi.findAllObjektIntsidendis() {
        return entityManager().createQuery("SELECT o FROM ObjektIntsidendi o", ObjektIntsidendi.class).getResultList();
    }
    
    public static ObjektIntsidendi ObjektIntsidendi.findObjektIntsidendi(Long objektIntsidendisId) {
        if (objektIntsidendisId == null) return null;
        return entityManager().find(ObjektIntsidendi.class, objektIntsidendisId);
    }
    
    public static List<ObjektIntsidendi> ObjektIntsidendi.findObjektIntsidendiEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ObjektIntsidendi o", ObjektIntsidendi.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
