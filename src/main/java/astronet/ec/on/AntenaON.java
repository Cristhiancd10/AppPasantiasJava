package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.AntenaDAO;
import astronet.ec.modelo.Antena;
import astronet.ec.modelo.Empleado;

@Stateless
public class AntenaON {
	
	@Inject
	private AntenaDAO antdao;
	
	public List<Antena> getListadoAntena() {
		return antdao.modeloAntena();
	}
	
public Antena consultarAntena(int codigoAntena) throws Exception {
		
		
		Antena ant= antdao.read(codigoAntena);
		if(ant==null)
			throw new Exception("Antena no existe");
		
		return ant;
	}


}
