package astronet.ec.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Servicio;

@Stateless
public class ClienteDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(Cliente cli) {
		if (this.read(cli.getId())!=null) {
			this.update(cli);
		}else 
			this.create(cli);
		
	}
	
	public void create(Cliente cli) {
		em.persist(cli);
		
	}
	
	public Cliente read(int id) {
		return em.find(Cliente.class, id);
	}
	
	public Cliente read3(int id) {
		String jpql = "SELECT cli FROM Cliente cli   WHERE cli.id = :a";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("a", id);
		Cliente cli = (Cliente) q.getSingleResult();
				
		return cli;

	}
	
	public void update(Cliente cli) {
		em.merge(cli);
		
	}
	
	public void delete(int id) {
		Cliente cli = read(id);
		em.remove(cli);
	}
	
	public List<Cliente> getCliente() {
		String jpql = "SELECT cliente FROM Cliente cliente ";
		Query q = em.createQuery(jpql, Cliente.class);
		List<Cliente> clientes = q.getResultList();
		for (Cliente cliente : clientes) {
			cliente.getAntena().getId();
			cliente.getServicio().get(0).getNumeroContrato();
			cliente.getServicio().size();

		}
		return clientes;
	}

	
	public Cliente buscarCedula(String cedula) {
		String jpql = "SELECT cli FROM Cliente cli WHERE cli.cedula = :cedula";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("cedula", cedula);
		Cliente clien = (Cliente) q.getSingleResult();
		clien.getCedula();
		clien.getNombre();
		System.out.println(clien.getCedula());
		System.out.println(clien.getNombre());
		
		for (int i = 0; i < clien.getServicio().size(); i++) {
			System.out.println("Celular " );
			System.out.println("Convencional " );
			clien.getServicio().get(i).getIp();
			clien.getServicio().get(i).getPassword();
			clien.getServicio().get(i).getPlan();
			clien.getAntena().getId();
		}

		return clien;
	}
	
	public Cliente buscarNombre(String nombre) {
		String jpql = "SELECT cli FROM Cliente cli WHERE cli.nombre = :nombre";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("nombre", nombre);
		Cliente clien = (Cliente) q.getSingleResult();
		clien.getCedula();
		clien.getNombre();
		System.out.println(clien.getCedula());
		System.out.println(clien.getNombre());
		
		for (int i = 0; i < clien.getServicio().size(); i++) {
			System.out.println("Celular " );
			System.out.println("Convencional " );
			clien.getServicio().get(i).getIp();
			clien.getServicio().get(i).getPassword();
			clien.getServicio().get(i).getPlan();
			clien.getAntena().getId();
		}

		return clien;
	}


}
