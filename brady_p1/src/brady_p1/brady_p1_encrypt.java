package brady_p1;
import java.util.Scanner;

public class brady_p1_encrypt {
	public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	final int Max_Digits = 4; 	
	
	
	System.out.print("What four digit integer would you like to encrypt? ");
	String plainInt = scan.nextLine(); 
	
	// converting string into array so it's easier to play with indexes
	char plainIntArray[] = plainInt.toCharArray(); 
	char cipherIntArray[] = plainInt.toCharArray(); 

	// shifts the number over by 7
	for (int i = 0 ; i < Max_Digits; i++) {
		int ascii = (int)plainIntArray[i] - 48; 
		ascii = ((ascii + 7) % 10); 
		plainIntArray[i] = (char)(ascii + 48); 
		}
	
	// shift the numbers
	cipherIntArray[0] = plainIntArray[2]; 
	cipherIntArray[1] = plainIntArray[3]; 
	cipherIntArray[2] = plainIntArray[0]; 
	cipherIntArray[3] = plainIntArray[1]; 
	
	for (int i = 0 ; i < Max_Digits; i++) {
		System.out.print(cipherIntArray[i]);	
		}
		
	scan.close(); 
	}
}
