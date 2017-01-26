	package rest;

	import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Duel;
import model.Player;
import model.Points;

	@Path("/player")
public class DataRestService {



		@GET
		@Path("/get")
		@Produces("application/json")
		public ArrayList<Player> getPlayer() {

			Player p1 = new Player("Beb", Points.ZERO, 0,0);
			Player p2 = new Player("Steeve", Points.ZERO, 0,0);
			
			ArrayList<Player> players = new ArrayList<Player>();

			players.add(p1);
			players.add(p2);
			return players;

		}
		
	    @POST
	    @Path("/init")
	    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    public Duel init(String[] name) {
	    	
			Player player1 = new Player(name[0]);
			Player player2 = new Player(name[1]);
			
			Duel duel = new Duel(player1, player2);
			
			return duel;
	    }
	    
	    @POST
	    @Path("/game/1")
	    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    public Duel win1(Duel duel) {
	    	
			duel.play1Point();
			
			return duel;
	    }
	    
	    @POST
	    @Path("/game/2")
	    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    public Duel win2(Duel duel) {
	    	
			duel.play2Point();
			
			return duel;
	    }
	    
	    @POST
	    @Path("/save")
	    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    public PlayerResponse saveTest(PlayerResponse playerResponse) {
	    	
	        return playerResponse;
	    }
}
