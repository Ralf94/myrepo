package com.cgi.tennis;

// First class collections

public class Step5 implements TennisGame {

	private int p2;
	private int p1;
	private String p1N;
	private String p2N;

	public Step5(String p1N, String p2N) {
		this.p1N = p1N;
		this.p2N = p2N;
	}
	
	public String getScore() {
		Score score = new Score();
		Player player = new Player();
		if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
			return (p1 == p2) ? score.nameScore(p1) + "-All" : score.nameScore(p1) + "-" + score.nameScore(p2);
		}
		if (score.checkForDeuce(p1, p2))
			return "Deuce";

		if (score.checkForAdvantage(p1, p2))
			return "Advantage " + player.isLeader(p1, p2);

		if (score.checkForWinner(p1, p2))
			return "Win for " + player.isLeader(p1, p2);
		return null;
	}

	public void wonPoint(String playerName) {
		if (playerName == this.p1N)
			this.p1 += 1;
		if (playerName == this.p2N)
			this.p2 += 1;
	}

	public class Player {

		public String isLeader(int p1, int p2) {
			if (p1 > p2)
				return p1N;
			if (p1 < p2)
				return p2N;
			return null;
		}
	}
}
