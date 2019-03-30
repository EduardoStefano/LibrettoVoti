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
	 * @return {@code true} nel caso normale, {@code false} se non è riuscito
	 */
	public boolean add(Voto v) {
		if(!this.esisteGiaVoto(v) && !this.votoInConflitto(v)) {
			voti.add(v);
			return true;
		}
		else {
			return false;
		}
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
	
	/**
	 * Ricerca un {@link Voto} realtivo al corso di cui è specificato il nome
	 * 
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente, oppure {@link null} se non esistente
	 */
	public Voto cercaEsame(String nomeEsame) {
		Voto voto = new Voto(0, nomeEsame, null);
		int pos = voti.indexOf(voto);
		if(pos==-1) {
			return null;
		}
		else {
			return voti.get(pos);
		}
		
	}
	
	/**
	 * Dato un voto {@link Voto} determina se esiste gia un voto con uguale 
	 * corso ed uguale punteggio
	 * @param v
	 * @return {@code true} se ha trovato un corso e punteggio uguali, 
	 * {@code false} se  non ha trovato il coros o l'ha trovato con voto diverso
	 */
	public boolean esisteGiaVoto(Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos==-1) {
			return false;
		}
		else 
			return (v.getPunti()==this.voti.get(pos).getPunti());
	}
	
	/**
	 * Mi dice se il voto v è in conflitto co uno dei voti esistenti
	 * se il voto non esiste non c'è conflitto. Se esiste ed ha punteggio
	 * diverso c'è conflitto
	 * @param v
	 * @return ({@code true} se il voto esiste ed ha punteggio diverso,
	 * 		   ({@code false} se il voto esiste, oppure esiste ma ha lo stesso
	 * 		   punteggio
	 */
	public boolean votoInConflitto(Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos==-1) {
			return false;
		}
		else 
			return (v.getPunti() != this.voti.get(pos).getPunti());
	}
	
	public String toString() {
		return this.voti.toString();
	}
	
	public Libretto librettoMigliorato(){
		Libretto nuovo = new Libretto();
		for(Voto v:this.voti) {
			nuovo.add(v.clone());
		}
		for(Voto v:nuovo.voti) {
			int punti = v.getPunti();
			if(punti<24)
				punti+=1;
			else if(punti <= 28)
				punti+=2;
			v.setPunti(punti);
		}
		return nuovo;
	}
	
	//modificare la collection mentre sta iterando non va bene
	//è bene utilizzare un metodod come questo
	public void cancellaVotiScarsi() {
		List<Voto> votiDaCancellare = new ArrayList<Voto>();
		for(Voto v:this.voti) {
			if(v.getPunti()<24) {
				votiDaCancellare.add(v);
			}
		}
		this.voti.removeAll(votiDaCancellare);
	}
	
}
