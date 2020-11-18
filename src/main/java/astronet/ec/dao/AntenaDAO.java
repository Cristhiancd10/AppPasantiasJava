package astronet.ec.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import astronet.ec.modelo.Antena;
import astronet.ec.modelo.Empleado;

@Stateless
public class AntenaDAO {
	
	@Inject
	private EntityManager em;
	
	public void create(Antena ant) {
		em.persist(ant);
	}
	
	public Antena read(int codigo) {
		return em.find(Antena.class, codigo);
	}
	
	public void update(Antena ant) {
		em.merge(ant);
	}
	
	public List<Antena> modeloAntena(){
		String jpql="SELECT an FROM Antena an";
		Query q=em.createQuery(jpql,Antena.class);
		List<Antena> antena=q.getResultList();
		for (Antena antena2 : antena) {
			antena2.getId();
			antena2.getModelo();
		}
		
		return antena;
	}
	
	

}
