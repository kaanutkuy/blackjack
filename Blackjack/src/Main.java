
public class Main {
	public static void main(String[] args) {
		Game g = new Game();
		g.newRound();
		while(g.newRound() != -1) {
			System.out.println("\n");
			g.newRound();
		}
		System.out.println("Ve kazanan... : " + g.winnerIs());
	}
}