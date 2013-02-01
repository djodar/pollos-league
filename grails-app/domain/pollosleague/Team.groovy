package pollosleague

class Team {

    static constraints = {
		code unique:true
    }
	
    static hasMany = [gameweeks: Gameweek]
    
	int code
	
	String name
	String manager
	
}
