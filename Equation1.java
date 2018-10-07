import java.util.Scanner;
// ax+by=c
// dx+ey=f
public class Equation1
{
   public static void main (String [] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a1: ");
      float a1 = input.nextFloat();
      System.out.println("Enter b1: ");
      float b1 = input.nextFloat();
      System.out.println("Enter c1: ");
      float c1 = input.nextFloat();
      System.out.println("Enter a2: ");
      float a2 = input.nextFloat();
      System.out.println("Enter b2: ");
      float b2 = input.nextFloat();
      System.out.println("Enter c2: ");
      float c2 = input.nextFloat();
      
      float x,y;
      if((a1*b2-b1*a1)!=0)
      {
      x=(c1*b2-b1*c2)/(a1*b2-b1*a1);
      y=(a1*c2-c1*a2)/(a1*b2-b1*a1);
      System.out.printf("x is %4.2f and y is %4.2f", x, y);
      }
      else
         System.out.println("Invalid");
      
      }
}
   