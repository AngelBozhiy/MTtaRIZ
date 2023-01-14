import java.sql.*;

class Db {
    String dbUrl = "jdbc:mysql://localhost:3306/myGame?useSSL=false";
    String user = "root";
    String password = "Root";
    Connection connect;

    public Db() 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connect = DriverManager.getConnection(dbUrl, user, password);
        } catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    public void close() 
    {
        try 
        {
            connect.close();
        } catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    public boolean isUserExists(String username) 
    {
        try 
        {
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM users WHERE username='" + username + "';");
            while (rs.next()) if (rs.getInt(1) == 1) return true;
            else return false;
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return true;
    }
    public boolean isUserPasswordExists(String username, String password) 
    {
        try 
        {
            Statement stmt = connect.createStatement();
            ResultSet rsPass = stmt.executeQuery("SELECT password FROM users WHERE username='" + username + "';");
            while (rsPass.next()) if (rsPass.getString(1) .equals(password))
                return true;
            else return false;
        } catch (Exception e) 
        {
            System.out.println(e);
        }
        return false;
    }
}
