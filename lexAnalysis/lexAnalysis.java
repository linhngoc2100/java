/*Name: Linh Ngoc Nguyen
Course: COMP 310
Assignemnt 1: Simple Lexical Analysis
*/
import java.util.Scanner;
public class lexAnalysis
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a value: ");
      String s = input.next();
        if(isDigit(s))
        {
            if(isOcta(s))
               System.out.println(s + " is an octal number.");
            else
               System.out.println(s +" is a decimal number.");}
      
        else if(isFloat(s))           
            System.out.println(s +" is a floating point number.");
        else if(isExp(s))
            System.out.println(s +" is a scientific notation number.");
        else
            System.out.println(s + " is an error.");
   }
    public static boolean isDigit(String value)
    {        
        boolean seenNumber = false;
        for (int i=0; i < value.length(); i++)
        {
            char c = value.charAt(i);
            if (c >= '0' && c <= '9')
            {
                seenNumber = true;
                continue;
            }
            if ((c == '-' || c=='+') && (i == 0))
                continue;
        return false;
        }
        if (!seenNumber)
            return false;
        try
        {
            Integer.parseInt(value);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public static boolean isFloat(String value)
    {
        boolean theDot = false;
  
        for (int i=0; i < value.length(); i++)
        {
            char c = value.charAt(i);
            if (c >= '0' && c <= '9')
                continue;
            if ((c == '-' || c=='+') && (i == 0))
                continue;
            if (c == '.' && !theDot)
            {
                theDot = true;
                continue;
            }
            return false; 
        }
        if(value.indexOf('.')>=0)
            return true;      
        try
        {
            Double.parseDouble(value);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public static boolean isOcta(String value)
    {
        boolean seenOcta = false;
        for (int i=0; i < value.length(); i++)
        {
            char c = value.charAt(i);
            if(value.charAt(0)=='0')
            {
                if (c >= '0' && c <= '7')
                {
                    seenOcta = true;
                    continue;
                }   
            }
            return false;
        }
        if (!seenOcta)
            return false;
        try
        {
            Integer.parseInt(value);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
    public static boolean isExp(String value)
    {
        boolean theExp = false;
        boolean theDot = false;
        boolean onlyExp = false;
    
        for (int i=0; i < value.length(); i++)
        {
            char c = value.charAt(i);
       
            if (c >= '0' && c <= '9')     
                continue;
            if ((c == '-' || c=='+') && (i == 0 || onlyExp))
                continue;
            if (c == '.' && !theDot)
                {theDot=true;
                continue;}
            onlyExp = false;
            if ((c == 'e' || c == 'E') && !theExp)
            {
                theExp = true;
                onlyExp = true;
                continue;
            }
            return false;
        }
       
        if((value.matches("e")) || (value.matches("E")))
            return false;
        try
        {
            Double.parseDouble(value);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}