import java.lang.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Get the number
        System.out.print("Enter the number: ");
        Scanner Number = new Scanner(System.in);
        int Numbers = Number.nextInt();

        //Print the top half of the pyramid
        for(int i=0;i<Numbers;i+=2){
            //Print spacing
            for(int j=i;j<Numbers;j++){
                System.out.print(" ");
            }

            //Print hashes
            for(int j=0;j<=i;j++){
                System.out.print(" #");
            }


            //Add another line after drawing the hash
            System.out.print("\n");
        }

        //Print the bottom half of the pyramid
        for(int i=1;i<=Numbers;i+=2){
            //Print spacing
            for(int j=1;j<i;j++){
                System.out.print(" ");
            }

            //Print hashes
            for(int j=i;j<=Numbers;j++){
                System.out.print(" #");
            }
            //Add another line after drawing the hash
            System.out.println(" ");
        }

    }
}
