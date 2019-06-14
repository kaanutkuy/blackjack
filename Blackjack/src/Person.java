import java.util.ArrayList;

public class Person {

	private ArrayList<Card> hand = new ArrayList<>();
	private String name;

	public Person(Deck d, String n) {
		name = n;
		hand.add(d.getNewCard());
		hand.add(d.getNewCard());
	}

	public boolean checkAce() {
		for(int i = 0; i < hand.size(); i ++) {
			if(hand.get(i).isAce()) {
				return(true);
			}
		}
		return(false);
	}

	public void newCard(Deck d) {
		hand.add(d.getNewCard());
	}

	public int returnTot() {
		int tot = 0;
		for(int i = 0; i < hand.size(); i++) {
			tot += hand.get(i).getPower();
		}
		if(tot > 21 && checkAce()) {
			if(tot - 10 <= 21) {
				tot -= 10;
			}
		}
		if(tot > 21) {
			return(-1);
		}
		else{
			return(tot);
		}
	}

	@Override
	public String toString() {
		return(name + ": " + hand.toString());
	}
	public String getName() {
		return(name);
	}
}
