package tabellone_torneo;

import it.unibs.fp.mylib.NumeriCasuali;

public class Utility {
	
	public static boolean potDi2(int n) {
		
		if(n<=1)
			return false;
		else {
			
			do {
				if(n%2!=0)
					return false;
				n=n/2;
				
			} while(n!=1);
			
			return true;
			
		}
		
	}
	
	public static int numCasuale(int min, int max) {
		int n = NumeriCasuali.estraiIntero(min, max);
		return n;
	}

}
