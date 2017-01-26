package rest;

import model.Player;

public class PlayerResponse {
	private Player p1;
	private Player p2;
	private int pointTo;
	
	
	public PlayerResponse(Player p1, Player p2, int pointTo) {
		this.p1 = p1;
		this.p2 = p2;
		this.pointTo = pointTo;
	}
	
	public PlayerResponse() {
	}
	
	public Player getP1() {
		return p1;
	}
	public void setP1(Player p1) {
		this.p1 = p1;
	}
	public Player getP2() {
		return p2;
	}
	public void setP2(Player p2) {
		this.p2 = p2;
	}
	public int getPointTo() {
		return pointTo;
	}
	public void setPointTo(int pointTo) {
		this.pointTo = pointTo;
	}
	
	
}
