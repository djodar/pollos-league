package pollosleague

import org.codehaus.groovy.grails.web.json.JSONObject

class Gameweek {

    static constraints = {
    }
	
	int gameweek
	int code
	
	/** List of JSONObject */	
	String[] players
	@Override
	public String toString() {
		return "Gameweek [gameweek=" + gameweek + ", players=" + players + "]";
    }
		
}
