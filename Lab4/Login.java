import java.util.Objects;
import java.util.Scanner;
import java.sql.*;

public class Login 
{

    public static void main(String[] args) 
    {
        Db database = new Db();

        Player player1;
        Player player2;
        Scanner scan = new Scanner(System.in);
        while (true) 
        {
            System.out.print("name igrok 1: ");
            String name1 = scan.nextLine();
            if (database.isUserExists(name1)) 
            {
                System.out.print("parol igrok 1: ");
                String pass1 = scan.nextLine();
                if (database.isUserPasswordExists(name1, pass1)) 
                {
                    player1 = new Player(name1);
                    break;
                }
            }
        }
        while (true) 
        {
            System.out.print("name igrok 2: ");
            String name2 = scan.nextLine();
            if (database.isUserExists(name2) && !Objects.equals(name2, player1.name())) 
            {
                System.out.print("Enter password of 2st player: ");
                String pass2 = scan.nextLine();
                if (database.isUserPasswordExists(name2, pass2)) 
                {
                    player2 = new Player(name2);
                    break;
                }
            }
        }
        database.close();
        scan.close();
    }
}
