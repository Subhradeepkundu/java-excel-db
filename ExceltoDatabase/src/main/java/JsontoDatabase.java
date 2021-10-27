import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JsontoDatabase
{
   static  int count=1;
    public static void main(String[] args)
    {

        JSONParser jsonParser=new JSONParser();
        try
        {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studs", "root", "sysmanage");
            Statement statement = connection.createStatement();

          FileReader reader = new FileReader(".\\jsonfiles\\Kaoan.json");
           //Scanner sc=new Scanner(new FileReader(".\\jsonfiles\\Kaoan.json"));
            //System.out.println("bl"+sc);

//            while (sc.hasNextLine())
//            {

             // String s=sc.nextLine();
           // Object obj = jsonParser.parse(sc.nextLine());
                Object obj = jsonParser.parse(reader);
               System.out.println("ddrr"+obj);



//                JSONObject em = (JSONObject) obj;
//                System.out.println("dddd" + em);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            for (Object emp:employeeList)
            {
                count++;
                JSONObject empObj=(JSONObject) emp;
                String studname = (String)empObj.get("studentname");
                String schoolnam = (String) empObj.get("schoolname");
             String addr = (String)empObj.get("address");
              String cty = (String) empObj.get("city");
            String cuntry = (String) empObj.get("country");
               String post = (String) empObj.get("postal");
             String phn = (String) empObj.get("phone");
             String eml = (String) empObj.get("email");
               String joiningdate = (String) empObj.get("doj");
                String sql = "INSERT INTO students VALUES(" + count + ",'" + studname + "','" + schoolnam + "','" + addr + "','" + cty + "','" + cuntry + "','" + post + "','" + phn + "','" + eml + "','" + joiningdate + "')";
                System.out.println(sql);
                statement.executeUpdate(sql);
            }

            //Iterate over employee array
         //   employeeList.forEach( emp -> parseEmployeeObject((JSONObject) emp));
          // String k=   emp -> parseEmployeeObject((JSONObject) emp);



                // JSONArray data = (JSONArray)em.get("studentname");



                // }


        }

        catch(FileNotFoundException e)
        {

        }
        catch(IOException e)
        {

        }
        catch(ParseException e)
        {

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

//    public static void parseEmployeeObject(JSONObject emp)
//    {
//        String l;
//        JSONObject em = (JSONObject) emp.get("student");
//        String studname = (String) em.get("studentname");
//        String schoolnam = (String) em.get("schoolname");
//        String addr = (String) em.get("address");
//        String cty = (String) em.get("city");
//        String cuntry = (String) em.get("country");
//        String post = (String) em.get("postal");
//        String phn = (String) em.get("phone");
//        String eml = (String) em.get("email");
//        String joiningdate = (String) em.get("doj");
//
//        String sql = "INSERT INTO students VALUES(" + count + ",'" + studname + "','" + schoolnam + "','" + addr + "','" + cty + "','" + cuntry + "','" + post + "','" + phn + "','" + eml + "','" + joiningdate + "')";
//
//        System.out.println(sql);
//
//    }

}
