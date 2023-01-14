import java.util.Scanner;

public class Pole {
	public static final String p = "   ", x = " X ", o = " O ";
	public static String ktohodit;
	public static final int riadok = 3, stovp = 3;
	public static String[][] pole = new String[riadok][stovp];
	public static int igra;
	public static final int idet = 0, nichya = 1, winX = 3, winO = 4;
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Nachalo();
		do {
			igrokhodit();
			analizpobedu();
			pokazpole();
			if (igra==winX)
            {
				System.out.println("X Pobedil");
			} 
            else if (igra==winO)
            {
				System.out.println("O Pobedil");
			} 
            else if (igra==nichya)
            {
				System.out.println("Nichiya");
			} 
			ktohodit = (ktohodit==x?o:x);
		}
		while (igra==idet);
		
	}

	public static void Nachalo() 
    {
		for (int ryad = 0; ryad < riadok; ryad++) 
        {
			for (int stovp = 0; stovp < stovp; stovp++) 
            {
				pole[ryad][stovp] = p;
			}
		}
		ktohodit = x;
		pokazpole();
	}

	public static void igrokhodit() 
    {
		boolean podhodit = false;
		do 
        {
			System.out
					.println(ktohodit + " vvedit riadok (1-3) i stolbec (1-3) cherez probel: ");
			int ryad = scan.nextInt() - 1;
			int stovp = scan.nextInt() - 1;
			if (ryad >= 0 && ryad < riadok && stovp >= 0 && stovp < stovp && pole[ryad][stovp] == p) 
            {
				pole[ryad][stovp] = ktohodit;
				podhodit = true;
			} 
            else 
            {
				System.out.println("Ne podhodit");
			}
		} while (!podhodit);
	}

	public static void analizpobedu() 
    {
		String pobeditel = pobeditel();
		if (pobeditel.equals(x))
        {
			igra = winX;
		} 
        else if (pobeditel.equals(o))
        {
			igra = winO;
		} 
        else if (nichya())
        {
			igra = nichya;
		} 
        else 
        {
			igra = idet;
		}
	}

	public static boolean nichya() 
    {
		for (int ryad=0; ryad<riadok; ryad++)
        {
			for (int stovp=0; stovp < stovp; stovp++)
            {
				if (pole[ryad][stovp]==p)
                {
					return false;
				}
			}
		}
		return true;
	}

	public static String pobeditel() 
    {
		int kolvo;
		for (int ryad = 0; ryad < riadok; ryad++) 
        {
			kolvo = 0;
			for (int stovp = 0; stovp < stovp; stovp++) 
            {
				if (pole[ryad][0] != p && pole[ryad][0] == pole[ryad][stovp]) 
                {
					kolvo++;
				}
			}
			if (kolvo == 3) 
            {
				return pole[ryad][0];
			}
		}
		for (int stovp = 0; stovp < stovp; stovp++) 
        {
			kolvo = 0;
			for (int ryad = 0; ryad < riadok; ryad++) 
            {
				if (pole[0][stovp] != p && pole[0][stovp] == pole[ryad][stovp]) 
                {
					kolvo++;
				}
			}
			if (kolvo == 3) 
            {
				return pole[0][stovp];
			}
		}
		if (pole[0][0] != p && pole[0][0] == pole[1][1] && pole[0][0] == pole[2][2]) 
        {
			return pole[0][0];
		}
		if (pole[0][2] != p && pole[1][1] == pole[0][2] && pole[2][0] == pole[0][2]) 
        {
			return pole[0][2];
		}
		return p;
	}
	
	public static void pokazpole() 
    {
		for (int ryad = 0; ryad < riadok; ryad++) 
        {
			for (int stovp = 0; stovp < stovp; stovp++) 
            {
				System.out.print(pole[ryad][stovp]);
				if (stovp != stovp - 1) 
                {
					System.out.print("|");
				}
			}
			System.out.println();
			if (ryad != riadok - 1) 
            {
				System.out.println("-----------");
			}
		}
		System.out.println();
	}
}
