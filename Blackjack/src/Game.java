
import java.util.ArrayList;
import java.util.Scanner;
public class Game {

	private Deck d;
	private ArrayList<Person> people = new ArrayList<>();
	private Scanner sc;
	private Dealer dealer;

	public Game() {
		d = new Deck();
		sc = new Scanner(System.in);
		dealer = new Dealer(d);
		System.out.println("Oynamak isteyen herkesin ismini girin, durmak için * koyun");
		String name = sc.nextLine();

		while(!name.equals("*")) {
			people.add(new Person(d,name));
			name = sc.nextLine();
		}
	}

	public int newRound() {
		int pass = 0;
		System.out.println("Kartlarınız:");

		for(int i = 0; i < people.size(); i ++) {
			System.out.println(people.get(i).toString());
		}

		System.out.println(dealer.toString());

		int initSize = people.size() + 1;
		for(int i = 0; i < people.size(); i ++) {
			System.out.println(people.get(i).getName() + ", kart çekmek istiyor musun? (Evet/Hayir)");
			if(sc.nextLine().equals("Evet")){
				people.get(i).newCard(d);
				System.out.println(people.get(i).toString());
				if(people.get(i).returnTot() == -1) {
					System.out.println("BUSTED");
					people.remove(i);
					i --;
				}
			}
			else {
				pass ++;
			}
		}

		System.out.println(dealer.getName() + ", kart çekmek istiyor musun? (Evet/Hayir)");
		if(dealer.ShouldIGetNewCard(d)) {
			System.out.println("Evet");
			dealer.newCard(d);
			System.out.println(dealer.toString());
			if(dealer.returnTot() == -1) {
				System.out.println("BUSTED");
			}
		}
		else {
			System.out.println("Hayir");
			pass ++;
		}

		if(pass == initSize) {
			return(-1);
		}
		else {
			return(0);
		}
	}

	public String winnerIs() {
		int max = 0;
		Person highest = new Person(d,"");
		for(int i = 0; i < people.size(); i ++) {
			if(people.get(i).returnTot()>max) {
				max = people.get(i).returnTot();
				highest = people.get(i);
			}
		}
		if(dealer.returnTot()>max) {
			highest = dealer;
		}
		return(highest.getName());
	}
}