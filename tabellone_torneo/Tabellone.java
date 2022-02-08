package tabellone_torneo;

import java.util.ArrayList;

public class Tabellone {
	
	ArrayList <Coppia> coppie = new ArrayList <Coppia>();
	ArrayList <String> partecipanti = new ArrayList <String>();
	
	private String nomeTorneo;
	ArrayList <String> partecipantiInGioco = new ArrayList <String>();
	ElencoCoppie elenco = new ElencoCoppie(partecipanti,coppie);
	
	/**costruttore della classe tabellone: esso è formato dal nome del torneo, un arraylist di partecipanti ancora in gioco e il tipo strutturato ElencoCoppie
	 * 
	 * @param nomeTorneo
	 * @param partecipantiInGioco
	 * @param elenco
	 */
	public Tabellone(String nomeTorneo, ArrayList <String> partecipantiInGioco,ElencoCoppie elenco ) {
		this.nomeTorneo = nomeTorneo;
		this.partecipantiInGioco = partecipantiInGioco;
		this.elenco = elenco;
	}

	public ArrayList<Coppia> getCoppie() {
		return coppie;
	}

	public void setCoppie(ArrayList<Coppia> coppie) {
		this.coppie = coppie;
	}

	public ArrayList<String> getPartecipanti() {
		return partecipanti;
	}

	public void setPartecipanti(ArrayList<String> partecipanti) {
		this.partecipanti = partecipanti;
	}

	public String getNomeTorneo() {
		return nomeTorneo;
	}

	public void setNomeTorneo(String nomeTorneo) {
		this.nomeTorneo = nomeTorneo;
	}

	public ArrayList<String> getPartecipantiInGioco() {
		return partecipantiInGioco;
	}

	public void setPartecipantiInGioco(ArrayList<String> partecipantiInGioco) {
		this.partecipantiInGioco = partecipantiInGioco;
	}

	public ElencoCoppie getElenco() {
		return elenco;
	}

	public void setElenco(ElencoCoppie elenco) {
		this.elenco = elenco;
	}
	
	public void partecipantiInGara() {
		for(int i=0;i<partecipantiInGioco.size(); i++) {
			System.out.println(partecipantiInGioco.get(i));
		}
	}
	
	public void rimuoviSconfitto(String vinto) {
		partecipantiInGioco.remove(vinto);
		}
	
	/**metodo che prende i vincitori, cioè i partecipanti ancora in gioco e li sistema nella list di partecipanti per la nuova fase del torneo*/
	public void prendiVincitori() {
		 for(int i=0; i<partecipantiInGioco.size(); i++) {
		    	String s = partecipantiInGioco.get(i);
		    	elenco.inserisciPartecipante(s);
		    }
	}
	
/**metodo che mostra il vincitore del torneo in caso si tratti della fase finale
 * 
 * @return ritorna una stringa escplicativa
 */
	public String vincitoreTorneo() {
		if(partecipantiInGioco.size()==1)
			return "il vincitore é: "+partecipantiInGioco.get(0)+"!!!!!!!";
		else return "il torneo non è ancora concluso";
	}
	/** metodo che consente di passare al turno successivo
	 * 
	 * @param t
	 */
	public void turnoSuccessivo(Tabellone t) {
		
		elenco.pulizia();
	    t.prendiVincitori();
	    if(partecipantiInGioco.size()!=1)
	    elenco.generaTutteLeCoppie(elenco);
	}
	
	public void inserisciPartecipante(String partecipante) {
		partecipantiInGioco.add(partecipante);
	}
	

	

}
