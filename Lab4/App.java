import java.sql.*;
public class App {
	public static final String POROZHNYA = "   ", KHRESTYK = " X ", NULYK = " O ";
	public static String aktyvnyiGravets;
	public static final int RYADKIV = 3, STOVPCHYKIV = 3;
	public static String[][] sitka = new String[RYADKIV][STOVPCHYKIV];
	public static int statusGry;
	public static final int STATUS_GRA_TRYVAYE = 0, STATUS_NICHYYA = 1, STATUS_PEREMOGA_X = 3, STATUS_PEREMOGA_O = 4;

	public static void PochatyGru() {
		for (int ryad = 0; ryad < RYADKIV; ryad++) {
			for (int stovp = 0; stovp < STOVPCHYKIV; stovp++) {
				sitka[ryad][stovp] = POROZHNYA;
			}
		}
		aktyvnyiGravets = KHRESTYK;
		VyvestySitku();
	}

	public static void ProanalizuvatySitku() {
		
		String peremozhets = ZnajtyPeremozhtsya();
		if (peremozhets.equals(KHRESTYK)){
			statusGry = STATUS_PEREMOGA_X;
		} else if (peremozhets.equals(NULYK)){
			statusGry = STATUS_PEREMOGA_O;
		} else if (ChyVsiKlitynkyZapovneni()){
			statusGry = STATUS_NICHYYA;
		} else {
			statusGry = STATUS_GRA_TRYVAYE;
		}
	}
	
	public static boolean ChyVsiKlitynkyZapovneni() {
		for (int ryad=0; ryad<RYADKIV; ryad++){
			for (int stovp=0; stovp < STOVPCHYKIV; stovp++){
				if (sitka[ryad][stovp]==POROZHNYA){
					return false;
				}
			}
		}
		return true;
	}

	public static String ZnajtyPeremozhtsya() {

		int iKilkistOdnakovykh;
		for (int ryad = 0; ryad < RYADKIV; ryad++) {
			iKilkistOdnakovykh = 0;
			for (int stovp = 0; stovp < STOVPCHYKIV; stovp++) {
				if (sitka[ryad][0] != POROZHNYA && sitka[ryad][0] == sitka[ryad][stovp]) {
					iKilkistOdnakovykh++;
				}
			}
			if (iKilkistOdnakovykh == 3) {
				return sitka[ryad][0];
			}
		}

		for (int stovp = 0; stovp < STOVPCHYKIV; stovp++) {
			iKilkistOdnakovykh = 0;
			for (int ryad = 0; ryad < RYADKIV; ryad++) {
				if (sitka[0][stovp] != POROZHNYA && sitka[0][stovp] == sitka[ryad][stovp]) {
					iKilkistOdnakovykh++;
				}
			}
			if (iKilkistOdnakovykh == 3) {
				return sitka[0][stovp];
			}
		}

		if (sitka[0][0] != POROZHNYA && sitka[0][0] == sitka[1][1] && sitka[0][0] == sitka[2][2]) {
			return sitka[0][0];
		}

		if (sitka[0][2] != POROZHNYA && sitka[1][1] == sitka[0][2] && sitka[2][0] == sitka[0][2]) {
			return sitka[0][2];
		}
		
		return POROZHNYA;
	}
	
	public static void VyvestySitku() {
		System.out.println();
		for (int ryad = 0; ryad < RYADKIV; ryad++) {
			for (int stovp = 0; stovp < STOVPCHYKIV; stovp++) {
				System.out.print(sitka[ryad][stovp]);
				if (stovp != STOVPCHYKIV - 1) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (ryad != RYADKIV - 1) {
				System.out.println("-----------");
			}
		}
		System.out.println();
	}

}
