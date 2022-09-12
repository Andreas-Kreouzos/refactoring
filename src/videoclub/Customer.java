package videoclub;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Customer {

	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		return reportHeader() + reportLineItems() + reportFooter();
	}

	private String reportHeader() {
		return String.format("videoclub.Rental Record for %s\n", getName());
	}

	private String reportLineItems() {
		String result = "";
		for (Rental rental : rentals) {
			result += reportLineItem(rental);
		}
		return result;
	}

	private String reportFooter() {
		return String.format("Amount owed is %s\nYou earned %s frequent renter points",
				calculateTotalAmount(),
				calculateFrequentRenterPoints());
	}

	private String reportLineItem(Rental rental) {
		return lineItem(rental);
	}
	
	private BigDecimal calculateTotalAmount() {
		double totalAmount = 0;
		for (Rental rental : rentals) {
			totalAmount += rental.calculateRentalAmount();
		}
		return BigDecimal.valueOf(totalAmount);
	}

	private int calculateFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental rental : rentals) {
			frequentRenterPoints += rental.calcFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}

	private String lineItem(Rental rental) {
		return "\t" + rental.getTitle() + "\t" + rental.calculateRentalAmount() + "\n";
	}

}
