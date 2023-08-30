import java.sql.*;


public class DBConnector {
    public static void main(String[] args) throws SQLException
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","jatin191");

            Statement stmt = con.createStatement();

//READ
String querry="SELECT * FROM ADMIN";
stmt.executeQuery(querry);
ResultSet rs = stmt.executeQuery(querry);

//INSERT
String newquerry="INSERT INTO ADMIN VALUES (101,'jesse')";

stmt.executeUpdate(newquerry);

ResultSet rs1 = stmt.executeQuery(newquerry);

//UPDATE
String newquerryy="update admin set adminname='yooooooo' where adminid=101";

stmt.executeUpdate(newquerry);

ResultSet rs3 = stmt.executeQuery(newquerry);

//DELETE
String newquerryyy="delete from admin where adminid=101";

stmt.executeUpdate(newquerry);

ResultSet rs4 = stmt.executeQuery(newquerry);

//ResultSet rs = stmt.executeQuery("SELECT * FROM ADMIN");

            while(rs.next())
            {
                //System.out.println("helo");
                System.out.print("ID: "+rs.getString(1)+ " , ");
                System.out.print("Name: "+rs.getString(2));
                System.out.println();

            }
            System.out.println("executed");

            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        };
    }
}