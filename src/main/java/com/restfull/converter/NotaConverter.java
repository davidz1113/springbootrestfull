package com.restfull.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.restfull.model.Nota;
import com.restfull.model.NotaEntity;

@Controller("notaconverter")
public class NotaConverter {

	public List<Nota> convertirLista(List<NotaEntity> notasEnt) {
		List<Nota> modelNota = new ArrayList<>();

		for (NotaEntity nota : notasEnt) {
			modelNota.add(new Nota(nota));
		}
		return modelNota;
	}

}
