package com.restfull.model;

public class Nota {

	private long id;

	private String nombre;

	private String titulo;

	private String contenido;

	public Nota() {

	}

	public Nota(NotaEntity notaRepo) {
		this.id = notaRepo.getId();
		this.nombre = notaRepo.getNombre();
		this.titulo = notaRepo.getTitulo();
		this.contenido = notaRepo.getContenido();
	}

	public Nota(long id, String nombre, String titulo, String contenido) {
		this.id = id;
		this.nombre = nombre;
		this.titulo = titulo;
		this.contenido = contenido;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

}
