package pollosleague

import grails.converters.*

import org.codehaus.groovy.grails.web.json.JSONObject

class TeamService {

	static transactional = false
	
	final API_URL = "http://fantasy.premierleague.com/web/api/elements/"
	
	Gameweek createGameweek(int gameweek){
		Team.list().collect {it ->
			log.info("Gameweek: ${gameweek}, Team code: ${it.code}")
			
			def code = it.code	
			def players = []
			
			getTeamIds(gameweek, code).each {
				JSONObject player = getPlayer(it)
				log.info(player)
				players.add(player)
				
			}		
			
			def newGameweek = new Gameweek(gameweek: gameweek, code: code, players: players).save()
			it.gameweeks.add(newGameweek)
		}
	}
	
	/**
	 * Parses HTML to obtain players numbers
	 * @return List of player identifiers
	 */
	String[] getTeamIds(int gameweek, int teamId){
		assert gameweek > 0
		 
		final String URL = "http://fantasy.premierleague.com/entry/${teamId}/event-history/${gameweek}"
		def url = new URL(URL)
		def tagsoupParser = new org.ccil.cowan.tagsoup.Parser()
		def page = new XmlSlurper(tagsoupParser).parse(URL)
		
		def playerIdentifiers = page.body.div[2].div[0].div[0].div[0].section[0].div[2].div[2].div[0].table.tbody.tr.collect {
			it.@id.text().substring(7)
		}
		
		return playerIdentifiers
	}
	
	JSONObject getPlayer(String id) {
		log.info("Querying API for element " + id)
		def url = new URL(API_URL + id)
		return JSON.parse(url.newReader())
	}
}
