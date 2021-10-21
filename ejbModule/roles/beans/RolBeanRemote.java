package roles.beans;

import java.util.List;

import javax.ejb.Remote;

import model.Roles.Rol;

@Remote
public interface RolBeanRemote {
	public void add(Rol r);
	public void modify(Rol r);
	public void remove(Rol r);
	
	public List<Rol> getAll();
	public Rol get(long id);
	
	public Rol find(String nombre);
}
