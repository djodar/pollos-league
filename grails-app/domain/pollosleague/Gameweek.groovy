package pollosleague

class Gameweek {

    static constraints = {
    }
	
	int gameweek
	
	/** List of JSONObject */
	def players = []

	@Override
	public String toString() {
		return "Gameweek [gameweek=" + gameweek + ", players=" + players + "]";
    }
		
}
