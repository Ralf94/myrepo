package com.cgi.tennis;

public class Score {
	
	public static final String[] p = { "Love", "Fifteen", "Thirty", "Forty" };

	public String nameScore(int points) {
		return p[points];
	}
	
	public boolean checkEqualUnderDeuce(int pointsPlayer1, int pointsPlayer2) {
		return ((pointsPlayer1 & pointsPlayer2) < 3) && pointsPlayer1 == pointsPlayer2;
	}
	
	public boolean checkForDeuce(int pointsPlayer1, int pointsPlayer2) {
		return ((pointsPlayer1 & pointsPlayer2) >= 3) && pointsPlayer1 == pointsPlayer2;
	}
	
	public boolean checkForAdvantage(int pointsPlayer1, int pointsPlayer2) {
		return (pointsPlayer1 > 3 && pointsPlayer1 == pointsPlayer2 + 1) |
			   (pointsPlayer2 > 3 && pointsPlayer2 == pointsPlayer1 + 1);
	}

	public boolean checkForWinner(int pointsPlayer1, int pointsPlayer2) {
		return (pointsPlayer1 > 3 && pointsPlayer1 >= pointsPlayer2 + 2) | 
			   (pointsPlayer2 > 3 && pointsPlayer2 >= pointsPlayer1 + 2);
	}
}
