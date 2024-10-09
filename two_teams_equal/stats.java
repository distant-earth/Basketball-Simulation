//a class for the various stats
public class stats {
	int threes, score;
	
	public void addScore(int add){
		score+=add;
	}
	public int score(){
		return score;
	}
	public void addThree(int add){
		threes+=add;
	}
	public int threes(){
		return threes;
	}
	//clears all stats so they dont stack when simulating another game
	public void clearStats(Team team) {
		 team.p1.stats.score=0;
		 team.p2.stats.score=0;
		 team.p3.stats.score=0;
		 team.p4.stats.score=0;
		 team.p5.stats.score=0;
		 team.p1.stats.threes=0;
		 team.p2.stats.threes=0;
		 team.p3.stats.threes=0;
		 team.p4.stats.threes=0;
		 team.p5.stats.threes=0;
		 team.stats.score=0;
		 team.stats.threes=0;
	}
	
}
