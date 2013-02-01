package pollosleague

import grails.converters.*

class TeamService {

	static transactional = false

	/**
	 * 	
	 * @param code
	 * @return
	 */
    Team getTeam(String code) {
		assert !code.isEmpty()
    }
	
	def bootstrap(){
		def team1 = new Team(name: "Alburnos", manager: "Dani", code: "484503")
		log.info("Adding teams to application scope ${TEAMS_CACHE_ATTR}")
		[484503: team1]		
	}
	
	Gameweek createGameweek(int gameweek){
		new Gameweek(gameweek: gameweek)
	}
	
	/**
	 * Parses HTML to obtain players numbers
	 * @return List of player identifiers
	 */
	String[] getTeamIds(int gameweek, int teamId){
		assert gameweek > 0
		 
		final String URL = "http://fantasy.premierleague.com/entry/${teamId}/event-history/${gameweek}"
		def playerIdentifiers = []
		def url = new URL(URL)
		def parser = new org.cyberneko.html.parsers.SAXParser()
		parser.setFeature('http://xml.org/sax/features/namespaces', false)
		def page = new XmlParser(parser).parse(URL)
		
//		url.withReader { reader ->
//			def parser = slurper.parse(reader);
////			tbody.@idismDataElements
//			def rows = parser.body.div[1].div[1].div.div.div.section.div.div[2].div.table.tbody.tr
//			assert 15 == rows.size()
//			 
//			rows.list().each { row ->
//				String playerId = row['@id'].toString()[7..-1]
//				playerIdentifiers.add(playerId)
//			}
//		}

		assert 15 == playerIdentifiers.size()
		return playerIdentifiers
	}
}
