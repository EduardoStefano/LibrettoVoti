package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto libr = new Libretto();
		libr.add(new Voto(30, "Analisi I", LocalDate.of(2017, 1, 15)));
		libr.add(new Voto(28, "Analisi II", LocalDate.of(2018, 1, 10)));
		libr.add(new Voto(25, "Fisica I", LocalDate.of(2019, 2, 3)));
		libr.add(new Voto(20, "Fisica II", LocalDate.of(2018, 6, 20)));
		libr.add(new Voto(18, "Geometria", LocalDate.of(2018, 6, 21)));
		libr.add(new Voto(24, "Programmazione a Oggetti", LocalDate.of(2017, 1, 22)));
		libr.add(new Voto(19, "Economia", LocalDate.of(2017, 3, 15)));
		libr.add(new Voto(25, "Ricerca operativa", LocalDate.of(2019, 3, 17)));
		libr.add(new Voto(27, "Complementi di economia", LocalDate.of(2017, 2, 18)));
		libr.add(new Voto(26, "Logistica", LocalDate.of(2017, 2, 19)));
		
		List<Voto> venticinque = libr.cercaVoti(25);
		System.out.println(venticinque);
		
		Voto a1 = libr.cercaEsame("Analisi I");
		Voto a3 = libr.cercaEsame("Analaisi III");
		System.out.println(a1);
		System.out.println(a3);
		
		Voto giusto = new Voto(18, "Geometria", LocalDate.now());
		Voto sbagliato = new Voto(28, "Geometria", LocalDate.now());	
		Voto mancante = new Voto(30, "Merendine", LocalDate.now());
		System.out.format("Il voto %s è %s\n", giusto.toString(), libr.esisteGiaVoto(giusto));
		System.out.format("Il voto %s è %s\n", sbagliato.toString(), libr.esisteGiaVoto(sbagliato));
		System.out.format("Il voto %s è %s\n", mancante.toString(), libr.esisteGiaVoto(mancante));

	}
	
	
	
	

}
