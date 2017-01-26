package model;

public class Duel {
	private Player player1;
	private Player player2;
	private Player winner;
	private boolean finish;
	private boolean tieBreak;
	
	
	
	public Player getWinner() {
		return winner;
	}
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	public boolean isTieBreak() {
		return tieBreak;
	}
	public void setTieBreak(boolean tieBreak) {
		this.tieBreak = tieBreak;
	}
	public boolean isFinish() {
		return finish;
	}
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Duel(Player player1, Player player2) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.winner = new Player("");
		this.finish = false;
		this.tieBreak = false;
	}
	
	public Duel() {
	}
	
	public void initPoints(){
		player1.setPoints(Points.ZERO);
		player2.setPoints(Points.ZERO);
	}
	public void play1Point(){
		if(this.tieBreak){
			player1.incTieBreak();
			
			this.finish = (player1.getTieBreak() >= 7 && player1.getTieBreak() - player2.getTieBreak() > 1);
		
			if(this.finish){
				player1.incGame();
				this.winner = player1;
			}
			
		}
		else{
			if(player1.getPoints().getValue() < 3){
				player1.winPoint();
			}
			else if(player1.getPoints().getValue() == 4){
				play1Game();
			}
			else if(player1.getPoints().getValue() == 3){
				if(player2.getPoints().getValue() < 3){
					play1Game();
				}
				else if(player2.getPoints().getValue() == 4){
					player2.setPoints(Points.QUARANTE);
				}
				else if(player2.getPoints().getValue() == 3){
					player1.setPoints(Points.DEUCE);
				}
				
			}
		}
	}
	
	public void play1Game(){
		initPoints();
		player1.incGame();
		
		this.finish = DuelEnds();
	}
	
	public void play2Point(){
		if(this.tieBreak){
			player2.incTieBreak();
			
			this.finish = (player2.getTieBreak() >= 7 && player2.getTieBreak() - player1.getTieBreak() > 1);
		
			if(this.finish){
				player2.incGame();
				this.winner = player2;
			}
		}
		else{
			if(player2.getPoints().getValue() < 3){
				player2.winPoint();
			}
			else if(player2.getPoints().getValue() == 4){
				play2Game();
			}
			else if(player2.getPoints().getValue() == 3){
				if(player1.getPoints().getValue() < 3){
					play2Game();
				}
				else if(player1.getPoints().getValue() == 4){
					player1.setPoints(Points.QUARANTE);
				}
				else if(player1.getPoints().getValue() == 3){
					player2.setPoints(Points.DEUCE);
				}
				
			}
		}
		
	}
	
	public void play2Game(){
		initPoints();
		player2.incGame();
		
		this.finish = DuelEnds();
	}
	
	
	public boolean DuelEnds(){
		if(player1.getGame() >= 6){
			if(player2.getGame() < player1.getGame() - 1){
				this.winner = player1;
				return true;
			}
			else if(player2.getGame() >= 6){
				this.tieBreak = true;
				return false;
			}
			else{
				return false;
			}
		}
		else if(player2.getGame() >= 6){
			if(player1.getGame() < player2.getGame() - 1){
				this.winner = player2;
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public boolean equals(Duel d){
		
		
		boolean res =  (player1.equals(d.player1));
		res =  res && (player2.equals(d.player2));
		res =  res && (finish == d.finish);
		res =  res && (tieBreak == d.tieBreak);
		
		return  res;
	}
}
