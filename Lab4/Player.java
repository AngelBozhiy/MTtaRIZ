import java.sql.*;
public class Player {
    String name;
    Player(String name)
    {
        this.name = name;
    }
    int wins;
    int loses;
    String name()
    {
        return name;
    }
    String info()
    {
        return "Name: "+name+", Wins: "+wins+", Loses: "+loses;
    }
    void win()
    {
        System.out.println(name()+" win!");
        wins++;
    }
    void lose()
    {
        loses++;
    }
}
