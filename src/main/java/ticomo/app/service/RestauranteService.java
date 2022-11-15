package ticomo.app.service;

import java.util.List;

import ticomo.app.model.Restaurante;

public interface RestauranteService {

	public List<Restaurante> getAllRestaurantes();

	public Restaurante createRestaurante(Restaurante restaurante) throws Exception;

	public Restaurante editarRestaurante(Restaurante restaurante) throws Exception;

	public void eliminarRestaurante(String nombre) throws Exception;

}

