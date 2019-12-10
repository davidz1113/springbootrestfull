package com.restfull.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.restfull.converter.NotaConverter;
import com.restfull.model.Nota;
import com.restfull.model.NotaEntity;
import com.restfull.repository.NotaRepository;

@Service("notaservice")
public class NotaService {

	@Autowired
	@Qualifier("notarepository")
	private NotaRepository repository;

	@Autowired
	@Qualifier("notaconverter")
	private NotaConverter convertidor;
	
	private static final Log logger = LogFactory.getLog(NotaService.class);

	public boolean crearNota(NotaEntity nota) {
		logger.info("Creando Nota");
		try {
			repository.save(nota);
			logger.info("Nota creada");
			return true;
		} catch (Exception e) {
			logger.error("Nota NO creada");
			// TODO: handle exception
			return false;
		}

	}

	public boolean actualizarNota(NotaEntity nota) {
		try {
			repository.save(nota);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public boolean borrarNota(String nombre, long id) {
		try {
			NotaEntity nota = repository.findByNombreAndId(nombre, id);
			repository.delete(nota);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public List<Nota> obtenerTodasNotas() {
		return convertidor.convertirLista(repository.findAll());
	}

	public Nota obtenerTodasNotasPorNombreTitulo(String nombre, String titulo) {
		return new Nota(repository.findByNombreAndTitulo(nombre, titulo));
	}

	public Nota obtenerTodasNotasPorNombreId(String nombre, long id) {
		return new Nota(repository.findByNombreAndId(nombre, id));
	}

	public List<Nota> obtenerTitulo(String titulo) {
		return convertidor.convertirLista(repository.findByTitulo(titulo));
	}

	
	public List<Nota> obtenerPorPaginacion(Pageable pageable){
			return convertidor.convertirLista(repository.findAll(pageable).getContent());
	}
}
