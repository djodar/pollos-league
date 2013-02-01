package pollosleague

import java.awt.ModalEventFilter.ApplicationModalEventFilter;

class TeamController {

	static final String TEAMS_CACHE_ATTR = "teamsCache"
	
	static scaffold = true
	
	def teamService
	
	def populate() {
		assert params.id != null
		String gameweek = params.id
		Gameweek gw = teamService.createGameweek(gameweek.toInteger())
		render "Gameweek populated successfully: ${gameweek}"
	}
	
}
