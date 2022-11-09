package ticomo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticomo.app.SequenceGeneratorServicePedido;
import ticomo.app.dao.PedidoRepository;
import ticomo.app.exception.CustomException;
import ticomo.app.model.Pedido;

@Service
public class PedidoService {
    
    @Autowired
	private PedidoRepository pedidoRepository;


    public void crearPedido(Pedido pedido) throws CustomException {

		
			pedido.setId(SequenceGeneratorServicePedido.generateSequence(Pedido.SEQUENCE_NAME));
			pedidoRepository.save(pedido);
		

	}
    public void eliminarPedido(int id) throws CustomException {

		Pedido pedido = this.buscarPedido(id);
		pedidoRepository.delete(pedido);

	}

    //Tengo dudas en actualizar, preguntar en la daily

    // public void actualizarPedido(Pedido pedido_O) throws CustomException {

		
	// 		Pedido pedido_D = buscarPedido(pedido_O.getId());
	// 		cambio(pedido_O, pedido_D);

	// 		this.pedidoRepository.save(pedido_D);

	// }

    // protected void cambio(Pedido origen, Pedido destino) {
        
	// 	destino.setPlatos(origen.getPlatos());
	// 	destino.setPrecio(origen.getPrecio());
	// 	destino.setFecha(origen.getFecha());
	// 	destino.setEstado(origen.getEstado());

	// }

    public Iterable<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}

    public Pedido buscarPedido(long id) throws CustomException {
		return pedidoRepository.findById(id).orElseThrow(() -> new CustomException("El Id del pedido no existe."));
	}
}
