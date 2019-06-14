import java.util.ArrayList;

public class Deck {

	private ArrayList<Card> deck = new ArrayList<>();
	private static final ArrayList<Card> originalDeck = new ArrayList<>();
	String[] suits = {"kupa","karo","sinek","maca"};

	public Deck() {
		for(int suit = 0; suit < suits.length; suit ++) {
			for(int pow = 2; pow < 15; pow ++ ) {
				deck.add(new Card(suits[suit], pow));
				originalDeck.add(new Card(suits[suit], pow));
			}
		}
	}

	public Card getNewCard() {
		int r = (int) (Math.random()*deck.size());
		Card temp = deck.get(r);
		deck.remove(r);
		return temp;
	}

	@Override
	public String toString() {
		return deck.toString();
	}

	public void restore() {
		deck = new ArrayList<>();
		for(int i = 0; i < originalDeck.size(); i++) {
			deck.add(originalDeck.get(i));
		}
	}
	public ArrayList<Card> getDeck(){
		return(deck);
	}
}