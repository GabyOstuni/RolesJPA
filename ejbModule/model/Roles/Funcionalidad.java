package model.Roles;

import java.io.Serializable;


import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FUNCIONALIDADES database table.
 * 
 */
@Entity
@Table(name="FUNCIONALIDADES")
@NamedQuery(name="Funcionalidad.findAll", query="SELECT f FROM Funcionalidad f")
public class Funcionalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FUNCIONALIDADES_IDFUNCIONALIDAD_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FUNCIONALIDADES_IDFUNCIONALIDAD_GENERATOR")
	@Column(name="ID_FUNCIONALIDAD")
	private long idFuncionalidad;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="funcionalidades")
	private List<Rol> roles;



	public long getIdFuncionalidad() {
		return this.idFuncionalidad;
	}

	public void setIdFuncionalidad(long idFuncionalidad) {
		this.idFuncionalidad = idFuncionalidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Rol> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

}