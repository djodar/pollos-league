import pollosleague.Team

class BootStrap {

    def init = { servletContext ->
		if(!Team.count()){
			new Team(name: "Alburnos", manager: "Dani", code: "484503").save(failOnError: true)
		}	
    }
    def destroy = {
    }
}
