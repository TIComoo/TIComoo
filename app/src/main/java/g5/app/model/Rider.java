package g5.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Rider")
public class Rider extends Usuario {
	/*
	 * 
	 * Los riders deben tener nombre, apellidos, NIF, tipo de vehículo (a nuestra
	 * elección elegir que metemos) y matricula( puede ser nulo, meter validación
	 * por si el vehículo tiene matricula y en el caso será obligatorio) y carnet
	 * con los mismo condicionantes que matricula. Debe permitir a los riders
	 * consultar la lista de pedidos pendientes de servir y marcar los pedidos como
	 * entregados. Cada rider sólo podrá tener en proceso de entrega un número
	 * máximo de pedidos definido en el sistema.
	 * 
	 */

	// Esta clase hereda de usuario, y estos son sus nuevos atributos

	private String matricula;
	private String carnet;
	private String tipoVehiculo;

	public Rider(String nombre, String apellido, String nif, String email, String pwd, String tipoVehiculo,
			String matricula, String carnet) {

		super(nombre, apellido, nif, email, pwd);
		this.tipoVehiculo = tipoVehiculo;
		this.matricula = matricula;
		this.carnet = carnet;
	}

	// Constructor temporar para probar la aplicación

	public Rider(String email, String pwd) {
		super(email, pwd);
	}

	public Rider() {
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

}