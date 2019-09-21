package brady_p1;
import java.util.Scanner;

public class brady_p1_decrypt {

	public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	final int Max_Digits = 4; 	
		
	System.out.print("What four digit integer would you like to decrypt? ");
	String cipherInt = scan.nextLine(); 

	// converting string into array so it's easier to play with indexes
	char cipherIntArray[] = cipherInt.toCharArray(); 
	char plainIntArray[] = cipherInt.toCharArray(); 

	//Shift the numbers
	plainIntArray[0] = cipherIntArray[2]; 
	plainIntArray[1] = cipherIntArray[3]; 
	plainIntArray[2] = cipherIntArray[0]; 
	plainIntArray[3] = cipherIntArray[1]; 

	//Shifts the number over by 7
	for (int i = 0 ; i < Max_Digits; i++) {
		int ascii = (int)plainIntArray[i] - 48; 
		ascii = ((ascii + 10 - 7) % 10); 
		plainIntArray[i] = (char)(ascii + 48); 
			}

	for (int i = 0 ; i < Max_Digits; i++) {
		System.out.print(plainIntArray[i]);	
		}

			
	scan.close(); 


		
		
	}

}
