package ticomo.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticomo.app.SequenceGeneratorServicePedido;
import ticomo.app.dao.PedidoRepository;
import ticomo.app.exception.CustomException;
import ticomo.app.model.Pedido;
import ticomo.app.model.Plato;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PedidoRepository clienteRepository;

	public void crearPedido(Pedido pedido) throws CustomException {

		pedido.setId(SequenceGeneratorServicePedido.generateSequence(Pedido.SEQUENCE_NAME));
		pedidoRepository.save(pedido);

	}

	public void eliminarPedido(Long id) throws CustomException {

		Pedido pedido = this.buscarPedido(id);
		pedidoRepository.delete(pedido);

	}

	public void actualizarPedido(Pedido pedido_O) throws CustomException {

	Pedido pedido_D = buscarPedido(pedido_O.getId());
	cambio(pedido_O, pedido_D);

	this.pedidoRepository.save(pedido_D);

	}

	protected void cambio(Pedido origen, Pedido destino) {

	destino.setPlatos(origen.getPlatos());
	destino.setPrecio(origen.getPrecio());
	destino.setFecha(origen.getFecha());
	destino.setEstado(origen.getEstado());

	}

	public List<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}

	public List<Pedido> getAllPedidosEmail(String email) {
		List<Pedido> pedidos=pedidoRepository.findAll();
		List<Pedido> aux=new ArrayList<Pedido>();

		for(int i=0; i<pedidos.size();i++){
			if(pedidos.get(i).getCliente()!=null){
				if(pedidos.get(i).getCliente().equalsIgnoreCase(email)){
					aux.add(pedidos.get(i));
				}
			}
			
		}
		return aux;
	}


	public Pedido buscarPedido(long id) throws CustomException {
		return pedidoRepository.findById(id).orElseThrow(() -> new CustomException("El Id del pedido no existe."));
	}
	

	public List<Pedido> getAllpedidosDisponibles() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<Pedido> pedidos_aux = new ArrayList<Pedido>();

		// paso el arrayList de platos a string
		for (Pedido pedido : pedidos) {
			ArrayList<Plato> platos = pedido.getPlatos();
			String s = pedido.getStringPlatos(platos);
			String nombreRestaurante = pedido.getRestaurante(platos);
			Pedido ped = new Pedido(pedido.getId(), platos, pedido.getPrecio(), pedido.getFecha(), pedido.getEstado(), s, pedido.getDireccion(), nombreRestaurante );
			pedidos_aux.add(ped);

		}


		return pedidos_aux;
	}
}
