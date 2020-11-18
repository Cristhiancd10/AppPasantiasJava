package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.AgendamientoDAO;
import astronet.ec.modelo.Agendamiento;

@Stateless
public class AgendamientoON {
	
	@Inject
	private AgendamientoDAO agdao;
	
	public void guardar(Agendamiento ag) {
		agdao.save(ag);
	}


	
	
	
}
