package astronet.servicios;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Instalacion;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Servicio;
import astronet.ec.on.AgendamientoON;
import astronet.ec.on.ClienteON;
import astronet.ec.on.EmpleadoON;
import astronet.ec.on.InstalacionON;
import astronet.ec.on.RegistroON;
import astronet.ec.on.ServicioON;
import astronet.modelotmp.Empleadotmp;


@Path("/astronet")
public class Servicios {
	
	@Inject
	private EmpleadoON empon;
	
	@Inject
	private InstalacionON inson;
	
	@Inject
	private AgendamientoON agon;
	
	@Inject
	private RegistroON regon;
	
	@Inject
	private ServicioON seron;
	
	@Inject
	private ClienteON clion;
	
	@GET
	@Path("/actualizarvisita")
	@Produces("application/json")
	public Response actualizar(@QueryParam("id") int id) {
		System.out.println("Actualizar.......");
		Response.ResponseBuilder builder = null;
		builder = Response.status(Response.Status.OK).entity("Actulizado");
		try {
			regon.actualizar(id);
		} catch (Exception e) {
			// TODO: handle exception
			builder = Response.status(Response.Status.BAD_REQUEST).entity("Error");
			
		}
		return builder.build();
	}
	
	/**
	 * Metodo del login
	 * @param un
	 * @param pass
	 * @return
	 */
	@POST
	@Path("/login")
	@Produces("application/json")
	public Empleadotmp login(Empleadotmp empleado) {
		Empleado use = new Empleado();
		Empleadotmp u = new Empleadotmp();
		try {
			use = empon.login(empleado.getEmail(), empleado.getPassword());
			u.setId(use.getId());
			System.out.println("fun ");
			u.setEmail(use.getEmail());
			u.setPassword(use.getPassword());
			u.setNombre(use.getNombre());
			u.setDepartamento(use.getDepartamento());
			u.setCelular(use.getCelular());
			
		} catch (Exception e) {
			u.setEmail(e.getMessage());
		}
		return u;
	}
	
	/**
	 * Metodo para ver el listado de todas las instalaciones
	 * @return
	 */
	@GET
	@Path("listInst")
	@Produces("application/json")
	
	public List<Instalacion> listarInstalacion(){
		return inson.getListadoInstalacion();
	}
	
	/**
	 *Metodo para listar todas las visitas tecnicas 
	 * @return
	 */
	@GET
	@Path("listRgVT")
	@Produces("application/json")
	public List<Registro> listarRgVT(){
		return regon.listadoRegistrosVT();
	}
	
	@GET
	@Path("/buscarIdVis")
	@Produces("application/json")
	public Registro getBuscarVis(@QueryParam("id") int id){
			return regon.getListadoClienteId(id);
		}
	
	@GET
	@Path("/buscarInsId")
	@Produces("application/json")
	public Instalacion getBuscarInsId(@QueryParam("id") int id){
			return inson.getListadoInstalacionId(id);
		}
	
	
	@PUT
	@Path("/actualizar")
	@Produces("application/json")
	@Consumes("application/json")
	public  Response update(Cliente cliente) {
			
			Response.ResponseBuilder builder = null;
			Map<String, String> data = new HashMap<>();
			Servicio ser=new Servicio();
			
			try {
				
				ser.setId(cliente.getServicio().get(0).getId());
				ser.setNumeroContrato(cliente.getServicio().get(0).getNumeroContrato());
				ser.setFechaContrato(cliente.getServicio().get(0).getFechaContrato());
				ser.setPlan(cliente.getServicio().get(0).getPlan());
				ser.setIp(cliente.getServicio().get(0).getIp());
				ser.setPassword(cliente.getServicio().get(0).getPassword());
				ser.setObservaciones(cliente.getServicio().get(0).getObservaciones());
				
				
				ser.setId(ser.getId());
//				ser.setNumeroContrato(ser.getNumeroContrato());
//				ser.setFechaContrato(ser.getFechaContrato());
//				ser.setPlan(ser.getPlan());
//				ser.setIp(ser.getIp());
//				ser.setPassword(ser.getPassword());
//				ser.setObservaciones(ser.getObservaciones());
				cliente.getServicio().get(0).setId(ser.getId());
				
					seron.actualizar(ser);
					clion.actualizar(cliente);
				
				
				
				System.out.println(cliente.getNombre());
				data.put("Mensaje: ", "Dato actualizado");
				builder = Response.status(Response.Status.OK).entity(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				data.put("Mensaje: ", e.getMessage());
				builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
			}
			
			return builder.build();
			
			
		}
	
	
	@POST 
	@Path("/create")
	@Produces("application/json")
	@Consumes("application/json")
	public  Response insertPersona(Cliente docente) {
			System.out.println(docente.toString()+ "AQUI LLEGO lgo ");
			Response.ResponseBuilder builder = null;
			Map<String, String> data = new HashMap<>();
			
			
			
			try {
				
				Calendar fecha = new GregorianCalendar();
				int anio = fecha.get(Calendar.YEAR);
		        int mes = fecha.get(Calendar.MONTH);
		        int dia = fecha.get(Calendar.DAY_OF_MONTH);
		        String fechaA =dia + "/" + (mes+1) + "/" + anio;
		     
		       System.out.println("id "+docente.getId());        
				docente.getServicio().get(0).setFechaContrato(fechaA);
								
					clion.guardarCliente(docente);
					data.put("codigo", "100");
					data.put("Mensaje: ", "Cliente ingresado");
					builder = Response.status(Response.Status.OK).entity(data);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				data.put("codigo", "50");
				data.put("Mensaje: ", e.getMessage());
				builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
			}
			
			return builder.build();
			
			
		}
	
//
//
//
//	
//	@POST
//	@Path("actCli")
//	@Produces("application/json")
//	public Response acualizarCliente(Cliente cli) {
//		Response.ResponseBuilder builder = null;
//		Map<String, String> data = new HashMap<>();
//		try {
//			clion.guardar(cli);
//			data.put("codigo","Ingresado"+cli.getId());
//			data.put("Mensaje", "Dato Actualizado Correctamente");
//			builder = Response.status(Response.Status.OK).entity(data);
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			data.put("codigo", "404");
//			data.put("message", "Error" + e.getMessage());
//			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
//		}
//	
//		return builder.build();
//	
//}
}
