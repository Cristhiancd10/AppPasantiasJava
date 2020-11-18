package astronet.ec.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import astronet.ec.modelo.Instalacion;

@Stateless
public class InstalacionDAO {
	
	@Inject
	private EntityManager em;
	
	public void create(Instalacion ins) {
		em.persist(ins);
	}
	
	public Instalacion getBusquedaInstalacionId(int filBusqueda){
		String jpql="SELECT d FROM Instalacion d   "
				    +" WHERE d.id = :filtro ";
		Query q=em.createQuery(jpql, Instalacion.class);
		q.setParameter("filtro", filBusqueda);
			
		Instalacion instalaciones=(Instalacion) q.getSingleResult();

		System.out.println(instalaciones);
		return instalaciones;
	}
	
	public List<Instalacion> listarInstalaciones() {
		String jpql = "SELECT inst FROM Instalacion inst ";
		Query q = em.createQuery(jpql,Instalacion.class);
		List<Instalacion> instalaciones= q.getResultList();
		for (Instalacion instalacion : instalaciones) {
			instalacion.getTipoServicio();
			instalacion.getNombre();
			instalacion.getDireccion();
			instalacion.getTelefono();
			instalacion.getCoordenadas();
			instalacion.getObservaciones();
			instalacion.getEmpleado().getNombre();
		}
		
		return instalaciones;
	}

}
