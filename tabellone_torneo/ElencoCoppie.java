package tabellone_torneo;

import java.util.ArrayList;

public class ElencoCoppie {
	
	ArrayList <String> partecipanti = new ArrayList <String>();
	ArrayList <Coppia> coppie = new ArrayList <Coppia>();
	
	/**costruttore della classe elencocoppie formato da due arraylist : uno di stringhe(partecipanti) e uno del tipo strutturato Coppia*/
	public ElencoCoppie(ArrayList <String> partecipanti,ArrayList <Coppia> coppie) {
		this.partecipanti = partecipanti;
		this.coppie = coppie;
	}

	public ArrayList<String> getPartecipanti() {
		return partecipanti;
	}

	public void setPartecipanti(ArrayList<String> partecipanti) {
		this.partecipanti = partecipanti;
	}

	public ArrayList<Coppia> getCoppie() {
		return coppie;
	}

	public void setCoppie(ArrayList<Coppia> coppie) {
		this.coppie = coppie;
	}
	
	public void inserisciPartecipante(String partecipante) {
		partecipanti.add(partecipante);
	}
	
	/**metodo che verifica se un partecipante è gia stato inserito
	 * 
	 * @param partecipante
	 * @return true or false
	 */
	public boolean partecipantePresente(String partecipante) {
		for(int i=0; i<partecipanti.size(); i++)
			if(partecipanti.get(i).equals(partecipante))
				return true;
		return false;
	}
	
	public void inserisciCoppia(Coppia c) {
		coppie.add(c);
	}
	
	/**metodo che mi consente di generare una coppia casuale prendendo due partecipanti e successivamente rimuoverli
	 * 
	 * @return Coppia
	 */
	public Coppia generaCoppia() {
		
		int primo = Utility.numCasuale(0, Math.max(0,partecipanti.size()-1));
		String partecipante1 = partecipanti.get(primo);
		partecipanti.remove(primo);
		
		int secondo = Utility.numCasuale(0, Math.max(0,partecipanti.size()-1));
		String partecipante2 = partecipanti.get(secondo);
		partecipanti.remove(secondo);
		
		return new Coppia(partecipante1,partecipante2,0,0);
	}
	
	public void generaTutteLeCoppie(ElencoCoppie elenco) {
		while(partecipanti.size()>0)
			elenco.inserisciCoppia(elenco.generaCoppia());
	}
	
	public void visualizzaCoppie(){
		for(int i=0; i<coppie.size(); i++) {
			System.out.println(coppie.get(i).toString());
		}
	}
	
	/**metodo che verifica se tutti i punteggi sono stati assegnati prima di passare alla fase successiva del torneo
	 * 
	 * @return true or false
	 */
	
	public boolean coppieTutteGiocate() {
		for(int i=0; i<coppie.size(); i++)
			if(coppie.get(i).giaAssegnato(coppie.get(i))==false)
				return false;
				return true;
	}
	
	public Coppia get(int i) {
		return coppie.get(i);
	}
	
	public int size() {
		return coppie.size();
	}
	
	/**metodo void che pulisce completamente i due arraylist che compongono l'elenco delle coppie*/
	public void pulizia() {
		partecipanti.clear();
		coppie.clear();
	}
	

}
