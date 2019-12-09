package com.restfull.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfull.model.NotaEntity;

@Repository("notarepository")
public interface NotaRepository extends JpaRepository<NotaEntity, Integer> {

	public abstract NotaEntity findByNombre(String nombre);

	public abstract List<NotaEntity> findByTitulo(String titulo);

	public abstract NotaEntity findByNombreAndTitulo(String nombre, String titulo);

	public abstract NotaEntity findByNombreAndId(String nombre, long id);
}
