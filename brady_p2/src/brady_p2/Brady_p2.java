package brady_p2;
import java.util.Scanner; 
import java.text.DecimalFormat; 

public class Brady_p2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 

		System.out.print("Let's calculate your BMI! "
				+ "Type 0 for Metric (kg/m) units or Type 1 for Standard (lb/in) units: ");

		int convert = scan.nextInt(); 
		double weight, height, bmi; 
		
		// Handles Standard 
		if (convert == 1) 	{
			System.out.print("What's your weight in pounds? ");
			weight = scan.nextDouble(); 

			System.out.print("What's your height in inches? ");
			height = scan.nextDouble(); 

			bmi = (703 * weight) / (height * height); 
		}
		// Handles metric
		else {
			System.out.print("What's your weight in kilograms? ");
			weight = scan.nextDouble(); 

			System.out.print("What's your height in meters? ");
			height = scan.nextDouble(); 

			bmi = (weight) / (height * height); 
		}
		
		
		// Cleans up the formatting
		DecimalFormat df = new DecimalFormat("##.00");
		String cleanBMI = df.format(bmi);
		
		System.out.print("Your BMI is ");
		System.out.print(cleanBMI); 
		System.out.print(" which means you're ");
		
		// Conditionals for BMI group
		if (bmi < 18.5) {
			System.out.print("underweight.");
		}
		else if (bmi > 18.5 && bmi < 24.9) {
			System.out.print("normal weight.");
		}
		else if (bmi > 24.9 && bmi < 29.9) {
			System.out.print("overweight.");
		}
		else {
			System.out.print("obese.");
		}
		scan.close(); 
		}

}
