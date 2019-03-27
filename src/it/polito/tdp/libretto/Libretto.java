package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	/*public void add(int voto, String corso, LocalDate data) {
		
	}*/
	
	//voti in ordine di inserimento
	/**
	 * Aggiungi un nuovo voto al libretto
	 * @param v {@link Voto} da aggiungere
	 */
	public void add(Voto v) {
		voti.add(v);
	}
	
	
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * @param punti punteggio da ricercare
	 * @return lista di {@link Voto} voti aventi tutti quel punteggio (eventualmente vuota)
	 */
	public List<Voto> cercaVoti(int voto){
		
		List<Voto> result = new ArrayList<Voto>();
		for(Voto v:this.voti) {
			if(v.getPunti()==voto) {
				result.add(v);
			}
		}
		return result;
		
	}
}
