package com.cgi.tennis;

// Don't use the ELSE-Keyword

public class Step3 implements TennisGame {

	private int p2;
	private int p1;
	private String p1N;
	private String p2N;

	public Step3 (String p1N, String p2N) {
		this.p1N = p1N;
		this.p2N = p2N;
	}

	public String getScore() {
		String s;
		if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
			String[] p = new String[] { "Love", "Fifteen", "Thirty", "Forty" };
			s = p[p1];
			return (p1 == p2) ? s + "-All" : s + "-" + p[p2];
		}
		if (p1 == p2)
			return "Deuce";
		s = p1 > p2 ? p1N : p2N;
		return ((p1 - p2) * (p1 - p2) == 1) ? "Advantage " + s : "Win for " + s;
	}

	public void wonPoint(String playerName) {
		if (playerName == this.p1N)
			this.p1 += 1;
		if (playerName == this.p2N)
			this.p2 += 1;
	}

}

