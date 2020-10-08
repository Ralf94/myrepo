package com.cgi.tennis;

// One dot per line

public class Step6 implements TennisGame {

	private int p2;
	private int p1;
	private String p1N;
	private String p2N;

	public Step6(String p1N, String p2N) {
		this.p1N = p1N;
		this.p2N = p2N;
	}

	public String getScore() {
		Score score = new Score();
		Player player = new Player();
		if (score.checkEqualUnderDeuce(p1, p2))
			return score.nameScore(p1) + "-All";
		if (p1 == p2)
			return "Deuce";
		if (score.checkForAdvantage(p1, p2))
			return "Advantage " + player.isLeader(p1, p2);
		if (score.checkForWinner(p1, p2))
			return "Win for " + player.isLeader(p1, p2);
		return score.nameScore(p1) + "-" + 
			   score.nameScore(p2);
	}

	public void wonPoint(String playerName) {
		if (playerName == this.p1N)
			this.p1 += 1;
		if (playerName == this.p2N)
			this.p2 += 1;
	}

	public class Player {

		public String isLeader(int p1, int p2) {
			return (p1 > p2) ? p1N : p2N;
		}
	}
}
