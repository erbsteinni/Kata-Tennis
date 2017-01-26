package model;

public class Player {
	private String name;
	private Points points;
	private int game;
	private int tieBreak;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Points getPoints() {
		return points;
	}
	public void setPoints(Points points) {
		this.points = points;
	}
	
	public int getGame() {
		return game;
	}
	public void setGame(int game) {
		this.game = game;
	}
	
	public int getTieBreak() {
		return tieBreak;
	}
	public void setTieBreak(int tieBreak) {
		this.tieBreak = tieBreak;
	}
	public Player(String name) {
		super();
		this.name = name;
		this.points = Points.ZERO;
		this.game = 0;
		this.tieBreak = 0;
	}
	public Player(String name, Points points, int game, int tieBreak) {
		this.name = name;
		this.points = points;
		this.game = game;
		this.tieBreak = tieBreak;
	}
	
	public Player() {
	}
	
	
	
	
	public void winPoint(){
		this.points = this.points.next();
	}
	
	public void incGame(){
		this.game++;
	}
	
	public void incTieBreak(){
		this.tieBreak++;
	}
	
	public boolean equals(Player p){
		
		boolean res =  (points.getValue() == p.points.getValue());
		res =  res && (game == p.game);
		res =  res && (tieBreak == p.tieBreak);
		
		return  res;
	}
	
	
}
