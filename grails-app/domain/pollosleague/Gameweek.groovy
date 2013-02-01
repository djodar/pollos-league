package pollosleague

class Gameweek {

    static constraints = {
    }
	
	int gameweek
	int code
	
	/** List of JSONObject */
	def players = []
	@Override
	public String toString() {
		return "Gameweek [gameweek=" + gameweek + ", players=" + players + "]";
    }
		
}
