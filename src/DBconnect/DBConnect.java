package DBconnect;

import java.sql.*;

public class DBConnect {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public DBConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/population of city","root","");
            st = con.createStatement();
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error:" +ex);
        }
    }
    
    public void getData(){
        try{
            String query = "select * from populationofcity";
                
                rs = st.executeQuery(query);
               while(rs.next()){ 
                String CityName = rs.getString("City Name");
                String Province = rs.getString("Province");
                String Population = rs.getString("Population");
                
                System.out.println("CityName :"+CityName+ "  "+"Province :"+Province+ "  "+"Population :"+Population);
              }
            }catch(Exception ex){
            System.out.println(ex);
        }
    }
}