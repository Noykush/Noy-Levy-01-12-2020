package HeroloTests;

import com.automation.herolo.configure.Builder;
import com.automation.herolo.commonFunctions.Lobby.LobbyFunctions;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LobbyTests {
    LobbyFunctions lobbyFunctions;
    Builder builder;

    @BeforeClass
    public void setup() {
        builder = new Builder();
        lobbyFunctions = new LobbyFunctions(builder.lobbyObjs,builder.driverManager.driver);
    }

    @Test
    public void validLobbyTextsTest() {
        builder.loginManager.login(builder.driverManager.driver, builder.lobbyObjs.logoObj);
        lobbyFunctions.checkValidTexts();
       Assert.assertEquals(lobbyFunctions.errMsg, "",lobbyFunctions.errMsg);
    }

    @Test
    public void invalidTxtBoxInput() {

    }
    @AfterTest
    public void finishTest(){
        builder.driverManager.driver.close();
    }
}
