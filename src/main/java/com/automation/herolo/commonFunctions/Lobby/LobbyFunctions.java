package com.automation.herolo.commonFunctions.Lobby;

import com.automation.herolo.commonFunctions.General.BasicFunctions;
import com.automation.herolo.pageObjects.LobbyPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class LobbyFunctions extends BasicFunctions {

    public String errMsg = "";
    private LobbyPage pageObjs;
    private WebDriver driver;
    List<String>helpUHeaderList = Arrays.asList("מיקור חוץ לפיתוח Frontend ובודקי איכות","פרויקט Full Stack מקצה לקצה","ייעוץ ושדרוג ל–JavaScript");
    List<String>helpUDescList = Arrays.asList("אנחנו בונים צוותים המורכבים ממפתחי Full Stack, צד לקוח (React, Angular, Vue), בודקי איכות (ידני ואוטומציה) ומנהלי פרויקטים. בעזרתנו תוכלו להקים במהירות צוות טכנולוגי איכותי וממוקצע.","אנחנו בונים צוות המותאם לפי הצרכים שלכם ודואגים לתהליך הפיתוח מקצה לקצה. מנהלי הפרויקטים שלנו דואגים לנהל את הפרויקט בצורה הנכונה והאפקטיבית ביותר. עובדים בספרינטים ומתודולוגיות Agile.","אנחנו יכולים לשדרג לכם את האתר ו/או האפליקציה שלכם, לדאוג שתהיו מעודכנים עם הטכנולוגיות החדשות ביותר ולבחון את בסיס הקוד יחד איתכם.");
    List<String>answersForAllQuestionHeaderList = Arrays.asList("אנחנו זקוקים לחיזוק והרחבת צוות הפיתוח הקיים, האם זה משהו שאתם יכולים לעזור בו?","האם אתם מספקים רק שירותי פיתוח צד לקוח?", "האם יש לכם ניסיון עם חברות סטארטאפ?" ,"האם המפתחים שלכם עובדים ממקומות אחרים בעולם?","למה כדאי לי לעבוד דווקא איתכם?","איך נוכל להתקדם?");
    List<String>answersForAllQuestionDescList = Arrays.asList("בהחלט. צוות הפיתוח שלנו מונה עשרות מפתחים ובודקי איכות ואנחנו יודעים לעבוד מרחוק או ממשרדי הלקוח.","לא רק. הירולו היא חברת פיתוח מובילה המספקת שירותי פיתוח מקצה לקצה. יש לנו צוות גדול של מפתחים, מנהלי פרויקטים, בודקי איכות (ידני ואוטומציה), ארכיטקטים ומנהלי צוותים. אנחנו כאן לכל פרויקט שלכם." ,"מאז הקמת הירולו ב-2009, ליווינו עשרות חברות סטארטאפ עם פתרונות מיקור חוץ, פיתוח מרחוק או ייעוץ.","הירולו חרתה על דגלה להשאיר את ההייטק בארץ. כל עובדי החברה הם מנוסים, ממוקצעים ותוצרת כחול לבן.","בגלל הניסיון הרב, המוניטין ומתודולוגיית העבודה הייחודית שלנו. אנחנו עוזרים ללקוחותינו להוריד את עומס העבודה ובכך הם חוסכים לעצמם המון זמן וכסף. אנחנו עוזרים להבטיח עמידה בלוחות הזמנים של הפרויקט/המוצר ועוזרים בגיוס של מתכנתים ממוקצעים להרחבת הצוות הקיים.","תחילה, נתאם פגישת היכרות בה נכיר אחד את השני, נבין את הצרכים והיעדים שלכם ונוכל לפרט על תהליך העבודה הנכון ביותר להמשך התהליך.");
    List<String>emptyInputErrMsgList = Arrays.asList("שדה שם הוא שדה חובה","שדה חברה הוא שדה חובה","שדה אימייל הוא שדה חובה","שדה טלפון הוא שדה חובה");

    public LobbyFunctions(LobbyPage pageObjs, WebDriver driver){
        this.pageObjs = pageObjs;
        this.driver = driver;
    }
    public void checkValidTexts(){
        log.debug(" - - - - - - - - - - - - - - - - Start Test 'A_ValidLobbyTextsTest - - - - - - - - - - - - - - - -  \n'This Test goal is to Assure Present of All Expected Lobby page Texts.");
        errMsg += verifyElementVisibility(pageObjs.logoObj,driver);
        errMsg += verifyElementVisibility(pageObjs.headers.programYourLanguageHeader,driver);
        errMsg += verifyElementVisibility(pageObjs.headers.weRHeroloHeader,driver);
        errMsg += verifyElementVisibility(pageObjs.headers.weRHeroloDescObj,driver);
        errMsg += verifyElementVisibility(pageObjs.headers.helpUMainHeader,driver);

        if(pageObjs.headers.helpUHeaderList ==  null || pageObjs.headers.helpUHeaderList.size() < 3)
            errMsg+="Failure - fails to present'How Could we Help You?' header components Section\n";
       else {
            for (int i = 0; i < pageObjs.headers.helpUHeaderList.size(); i++) {
                if (pageObjs.headers.helpUHeaderList.get(i).getText().equals(helpUHeaderList.get(i)))
                    log.debug("PASS - The Text: "+helpUHeaderList.get(i)+" Present in element!");
                else
                    errMsg+="Failure - fails to show the Text: "+ helpUHeaderList.get(i)+"\n";
            }
        }
        if(pageObjs.texts.helpUDescList ==  null || pageObjs.texts.helpUDescList.size() < 3)
            errMsg+="Failure - fails to present'How Could we Help You?' text descriptions components Section\n";
        else {
            for (int i = 0; i < pageObjs.texts.helpUDescList.size(); i++) {
                if (pageObjs.texts.helpUDescList.get(i).getText().equals(helpUDescList.get(i)))
                    log.debug("PASS - The Text: "+helpUDescList.get(i)+" Present in element!");
                else
                    errMsg+="Failure - fails to show the Text: " + helpUDescList.get(i)+"\n";
            }
        }
        errMsg+=verifyElementVisibility(pageObjs.headers.exampleJobjsHeader,driver);
        errMsg+=verifyElementVisibility(pageObjs.headers.ourClientsHeader,driver);
        errMsg+=verifyElementVisibility(pageObjs.headers.answersForAllQuestionsMainHeader,driver);
        if(pageObjs.headers.answersForAllQuestionsSectionHeaderList ==  null || pageObjs.headers.answersForAllQuestionsSectionHeaderList.size() < 6)
            errMsg+="Failure - fails to present'How Could we Help You?' text descriptions components Section\n";
        else {
            for (int i = 0; i < pageObjs.headers.answersForAllQuestionsSectionHeaderList.size(); i++) {
                if (pageObjs.headers.answersForAllQuestionsSectionHeaderList.get(i).getText().equals(answersForAllQuestionHeaderList.get(i)))
                    log.debug("PASS - The Text: "+answersForAllQuestionHeaderList.get(i)+" Present in element!");
                else
                    errMsg+="Failure - fails to show the Text: "+ answersForAllQuestionHeaderList.get(i)+"\n";
            }
        }

        if(pageObjs.texts.answersForAllQuestionsSectionDescList ==  null || pageObjs.texts.answersForAllQuestionsSectionDescList.size() < 6)
            errMsg+="Failure - fails to present'How Could we Help You?' text descriptions components Section\n";
        else {
            for (int i = 0; i < pageObjs.texts.answersForAllQuestionsSectionDescList.size(); i++) {
                if (pageObjs.texts.answersForAllQuestionsSectionDescList.get(i).getText().equals(answersForAllQuestionDescList.get(i)))
                    log.debug("PASS - The Text: "+answersForAllQuestionDescList.get(i)+" Present in element!");
                else
                    errMsg+="Failure - fails to show the Text: " + answersForAllQuestionDescList.get(i)+"\n";
            }
        }
        errMsg+=verifyElementVisibility(pageObjs.headers.hearMoreHeader,driver);
        errMsg+=verifyElementVisibility(pageObjs.texts.hearMoreDesc1,driver);
        errMsg+=verifyElementVisibility(pageObjs.texts.hearMoreDesc2,driver);
    }

    public void emptyContactInputTest() {
        int i;
        log.debug(" - - - - - - - - - - - - - - - - Start Test 'B_EmptyInputContactTxtBoxTest - - - - - - - - - - - - - - - -  \n'This Test goal is to Assure that Empty input setting in contact text boxes triggers compilable error messages on screen.");
        Actions actions = new Actions(driver);
        actions.moveToElement(pageObjs.buttons.callUsBtn);
        actions.perform();
        //check present of popup
        checkAndCLosePopup(pageObjs.buttons.closePopupBtn,driver);
        clickElement(pageObjs.buttons.callUsBtn,driver);
        try {
            Thread.sleep(1500);
        }catch (InterruptedException e){
            log.error(e.getMessage());
        }
        if(pageObjs.texts.contactErrMsgList == null )
            Assert.fail("Failure - There is No any Error Message after fill in text boxes with Empty values!");
        //check present of popup
        checkAndCLosePopup(pageObjs.buttons.closePopupBtn,driver);
        for(i = 0; i < pageObjs.texts.contactErrMsgList.size(); i++) {
            errMsg += verifyElementText(pageObjs.texts.contactErrMsgList.get(i), emptyInputErrMsgList.get(i),driver);
        }
        //check if all 4 err msg were triggered
        while (i < emptyInputErrMsgList.size()) {
            errMsg += "Failure - The Error Message: " + emptyInputErrMsgList.get(i) + " Has NOT displayed on screen!\n";
            i++;
        }
    }
}


