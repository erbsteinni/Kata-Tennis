package test;

import org.junit.Test;

import junit.framework.TestCase;
import model.Duel;
import model.Player;
import model.Points;

public class DuelTest extends TestCase {
	
	@Test
	public final void testPlay1Point(){
		Player p1 = new Player("");
		Player p1Res = new Player("");
		Player p2 = new Player("");
		// Cas tieBreak
		// cas initial
		Duel duelTB = new Duel(p1,p2);
		duelTB.setTieBreak(true);
		p1Res.setTieBreak(1);
		Duel duelTBRes = new Duel(p1Res,p2);
		duelTBRes.setTieBreak(true);
		duelTB.play1Point();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		// cas fin break
		p1.setTieBreak(6);
		duelTB = new Duel(p1,p2);
		duelTB.setTieBreak(true);
		
		p1Res.setTieBreak(7);
		p1Res.setGame(1);
		duelTBRes = new Duel(p1Res,p2);
		duelTBRes.setTieBreak(true);
		duelTBRes.setFinish(true);
		duelTB.play1Point();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		//cas sans Tie Break
		// cas normal
		
		p1 = new Player("");
		p1Res = new Player("");
		
		p1Res.setPoints(Points.QUINZE);
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1Res,p2);
		
		duelTB.play1Point();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		// cas victoire sur Deuce
		
		p1 = new Player("");
		p1Res = new Player("");
		
		p1.setPoints(Points.DEUCE);
		p1Res.setPoints(Points.ZERO);
		p1Res.setGame(1);
		
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1Res,p2);
		
		duelTB.play1Point();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		
		// cas victoire d'un set
		
		p1 = new Player("");
		p1Res = new Player("");
		p2 = new Player("");
		
		p1.setPoints(Points.QUARANTE);
		p2.setPoints(Points.ZERO);
		p1Res.setPoints(Points.ZERO);
		p1Res.setGame(1);
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1Res,p2);
		
		duelTB.play1Point();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		// cas retour de deuce
		
		p1 = new Player("");
		p1Res = new Player("");
		Player p2Res = new Player("");
		p2 = new Player("");
		
		p1.setPoints(Points.QUARANTE);
		p2.setPoints(Points.DEUCE);
		p1Res.setPoints(Points.QUARANTE);
		p2Res.setPoints(Points.QUARANTE);
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1Res,p2Res);
		
		duelTB.play1Point();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		// cas va au deuce
		
		p1 = new Player("");
		p1Res = new Player("");
		p2Res = new Player("");
		p2 = new Player("");
		
		p1.setPoints(Points.QUARANTE);
		p2.setPoints(Points.QUARANTE);
		p1Res.setPoints(Points.DEUCE);
		p2Res.setPoints(Points.QUARANTE);
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1Res,p2Res);
		
		duelTB.play1Point();
		
		assertTrue(duelTB.equals(duelTBRes));
	}
	
	@Test
	public final void testPlay2Point(){
		Player p1 = new Player("");
		Player p2Res = new Player("");
		Player p2 = new Player("");
		// Cas tieBreak
		// cas initial
		Duel duelTB = new Duel(p1,p2);
		duelTB.setTieBreak(true);
		p2Res.setTieBreak(1);
		Duel duelTBRes = new Duel(p1,p2Res);
		duelTBRes.setTieBreak(true);
		duelTB.play2Point();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		// cas fin break
		p2.setTieBreak(6);
		duelTB = new Duel(p1,p2);
		duelTB.setTieBreak(true);
		
		p2Res.setTieBreak(7);
		p2Res.setGame(1);
		duelTBRes = new Duel(p1,p2Res);
		duelTBRes.setTieBreak(true);
		duelTBRes.setFinish(true);
		duelTB.play2Point();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		//cas sans Tie Break
		// cas normal
		
		p2 = new Player("");
		p2Res = new Player("");
		
		p2Res.setPoints(Points.QUINZE);
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1,p2Res);
		
		duelTB.play2Point();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		// cas victoire sur Deuce
		
		p2 = new Player("");
		p2Res = new Player("");
		
		p2.setPoints(Points.DEUCE);
		p2Res.setPoints(Points.ZERO);
		p2Res.setGame(1);
		
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1,p2Res);
		
		duelTB.play2Point();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		
		// cas victoire d'un set
		
		p1 = new Player("");
		p2Res = new Player("");
		p2 = new Player("");
		
		p2.setPoints(Points.QUARANTE);
		p1.setPoints(Points.ZERO);
		p2Res.setPoints(Points.ZERO);
		p2Res.setGame(1);
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1,p2Res);
		
		duelTB.play2Point();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		// cas retour de deuce
		
		p1 = new Player("");
		Player p1Res = new Player("");
		p2Res = new Player("");
		p2 = new Player("");
		
		p2.setPoints(Points.QUARANTE);
		p1.setPoints(Points.DEUCE);
		p2Res.setPoints(Points.QUARANTE);
		p1Res.setPoints(Points.QUARANTE);
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1Res,p2Res);
		
		duelTB.play2Point();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		// cas va au deuce
		
		p2 = new Player("");
		p2Res = new Player("");
		p1Res = new Player("");
		p1 = new Player("");
		
		p2.setPoints(Points.QUARANTE);
		p1.setPoints(Points.QUARANTE);
		p2Res.setPoints(Points.DEUCE);
		p1Res.setPoints(Points.QUARANTE);
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1Res,p2Res);
		
		duelTB.play2Point();
		
		assertTrue(duelTB.equals(duelTBRes));
		
	}
	
	@Test
	public final void testPlay1Game(){
		// cas fin classique
		
		Player p1 = new Player("");
		Player p1Res = new Player("");
		Player p2Res = new Player("");
		Player p2 = new Player("");
		
		p1.setGame(5);
		p2.setGame(0);
		p1Res.setGame(6);
		
		Duel duelTB = new Duel(p1,p2);
		Duel duelTBRes = new Duel(p1Res,p2);
		duelTBRes.setFinish(true);
		
		duelTB.play1Game();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		
		// cas vers tie break
		
		p1 = new Player("");
		p1Res = new Player("");
		p2Res = new Player("");
		p2 = new Player("");
		
		p1.setGame(5);
		p2.setGame(6);
		p1Res.setGame(6);
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1Res,p2);
		duelTBRes.setTieBreak(true);
		
		duelTB.play1Game();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		// cas égalité
		
		p1 = new Player("");
		p1Res = new Player("");
		p2Res = new Player("");
		p2 = new Player("");
		
		p1.setGame(5);
		p2.setGame(5);
		p1Res.setGame(6);
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1Res,p2);
		
		duelTB.play1Game();
		
		assertTrue(duelTB.equals(duelTBRes));
	}
	
	@Test
	public final void testPlay2Game(){
		// cas fin classique
		
		Player p2 = new Player("");
		Player p2Res = new Player("");
		Player p1Res = new Player("");
		Player p1 = new Player("");
		
		p2.setGame(5);
		p1.setGame(0);
		p2Res.setGame(6);
		
		Duel duelTB = new Duel(p1,p2);
		Duel duelTBRes = new Duel(p1,p2Res);
		duelTBRes.setFinish(true);
		
		duelTB.play2Game();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		
		// cas vers tie break
		
		p1 = new Player("");
		p1Res = new Player("");
		p2Res = new Player("");
		p2 = new Player("");
		
		p2.setGame(5);
		p1.setGame(6);
		p2Res.setGame(6);
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1,p2Res);
		duelTBRes.setTieBreak(true);
		
		duelTB.play2Game();
		
		assertTrue(duelTB.equals(duelTBRes));
		
		// cas égalité
		
		p1 = new Player("");
		p1Res = new Player("");
		p2Res = new Player("");
		p2 = new Player("");
		
		p2.setGame(5);
		p1.setGame(5);
		p2Res.setGame(6);
		
		duelTB = new Duel(p1,p2);
		duelTBRes = new Duel(p1,p2Res);
		
		duelTB.play2Game();
		
		assertTrue(duelTB.equals(duelTBRes));
	}
}
