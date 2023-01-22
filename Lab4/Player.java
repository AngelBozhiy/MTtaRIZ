import java.sql.*;
import java.util.Scanner;
public class Player {
    public static Scanner in = new Scanner(System.in);
    

    public static void main(String[] args) 
    {
        String name1;
		String name2;
		int restart = 1;
		int info1win = 0;
		int info2win = 0;
		int info1loses = 0;
		int info2loses = 0;

		Db myDatabase = new Db();
        while (true) {
            System.out.print("vvedite name 1 igroka: ");
            String Name1 = in.nextLine();
            if (myDatabase.isUserExists(Name1)) {
                System.out.print("vvedite parol 1 igroka: ");
                String Parol1 = in.nextLine();
                if (myDatabase.isUserPasswordExists(Name1, Parol1)) {
                    name1 = Name1;
                    break;
                }
            }
        }

		while (true) {
            System.out.print("vvedite name 2 igroka: ");
            String Name2 = in.nextLine();
            if (myDatabase.isUserExists(Name2)) {
                System.out.print("vvedite parol 2 igroka: ");
                String Parol2 = in.nextLine();
                if (myDatabase.isUserPasswordExists(Name2, Parol2)) {
                    name2 = Name2;
                    break;
                }
            }
        }
		while (restart == 1)
		{
		System.out.println(name1 +" - igrok X");
		System.out.println(name2 +" - igrok O");
		App.PochatyGru();
		do {
			OtrymatyVvedennyaGravtsya();
			App.ProanalizuvatySitku();
			App.VyvestySitku();
			if (App.statusGry==App.STATUS_PEREMOGA_X){
				System.out.println(name2 +" pobedil");
			} else if (App.statusGry==App.STATUS_PEREMOGA_O){
				System.out.println(name1+" pobedil");
			} else if (App.statusGry==App.STATUS_NICHYYA){
				System.out.println("Nichya");
			} 
			App.aktyvnyiGravets = (App.aktyvnyiGravets==App.KHRESTYK?App.NULYK:App.KHRESTYK);
		}
		while (App.statusGry==App.STATUS_GRA_TRYVAYE);
		if(App.statusGry==App.STATUS_PEREMOGA_X)
		{
			info1win++;
			info2loses++;
		}
		else
		{
			info2win++;
			info1loses++;
		}

		System.out.print("\nIgrok "+name1+" kolvo pobed - "+info1win+", kolvo proigroshey - "+info1loses+
		"\nIgrok "+name2+" kolvo pobed - "+info2win+", kolvo proigroshey - "+info2loses);
		System.out.println();
		System.out.print("hotite pereigrat? \n1-da 2-net: ");
		restart = in.nextInt();
		}
		System.exit(0);
	}

    public static void OtrymatyVvedennyaGravtsya() {
		boolean vvedennyaDijsne = false;
		do {
			System.out.print(App.aktyvnyiGravets + ", vvedite nomer riadka i stovpca cherez probel: " );
			int ryad = in.nextInt() - 1;
			int stovp = in.nextInt() - 1;
			if (ryad >= 0 && ryad < App.RYADKIV && stovp >= 0 && stovp < App.STOVPCHYKIV && App.sitka[ryad][stovp] == App.POROZHNYA) {
				App.sitka[ryad][stovp] = App.aktyvnyiGravets;
				vvedennyaDijsne = true;
			} else {
				System.out.println("Ne pidhodut");
			}
		} while (!vvedennyaDijsne);
	}  
}
