import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class game {

	static stats stats = new stats();
	players players = new players();

	public static void main(String[] args) {
		teams teams = new teams();
		Team t1 = null;
		Team t2 = null;
		String[] winners = new String[3];

		// Pick playoffs or one series
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		System.out.println("Simulating one game series...");

		// one series
		System.out.println("Team 1 (Cavs, Nuggets, Heat, Warriors, Raptors, Clippers): ");
		String team1 = kb.next().toLowerCase();
		if (team1.equals("cavs")) {
			t1 = teams.Cavs;
		}
		if (team1.equals("heat")) {
			t1 = teams.Heat;
		}
		if (team1.equals("nuggets")) {
			t1 = teams.Nuggets;
		}
		if (team1.equals("warriors")) {
			t1 = teams.Warriors;
		}
		if (team1.equals("raptors")) {
			t1 = teams.Raptors;
		}
		if (team1.equals("clippers")) {
			t1 = teams.Clippers;
		}
		System.out.println("Team 2 (Cavs, Nuggets, Heat, Warriors, Raptors, Clippers): ");
		String team2 = kb.next().toLowerCase();
		if (team2.equals("cavs")) {
			t2 = teams.Cavs2;
		}
		if (team2.equals("heat")) {
			t2 = teams.Heat2;
		}
		if (team2.equals("nuggets")) {
			t2 = teams.Nuggets2;
		}
		if (team2.equals("warriors")) {
			t2 = teams.Warriors2;
		}
		if (team2.equals("raptors")) {
			t2 = teams.Raptors2;
		}
		if (team2.equals("clippers")) {
			t2 = teams.Clippers2;
		}
		simulate(t1, t2);
	}
	

	//algorithm to simulate for one series
	public static void simulate(Team t1, Team t2){
		// N games are simulated
					boolean running = true;
					int t1Wins = 0;
					int t2Wins = 0;
					stats.clearStats(t1);
					stats.clearStats(t2);
					int N = 10000;
					for (int counter = 0; counter != N; ++counter) {
						running = true;
						int i = 0;
						// one game simulation
						while (i < 450 || t1.stats.score() == t2.stats.score) {
						int shooter = randInt(1, 100);
						int shot = randInt(1, 100);
						if (shooter < 31) {
							if (i % 2 == 0) {// team 1 shooting
								twoPoint(t1.p1, t2.p1, t1, shot);
								threePoint(t1.p1, t2.p1, t1, shot);
							} else {// team 2 shooting
								twoPoint(t2.p1, t1.p1, t2, shot);
								threePoint(t2.p1, t1.p1, t2, shot);
							}

							i++;
						}
						if (shooter > 30 && shooter < 51) {
							if (i % 2 == 0) {// team 1 shooting
								twoPoint(t1.p2, t2.p2, t1, shot);
								threePoint(t1.p2, t2.p2, t1, shot);
							} else {// team 2 shooting
								twoPoint(t2.p2, t1.p2, t2, shot);
								threePoint(t2.p2, t1.p2, t2, shot);
							}

							i++;
						}
						if (shooter > 50 && shooter < 69) {
							if (i % 2 == 0) {// team 1 shooting
								twoPoint(t1.p3, t2.p3, t1, shot);
								threePoint(t1.p3, t2.p3, t1, shot);
							} else {// team 2 shooting
								twoPoint(t2.p3, t1.p3, t2, shot);
								threePoint(t2.p3, t1.p3, t2, shot);
							}

							i++;
						}
						if (shooter > 68 && shooter < 86) {
							if (i % 2 == 0) {// team 1 shooting
								twoPoint(t1.p4, t2.p4, t1, shot);
								threePoint(t1.p4, t2.p4, t1, shot);
							} else {// team 2 shooting
								twoPoint(t2.p4, t1.p4, t2, shot);
								threePoint(t2.p4, t1.p4, t2, shot);
							}

							i++;
						}
						if (shooter > 85) {
							if (i % 2 == 0) {// team 1 shooting
								twoPoint(t1.p5, t2.p5, t1, shot);
								threePoint(t1.p5, t2.p5, t1, shot);
							} else {// team 2 shooting
								twoPoint(t2.p5, t1.p5, t2, shot);
								threePoint(t2.p5, t1.p5, t2, shot);
							}

							i++;
						}
					}

						if (t1.stats.score() > t2.stats.score()) {
							t1Wins++;
						} else if (t1.stats.score() < t2.stats.score()){
							t2Wins++;
						}

						// asks if you would like to see stats
						@SuppressWarnings("resource")
						Scanner kb = new Scanner(System.in);
						running = false;
						stats.clearStats(t2);
						stats.clearStats(t1);
					}
					System.out.println(t1.getName() + " wins: " + t1Wins);
					System.out.println(t2.getName() + " wins: " + t2Wins);		
	}
	// Displays stats for each player on selected team
	public static void playerStats(Team team) {
		System.out.println(team.p1.getName() + ": " + team.p1.stats.score() + " points (" + team.p1.stats.threes
				+ " three pointers)");
		System.out.println(team.p2.getName() + ": " + team.p2.stats.score() + " points (" + team.p2.stats.threes
				+ " three pointers)");
		System.out.println(team.p3.getName() + ": " + team.p3.stats.score() + " points (" + team.p3.stats.threes
				+ " three pointers)");
		System.out.println(team.p4.getName() + ": " + team.p4.stats.score() + " points (" + team.p4.stats.threes
				+ " three pointers)");
		System.out.println(team.p5.getName() + ": " + team.p5.stats.score() + " points (" + team.p5.stats.threes
				+ " three pointers)");
	}

	// odds of shooting and making a 2 point shot
	public static void twoPoint(Player offense, Player defense, Team team, int shot) {
		int chance = randInt(1, 100);
		int defence_quality = randInt(1, 100);
		if (shot < 85 && chance < offense.twoPt() && defence_quality > defense.defense()) {
			offense.stats.addScore(2);
			team.stats.addScore(2);
		}
	}

	// odds of shooting and making a 3 point shot
	public static void threePoint(Player offense, Player defense, Team team, int shot) {
		int chance = randInt(1, 100);
		int defence_quality = randInt(1, 100);
		if (shot >= 85 && chance < offense.threePt() && defence_quality > defense.defense()) {
			offense.stats.addScore(3);
			offense.stats.addThree(1);
			team.stats.addScore(3);
		}
	}
	

	// creates a random number
	public static int randInt(int min, int max) {
		Random rand = new Random();
		// note to self:
		// zero argument constructor uses the nanoTime to try to get a different seed every time 
		
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
}
