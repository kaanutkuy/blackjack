
public class Card {
	private String suit;
	private String value;
	private int power;

	public Card(String suit, int power) {
		this.suit = suit;

		if (power == 14) {
			value = "A";
			this.power = 11;
		}

		else if (power == 13) {
			value = "K";
			this.power = 10;
		}

		else if (power == 12) {
			value = "Q";
			this.power = 10;
		}

		else if (power == 11) {
			value = "J";
			this.power = 10;
		}

		else {
			value = "" + power;
			this.power = power;
		}
	}
	@Override
	public String toString() {
		return suit + " " + value;
	}

	public int getPower() {
		return power;
	}

	public boolean isAce(){
		return(value.equals("A"));
	}
}