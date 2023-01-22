import java.util.Scanner;
public class Player {
    public static Scanner in = new Scanner(System.in);
    

    public static void main(String[] args) 
    {
		System.out.print("vvedite name 1 igroka: " );
        String name1 = in.next();
		System.out.print("vvedite name 2 igroka: " );
		String name2 = in.next();
		System.out.println(name1 +" - igrok X");
		System.out.println(name2 +" - igrok O");
		int info1win = 0;
		int info2win = 0;
		int info1loses = 0;
		int info2loses = 0;
		
		App.PochatyGru();
		do {
			OtrymatyVvedennyaGravtsya();
			App.ProanalizuvatySitku();
			App.VyvestySitku();
			if (App.statusGry==App.STATUS_PEREMOGA_X){
				System.out.println("X pobedil");
			} else if (App.statusGry==App.STATUS_PEREMOGA_O){
				System.out.println("O pobedil");
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
