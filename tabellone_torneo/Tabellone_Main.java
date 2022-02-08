package tabellone_torneo;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class Tabellone_Main {
	
	private final static String INTRODUZIONE = "Benvenuto nel Tabellone da Torneo, scegli il nome del torneo: ";
	private final static String	NUMERO = "Inserisci il numero dei partecipanti: ";
	private final static String	NUMERO_ERRATO = "Il numero inserito non è adatto per la realizzazione del torneo, si prega di riprovare con un altro: ";
	private final static String PARTECIPANTI = "Inserisci un partecipante: ";
	private final static String	REINSERIMENTO = "Il nome è gia presente, si prega di inserirne un altro: ";
	private final static String	PRIMO = "inserisci il punteggio del primo partecipante: ";
	private final static String	SECONDO = "inserisci il punteggio del secondo partecipante: ";
	private final static String OPZIONI = "Scegli una delle seguenti opzioni: ";
	private final static String SCELTA1 = "Inserisci i risultati per ogni incontro";
	private final static String SCELTA2 = "Visualizza tutte le coppie";
	private final static String SCELTA3 = "Determina i vincitori per ogni incontro";
	private final static String SCELTA4 = "Passa al turno successivo";
	private final static String SCELTA5 = "Termina il programma prima della sua conclusione";
	private final static String[] SCELTA = {SCELTA1,SCELTA2,SCELTA3,SCELTA4,SCELTA5};

	public static void main(String[] args) {
		
		
		
		ArrayList <String> partecipanti = new ArrayList <String>();
		ArrayList <Coppia> coppie = new ArrayList <Coppia>();
		
		ArrayList <String> partecipantiInGioco = new ArrayList <String>();
		ElencoCoppie elenco = new ElencoCoppie(partecipanti,coppie);
		
		String nomeTorneo = InputDati.leggiStringaNonVuota(INTRODUZIONE);
		
		Tabellone tabellone = new Tabellone(nomeTorneo, partecipantiInGioco, elenco);
		
		int numero;
		
		do {
			
		numero = InputDati.leggiIntero(NUMERO);
		if(Utility.potDi2(numero)==false)
			System.out.println(NUMERO_ERRATO);
		
		} while(Utility.potDi2(numero)==false);
		
		for(int i=0; i<numero; i++) {
			
			String nome;
			
			do{
				nome = InputDati.leggiStringaNonVuota(PARTECIPANTI);
			
			
			if(elenco.partecipantePresente(nome)==true) {
				
				System.out.println(REINSERIMENTO);
			}
			
			
			} while(elenco.partecipantePresente(nome)==true);
			
			tabellone.inserisciPartecipante(nome);
			elenco.inserisciPartecipante(nome);
			
		}
		
		elenco.generaTutteLeCoppie(elenco);
		
		int s;
		MyMenu menu = new MyMenu(OPZIONI,SCELTA);
		
		do {
			
			s=menu.scegli();
			
			if(s==1) {
				
				for(int i=0; i<coppie.size(); i++) {
					System.out.println("per la coppia "+coppie.get(i).concorrenti()+" inserire i risultati");
					
					
					do {
						
						int ris1 = InputDati.leggiIntero(PRIMO);
						int ris2 = InputDati.leggiIntero(SECONDO);
						coppie.get(i).assegnaPunteggio(ris1, ris2, coppie.get(i));
						
						if(coppie.get(i).punteggioNegativo()) 
							System.out.println("punteggi negativi non sono ammessi: riprovare");
						
						if(coppie.get(i).pareggio()) 
							System.out.println("i pareggi non sono ammessi: riprovare");
							
						
						} while(( coppie.get(i).punteggioNegativo()==true) || (coppie.get(i).pareggio() == true) );
					
					
				}
				
			}
			
			if(s==2) {
				elenco.visualizzaCoppie();
			}
			
			if(s==3) {
				partecipantiInGioco.clear();
				for(int i=0; i<coppie.size(); i++) {
					System.out.println("della coppia "+coppie.get(i).toString()+ " il vincitore è: "+coppie.get(i).vincitore());
					partecipantiInGioco.add(coppie.get(i).vincitore());
				}
			}
			
			if(s==4) {
				
				if(elenco.coppieTutteGiocate()==true) {
					
				tabellone.turnoSuccessivo(tabellone);
				System.out.println(tabellone.vincitoreTorneo());
				if(tabellone.getPartecipantiInGioco().size()==1)
					s=0;
				
				}
				else
					System.out.println("ci sono coppie per cui non è stato ancora definito un punteggio...");
			}
			
			if(s==5) {
				s=0;
			}
			
		}while(s!=0);
		
		

	}

}
