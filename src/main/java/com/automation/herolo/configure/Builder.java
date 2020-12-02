package com.automation.herolo.configure;

import com.automation.herolo.pageObjects.LobbyPage;
import org.openqa.selenium.support.PageFactory;

public class Builder {

    public static DriverManager driverManager;
    public LobbyPage lobbyObjs;

    public Builder(){
        build();
    }
    private void build(){
         driverManager = new DriverManager();
         lobbyObjs = PageFactory.initElements(driverManager.driver,LobbyPage.class);
    }
}
