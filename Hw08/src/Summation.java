	
//login(s): eu6 and tl5

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.InputMismatchException;
	import java.util.Scanner;

	public class Summation {
		
		public void main(){
		//adds together positive integers that the user enters until they enter the number 99.
			System.out.println("Welcome to the Summation Calculator!!!");
			Scanner in = new Scanner(System.in);
			int input;
			int sum = 0;
			int numberinput = 0;
			while (true) {
				System.out.println("Enter a number");
				System.out.print("  > ");
				try {
					input = in.nextInt();
					if (input == 99) {
					//print the sum of all of the numbers they entered (excluding the last 99)
					//and the average number they entered.
						System.out.print("The sum of the numbers you inputted is: ");
						System.out.println(sum);
						
						System.out.print("The average of the numbers you inputted is: ");
						System.out.println(sum/numberinput);
						break;
					}
					sum = sum + input;
					numberinput++;
				//If they ever enter a number that can’t be parsed as an int, this skips that 
				//number and doesn't include it in the sum or average 
				//(but prints an error message). 

				} catch(InputMismatchException exception){
					System.out.println("Error - please input an integer");
					break;
				}
				
			}
			System.out.println("Thank you for visiting the Pokemon Database!");
			}
	}

