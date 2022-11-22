package ticomo.app.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ticomo.app.model.Pedido;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String> {

	Optional<Pedido> findById(long id);

	List <Pedido> findByEstado(String estado);

    Optional <Pedido> findByFecha(Date fecha);

}