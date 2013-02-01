package pollosleague



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(TeamService)
class TeamServiceTests {

	final int DANI_TEAM_CODE = 673453
	
    void testGetTeamIds() {
        service.getTeamIds(24, DANI_TEAM_CODE)
    }
}
