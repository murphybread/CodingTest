import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        if (a == 1){
            if (b == 2){
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        } else if (a == 2) {
            if (b == 1){
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        } else {
            if (b == 2){
                System.out.println("A");
            } else {
                System.out.println("B");
            }            
        }
    }
}
