package tabellone_torneo;

public class Coppia {
	
	private String partecipante1;
	private String partecipante2;
	private int risultato1;
	private int risultato2;
	
	/**costruttore della classe coppia costituita da due partecipanti e il risultato di entrambi*/
	public Coppia(String partecipante1, String partecipante2, int risultato1, int risultato2) {
		this.partecipante1 = partecipante1;
		this.partecipante2 = partecipante2;
		this.risultato1 = risultato1;
		this.risultato2 = risultato2;
	}

	public String getPartecipante1() {
		return partecipante1;
	}

	public void setPartecipante1(String partecipante1) {
		this.partecipante1 = partecipante1;
	}

	public String getPartecipante2() {
		return partecipante2;
	}

	public void setPartecipante2(String partecipante2) {
		this.partecipante2 = partecipante2;
	}

	public int getRisultato1() {
		return risultato1;
	}

	public void setRisultato1(int risultato1) {
		this.risultato1 = risultato1;
	}

	public int getRisultato2() {
		return risultato2;
	}

	public void setRisultato2(int risultato2) {
		this.risultato2 = risultato2;
	}
	
	/**descrizione di una coppia sotto forma di stringa
	 * @return String
	 * ritorna una stringa descrittiva*/
	public String toString() {
		return "i concorrenti sono "+partecipante1+" e "+partecipante2+", per un punteggio di: "+risultato1+"-"+risultato2;
	}
	
	/**@return ritorna una stringa descrittiva in cui mostra solo i partecipanti*/
	public String concorrenti() {
		return partecipante1+"-"+partecipante2;
	}
	
	/** prende come argomenti i due risultati e la coppia in cui si vogliono inserire e modifica il risultato
	 * 
	 * @param ris1
	 * @param ris2
	 * @param c
	 */
	public void assegnaPunteggio(int ris1, int ris2, Coppia c) {
		c.setRisultato1(ris1);
		c.setRisultato2(ris2);
	}
	
	/**metodo che verifica se in una coppia è presente un punteggio negativo
	 * 
	 * @return true or false
	 */
	public boolean punteggioNegativo() {
		if(risultato1<0 || risultato2<0)
			return true;
			else return false;
	}
	
	/**metodo che verifica se un punteggio è gia stato assegnato a una coppia
	 * 
	 * @param c
	 * @return true or false
	 */
	public boolean giaAssegnato(Coppia c) {
		if(c.getRisultato1()!=0 || c.getRisultato2()!=0)
			return true;
		else return false;
	}
	
	/** metodo che ritorna il vincitore di una coppia
	 * 
	 * @return partecipante1 or partecipante2
	 */
	public String vincitore() {
		if(risultato1>risultato2)
			return partecipante1;
		else return partecipante2;
	}
	
	/** metodo che ritorna lo sconfitto di una coppia
	 * 
	 * @return partecipante1 or partecipante2
	 */
	public String vinto() {
		if(risultato2>risultato1)
		return partecipante1;
	else return partecipante2;
	}
	
	/**metodo che restituisce un operatore booleano a seconda se si verifica un pareggio o meno
	 * 
	 * @return true or false
	 */
	public boolean pareggio() {
		if( (risultato1!=0 || risultato2!=0) && risultato1==risultato2)
			return true;
			else return false;
	}


}
