import java.util.*;

/**
 *   File Name: methodtest.java<br>
 *
 *   Cui, Nicolas<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Mar 28, 2016
 *
 */
/**
 * methodtest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Cui, Nicolas
 * @version 1.0.0
 * @since 1.0
 */
public class methodtest {

	static double principle, interest, termInMonths;

	static String propertyID, username;

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		welcomeUserToApp();
		do {
			requestUserInformation();
			calculatePaymentInfo();
			returnInfo();
			System.out.println("Would you like to calculate another mortgage?");
		} while (requestToContinue());
		exit();
	}

	private static void calculatePaymentInfo() {
		// Calculate the payments based on the formula below
		// double monthlyPayment = (principle * interest) / (1 - Math.pow(1 +
		// interest, -termInMonths));
		double monthlyPayment = Math.round((principle * interest) / (1 - Math.pow(1 + interest, -termInMonths)) * 100)
				/ 100;
		// Show user the monthly payment amount
		System.out.println("The monthly payment is: " + monthlyPayment);
	}

	private static void exit() {
		// Echo a farewell message to the user.
		System.out.println("Goodbye " + username + " thank you for using the Home Mortgage Calculator!");
		scanner.close();
		// Exit the application.
		System.exit(0);
	}

	private static boolean requestToContinue() {
		while (true) {
			// Ask the user if they would like to find out the mortgage of
			// another home and if not, exit.
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("No") || input.equalsIgnoreCase("N"))
				return false;
			else if (input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("Y"))
				return true;
			else {
				System.out.println("Invalid option (" + input + "), please use Yes/Y or No/n");
			}
		}
	}

	private static void requestUserInformation() {
		String input;
		System.out.print("What is your Property ID? ");
		propertyID = scanner.nextLine();
		System.out.print("what is " + propertyID + "'s principle: ");
		input = scanner.nextLine();
		principle = Double.parseDouble(input);
		System.out.print("what is " + propertyID + "'s interest: ");
		input = scanner.nextLine();
		interest = Double.parseDouble(input);
		System.out.print("what is " + propertyID + "'s term in months: ");
		input = scanner.nextLine();
		termInMonths = Double.parseDouble(input);
	}

	private static void returnInfo() {
		double years, months;
		String monthstr, yearstr;
		months = termInMonths % 12;
		if (months == 1)
			monthstr = "month";
		else
			monthstr = "months";
		years = Math.floor(termInMonths / 12);
		if (years == 1)
			yearstr = "year";
		else
			yearstr = "years";
		if (termInMonths == 0) {
			System.out.println("You don't need to pay for any months!");
		} else if (termInMonths < 12) {
			System.out.println("You need to pay monthly for " + Math.floor(termInMonths % 12) + " " + monthstr
					+ "\n\t for the PropertyID: " + propertyID);
		} else if (years < 2 && months == 0) {
			System.out.println("You need to pay monthly for 1 year"
					+ "\n\t for the PropertyID: " + propertyID);
		} else if (years < 2) {
			System.out.println("You need to pay monthly for 1 year and " + Math.floor(months) + " " + monthstr
					+ " \n\t for the PropertyID: " + propertyID);
		} else if (months == 0) {
			System.out.println("You need to pay monthly for " + Math.floor(years)
					+ " years\n\t for the PropertyID: " + propertyID);
		} else {
			System.out.println("You need to pay monthly for " + Math.floor(years) + " " + yearstr + " and " + Math
					.floor(months)
					+ " " + monthstr
					+ " \n\t for the PropertyID: " + propertyID);
		}
	}

	private static void welcomeUserToApp() {
		System.out.println("Welcome to NC Home Mortgage Calculator App :D");
		System.out.print("Hello, could I please get your name?");
		username = scanner.nextLine();
	}
}
