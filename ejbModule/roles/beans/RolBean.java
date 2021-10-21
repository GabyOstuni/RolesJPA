package roles.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Roles.Rol;


/**
 * Session Bean implementation class RolBean
 */
@Stateless
@LocalBean
public class RolBean implements RolBeanRemote {

	@PersistenceContext
	EntityManager em;

	public RolBean() {
	}

	@Override
	public void add(Rol r) {
		em.persist(r);
	}

	@Override
	public void modify(Rol r) {
		em.merge(r);
	}

	@Override
	public void remove(Rol r) {
		r = em.merge(r);
		em.remove(r);
	}

	@Override
	public List<Rol> getAll() {
		TypedQuery<Rol> res = em.createQuery("SELECT r FROM Rol r", Rol.class);
		return res.getResultList();
	}

	@Override
	public Rol get(long id) {
		return em.find(Rol.class, id);
	}

	@Override
	public Rol find(String nombre) {
		TypedQuery<Rol> res = em.createQuery("SELECT r FROM Rol r WHERE r.nombre= :nombre", Rol.class)
				.setParameter("nombre", nombre);
		return res.getSingleResult();
	}

}
