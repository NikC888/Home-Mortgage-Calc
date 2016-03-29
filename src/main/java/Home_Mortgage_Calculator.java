import java.util.*;

/**
 * File Name: Home_Mortgage_Calculator.java<br>
 * Cui, Nicolas<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Mar 28, 2016
 */
/**
 * Home_Mortgage_Calculator //ADDD (description of class)
 * Welcome the user to the application.
 * Ask the user what the property ID is.
 * Ask the user what the principle is (ex: 200000), the interest (ex: .0575),
 * and term in months (360).
 * Calculate the payments based on the formula below:
 * double monthlyPayment = (principle * interest) / (1 - Math.pow( 1 + interest,
 * -termInMonths));
 * Let the user know what the payments would be each month, for how many years
 * and months for what property. Not just total months based on supplied term
 * (Must use modulus operator).
 * Ask the user if they would like to find out the mortgage of another home and
 * if not, exit.
 * Echo a farewell message to the user.
 * Exit the application.
 * NOTE:
 * To compare Strings you must use equals method or equalsIgnoreCase(). For
 * example:
 * if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {... pg
 * 70, Java24Hrs
 *
 * @author Cui, Nicolas
 * @version 1.0.0
 * @since 1.0
 */
public class Home_Mortgage_Calculator {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// declare local vars
		String propertyID, input = "";
		String principlestr, intereststr, termstr, monthstr, yearstr;
		double principle, interest, term, years, months;
		// ask use for property id
		while (!input.equals("quit") && !input.equals("q")) {
			System.out.println("What is your Property ID?");
			propertyID = scanner.nextLine();
			// ask user for principle(ex: 200000)
			System.out.println("What is your Principle?");
			principlestr = scanner.nextLine();
			principle = Double.parseDouble(principlestr);
			// ask use for ,interest (ex: .0575)
			System.out.println("What is your Interest?");
			intereststr = scanner.nextLine();
			interest = Double.parseDouble(intereststr);
			// ask user for term in months (ex: 360).
			System.out.println("What is your Term in months?");
			termstr = scanner.nextLine();
			term = Double.parseDouble(termstr);
			// Calculate the payments based on the formula below:
			double monthlyPayment = (principle * interest) / (1 - Math.pow(1 + interest, -term));
			// Show user the monthly payment amount
			System.out.println("The monthly payment is: " + monthlyPayment);
			// show user for how many years/months they need to pay for the
			// property ID
			months = term % 12;
			if (months == 1)
				monthstr = "month";
			else
				monthstr = "months";
			years = Math.floor(term / 12);
			if (years == 1)
				yearstr = "year";
			else
				yearstr = "years";
			if (term == 0) {
				System.out.println("You don't need to pay for any months!");
			} else if (term < 12) {
				System.out.println("You need to pay monthly for " + (int) months + " " + monthstr
						+ "\n\t for the PropertyID: " + propertyID);
			} else if (years < 2 && months == 0) {
				System.out.println("You need to pay monthly for 1 year"
						+ "\n\t for the PropertyID: " + propertyID);
			} else if (years < 2) {
				System.out.println("You need to pay monthly for 1 year and " + (int) months + " " + monthstr
						+ " \n\t for the PropertyID: " + propertyID);
			} else if (months == 0) {
				System.out.println("You need to pay monthly for " + (int) years
						+ " years\n\t for the PropertyID: " + propertyID);
			} else {
				System.out.println("You need to pay monthly for " + (int) years + " " + yearstr + " and " + (int) months
						+ " " + monthstr
						+ " \n\t for the PropertyID: " + propertyID);
			}
			// Ask the user if they would like to find out the mortgage of
			// another home and if not, exit.
			System.out.println(
					"Would you like to find out the mortgage of another home? (type anything and enter to continue)"
							+ "\nIf not type \"quit\" or \"q\" to exit");
			input = scanner.nextLine();
		}
		// Echo a farewell message to the user.
		System.out.println("Thank you for using the Home Mortgage Calculator!");
		// Exit the application.
		System.exit(0);
	}
}
