package pollosleague

import java.awt.ModalEventFilter.ApplicationModalEventFilter;

class TeamController {

	static final String TEAMS_CACHE_ATTR = "teamsCache"
	
	def teamService
	
    def show(){
		assert params.id != null
		
		String code = params.id
		log.info "Show team ${code}"
		
		def team = getTeam(code)
		
		request.model = team
		render view: "show"
	}
	
	Team getTeam(String code) {
		assert !code.isEmpty()
		servletContext.getAttribute(TEAMS_CACHE_ATTR).get(code.toInteger())
	}
	
	def populate() {
		assert params.id != null
		String gameweek = params.id
		Gameweek gw = teamService.createGameweek(gameweek.toInteger())
		render "Gameweek populated successfully: ${gw}"
	}
	
	def bootstrap(){
		log.info("Adding teams to application scope ${TEAMS_CACHE_ATTR}")
		servletContext.setAttribute(TEAMS_CACHE_ATTR, teamService.bootstrap())
		render "1 team populated"
	}
	
}
