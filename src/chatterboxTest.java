import java.util.*;
import java.io.*;
public class chatterboxTest{
   public static void main(String[]args)throws FileNotFoundException{
      Scanner sc= new Scanner(System.in);
      Scanner Awsnsers = new Scanner(new File("Awsnsers.txt"));
      Scanner Responses = new Scanner(new File("Responses.txt"));
      ArrayList<String> listOfResponses =arrayOfResponses(Responses);
      ArrayList<String> listOfAwnsers = arrayOfAwnsers(Awsnsers);
   }
   
   public static ArrayList<String> arrayOfResponses(Scanner Responses){
      ArrayList<String> temp = new ArrayList<String>();
      while(Responses.hasNextLine()){
         temp.add(Responses.nextLine());
      }
      return temp;
   }
   
   public static ArrayList<String> arrayOfAwnsers(Scanner Awsnsers){
     ArrayList<String> temp = new ArrayList<String>();
      while(Awsnsers.hasNextLine()){
         temp.add(Awsnsers.nextLine());
      }
      return temp;
   }
   
  /* public static String response(int userInput){
      if(userInput > -1){
         return 
      }

   }*/

}
