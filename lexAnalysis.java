import java.util.Scanner;
public class lexAnalysis
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a value: ");
      String s = input.next();
      while(s!=""){
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
            System.out.println(s + " is an error.");}
   }
    public static boolean isDigit(String value)
    {        
        boolean seenDigit = false;
        for (int i=0; i < value.length(); i++)
        {
            char c = value.charAt(i);
            if (c >= '0' && c <= '9')
            {
                seenDigit = true;
                continue;
            }
        return false;
        }
        if (!seenDigit)
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

    public static boolean isFloat(String value)
    {
        boolean seenDot = false;
  
        for (int i=0; i < value.length(); i++)
        {
            char c = value.charAt(i);
            if (c >= '0' && c <= '9')
                continue;
            if (c == '.' && !seenDot)
            {
                seenDot = true;
                continue;
            }
            return false; 
        }      
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
            Double.parseDouble(value);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
    public static boolean isExp(String value)
    {
        boolean seenExp = false;
        boolean seenDot = false;
        boolean justSeenExp = false;
    
        for (int i=0; i < value.length(); i++)
        {
            char c = value.charAt(i);
       
            if (c >= '0' && c <= '9')     
                continue;
            if ((c == '-' || c=='+') && (i == 0 || justSeenExp))
                continue;
            if (c == '.' && !seenDot)
                continue;
            justSeenExp = false;
            if ((c == 'e' || c == 'E') && !seenExp)
            {
                seenExp = true;
                justSeenExp = true;
                continue;
            }
            return false;
        }
   
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