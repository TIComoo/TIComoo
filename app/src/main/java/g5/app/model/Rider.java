package g5.app.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Rider")
public class Rider extends Usuario {
    /*
     * 
     * Los riders deben tener nombre, apellidos, NIF, tipo de vehículo
     * (a nuestra elección elegir que metemos) y matricula( puede ser nulo,
     * meter validación por si el vehículo tiene matricula
     * y en el caso será obligatorio) y carnet con los mismo condicionantes que
     * matricula.
     * Debe permitir a los riders consultar la lista de pedidos pendientes de servir
     * y marcar los
     * pedidos como entregados. Cada rider sólo podrá tener en proceso de entrega un
     * número máximo de pedidos definido en el sistema.
     * 
     */

    // Esta clase hereda de usuario, y estos son sus nuevos atributos
    
    private String nif; // faltaba este atributo, que antes estaba en el padre, pero ahora no, así que hay que indicarlo aquí
    private String matricula;
    private String carnet;
    private String tipoVehiculo; // he cambiado el nombre de tipo_vehiculo a tipoVehiculo por temas de calidad
    
    // he cambiado el orden de las entradas al constructor para que los atributos de usuario tengan el mismo orden en todas las clases
    public Rider(String email, String nombre, String apellido, String pwd, String confirmarPwd, String nif, String tipoVehiculo,
			String matricula, String carnet) {

		super(email, nombre, apellido, pwd, confirmarPwd); // he cambiado también el orden de esto
		this.nif = nif;
		this.tipoVehiculo = tipoVehiculo;
		this.matricula = matricula;
		this.carnet = carnet;
	}
    
    public Rider() {}
    
    // Getter y Setter de nif añadidos
    public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
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