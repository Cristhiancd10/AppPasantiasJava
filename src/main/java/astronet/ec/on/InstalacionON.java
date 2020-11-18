package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.InstalacionDAO;
import astronet.ec.modelo.Instalacion;

@Stateless
public class InstalacionON {
	
	@Inject
	private InstalacionDAO insdao;
	
	public void crearI(Instalacion ins) {
		insdao.create(ins);
	}
	
	public Instalacion getListadoInstalacionId(int id){
		return insdao.getBusquedaInstalacionId(id);
	}
	
public List<Instalacion> getListadoInstalacion() {
		
		return insdao.listarInstalaciones();
	}

}
