package com.cgi.tennis;

// No getters/setters/properties

public class Step10 implements TennisGame {

	private int pointsPlayer1;
	private int pointsPlayer2;
	private String namePlayer1;
	private String namePlayer2;
	Player player = new Player();

	public Step10(String namePlayer1, String namePlayer2) {
		this.namePlayer1 = namePlayer1;
		this.namePlayer2 = namePlayer2;
	}

	public String getScore() {
		Score score = new Score();
		if (score.checkEqualUnderDeuce(pointsPlayer1, pointsPlayer2))
			return score.nameScore(pointsPlayer1) + "-All";
		if (score.checkForDeuce(pointsPlayer1, pointsPlayer2))
			return "Deuce";
		if (score.checkForAdvantage(pointsPlayer1, pointsPlayer2))
			return "Advantage " + player.isLeader(pointsPlayer1, pointsPlayer2);
		if (score.checkForWinner(pointsPlayer1, pointsPlayer2))
			return "Win for " + player.isLeader(pointsPlayer1, pointsPlayer2);
		return score.nameScore(pointsPlayer1) + "-" + 
			   score.nameScore(pointsPlayer2);
	}

	public void wonPoint(String playerName) {
		player.addPoint(playerName);
	}

	public class Player {

		public String isLeader(int pointsPlayer1, int pointsPlayer2) {
			return (pointsPlayer1 > pointsPlayer2) ? 
					namePlayer1 : namePlayer2;
		}

		public void addPoint(String playerName) {
			if (playerName == namePlayer1)
				pointsPlayer1 += 1;
			if (playerName == namePlayer2)
				pointsPlayer2 += 1;
		}
	}
}