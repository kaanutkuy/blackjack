
public class Dealer extends Person{
	boolean busted = false;
	public Dealer(Deck d) {
		super(d, "Dealer");
	}
	public boolean ShouldIGetNewCard(Deck d){
		int difference = 21-returnTot();
		double probTrue = 0.0;
		for(int i = 0; i < d.getDeck().size(); i++) {
			if(d.getDeck().get(i).getPower()<=difference) {
				probTrue ++;
			}
		}
		probTrue = (probTrue/d.getDeck().size())*100;
		System.out.println(probTrue);
		if(probTrue > 50) {
			return(true);
		}
		else {
			return(false);
		}
	}

}