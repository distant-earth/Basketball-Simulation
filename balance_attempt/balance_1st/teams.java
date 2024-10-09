public class teams {

	players players = new players();
	//creating teams
	Team Heat = new Team("Miami Heat", players.Hassan, players.Dragic, players.Winslow, players.Richardson,
			players.Johnson, players.dummy);
	Team Nuggets = new Team("Denver Nuggets", players.Mudiay, players.Jokic, players.Chandler, players.Nurkic,
			players.Murray, players.dummy);
	Team Cavs = new Team("Cleveland Cavs", players.LeBron, players.Kyrie, players.Love, players.Smith,
			players.Thompson, players.dummy);
	Team Warriors = new Team("GS Warriors", players.Curry, players.Durant, players.Klay, players.Green, players.Pachullia,
	        players.dummy);
	Team Clippers = new Team("LA Clippers", players.Paul, players.Griffin, players.Jordan, players.Reddick, players.Crawford,
			players.dummy);
	Team Raptors = new Team("Toronto Raptors", players.Derozan, players.Lowry, players.Valencunias, players.Carrol, players.Joseph,
			players.dummy);
	
	Team Heat2 = new Team("Miami Heat #2", players.Hassan2, players.Dragic2, players.Winslow2, players.Richardson2,
			players.Johnson2, players.Hassan2_extra);
	Team Nuggets2 = new Team("Denver Nuggets #2", players.Mudiay2, players.Jokic2, players.Chandler2, players.Nurkic2,
			players.Murray2, players.Mudiay2_extra);
	Team Cavs2 = new Team("Cleveland Cavs #2", players.LeBron2, players.Kyrie2, players.Love2, players.Smith2,
			players.Thompson2, players.LeBron2_extra);
	Team Warriors2 = new Team("GS Warriors #2", players.Curry2, players.Durant2, players.Klay2, players.Green2, players.Pachullia2,
			players.Curry2_extra);
	Team Clippers2 = new Team("LA Clippers #2", players.Paul2, players.Griffin2, players.Jordan2, players.Reddick2, players.Crawford2,
			players.Paul2_extra);
	Team Raptors2 = new Team("Toronto Raptors #2", players.Derozan2, players.Lowry2, players.Valencunias2, players.Carrol2, players.Joseph2,
			players.Derozan2_extra);
}

