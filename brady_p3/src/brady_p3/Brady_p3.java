package brady_p3;
import java.util.Scanner; 

public class Brady_p3 {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in); 
	
	final int topicsTotal = 5;
	final int surveyTakers = 10; 
	final int ratings = 10; 

	System.out.print("Rate each topic from 1 (least important) to 10 (most important)\n");
	String topics[] = new String[topicsTotal];
	topics[0] = "Issue1";
	topics[1] = "Issue2";
	topics[2] = "Issue3";
	topics[3] = "Issue4";
	topics[4] = "Issue5";
		
	int[][] responses = new int[topicsTotal][surveyTakers]; //topicsTotal = rows & surveyTakers = columns 
	int[][] output = new int[topicsTotal][ratings]; //int [row][columns] & topicstotal = rows & ratings = columns

	// Initialize array for counting surveyTaker's ratings per topic
	for (int r = 0; r < topicsTotal; r++) {
		for (int c = 0; c < ratings; c++) {
			output[r][c] = 0; 
		}
	}
	
	// Loop over for surveyTaker's ratings per topic
	for (int c = 0; c < surveyTakers; c++) {
		System.out.printf("Person %d\n", c+1);
		for (int r = 0; r < topicsTotal; r++) {
			System.out.print(topics[r] + ": ");
			int rating = scan.nextInt();
			responses[r][c] = rating;
			output[r][rating-1]++; 	
		}
	}	
	
	// Collects sum of each topic
	double[] avRating = new double[topicsTotal]; 
	for (int r = 0; r < topicsTotal; r++) {
		for (int c = 0; c < ratings; c++) {
			avRating[r] += responses[r][c];  
		}
	}

	// Quick and dirty way to get sums of ratings 
	double issue1Sum = avRating[0];
	double issue2Sum = avRating[1];
	double issue3Sum = avRating[2];
	double issue4Sum = avRating[3];
	double issue5Sum = avRating[4];
	
	double lowestSum = issue1Sum; 
	double highestSum = issue1Sum; 
	int highestIssue = 1;
	int lowestIssue = 1;
	
	
	// Conditionals to compare lowest value
	if (lowestSum > issue2Sum) {
		lowestSum = issue2Sum;
		lowestIssue = 2;
	}
	if (lowestSum > issue3Sum) {
		lowestSum = issue3Sum;
		lowestIssue = 3;		
	}
	if (lowestSum > issue4Sum) {
		lowestSum = issue4Sum;
		lowestIssue = 4;		
	}
	if (lowestSum > issue5Sum) {
		lowestSum = issue5Sum;
		lowestIssue = 5;
	}
	
	//Comparing for the highestSum
	if (highestSum < issue2Sum) {
		highestSum = issue2Sum;
		highestIssue = 2;
	}
	if (highestSum < issue3Sum) {
		highestSum = issue3Sum;
		highestIssue = 3;
	}
	if (highestSum < issue4Sum) {
		highestSum = issue4Sum;
		highestIssue = 4;
	}
	if (highestSum < issue5Sum) {
		highestSum = issue5Sum; 
		highestIssue = 5;
	}
	
	// Computes average after sum
	for (int i = 0; i < topicsTotal; i++) {
		avRating[i] = avRating[i] / surveyTakers;
		}

	
	// Creating the top column
	System.out.print("\n\nRating | ");
	for (int r = 1; r < ratings + 1; r++) {
		System.out.format("%4d | ", r);
	}
	System.out.print("Avg ");
	
	// loop over output[][] to print full list
	for (int r = 0; r < topicsTotal; r++) {
		System.out.print("\n-------------------------------------------------------------------------------------\n");
		System.out.print(topics[r] + " | ");		

		for (int c = 0; c < ratings; c++) {
			System.out.format("%4d | ", output[r][c]); 
		}
		System.out.print(avRating[r]); 	
	}
	
	//Issue comparison 
	System.out.printf("\n\nIssue%d ranked the highest with a score of %.2f", highestIssue, highestSum);
	System.out.printf("\nIssue%d ranked the highest with a score of %.2f", lowestIssue, lowestSum);
	
	scan.close();
	
	}
	
}
