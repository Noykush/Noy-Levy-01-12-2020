package com.automation.herolo.pageObjects;

import com.automation.herolo.configure.Builder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LobbyPage {

    public Headers headers = new Headers();
    public Texts texts = new Texts();
    public TxtBoxes txtBoxes = new TxtBoxes();
    public Buttons buttons = new Buttons();

    public class Headers{
        @FindBy(xpath = "//h2[@class='logo__Text-tdfmt3-3 kTdOgs']")
        public WebElement programYourLanguageHeader;

        @FindBy(xpath = "//h2[@class='typography__Title-sc-2ylieu-1 typography__MobileTitle-sc-2ylieu-3 bZqNWv']")
        public WebElement weRHeroloHeader;

        @FindBy(xpath = "//div[@class='introduction__TextContainer-sc-1bvkpmv-1 nYkQA']")
        public WebElement weRHeroloDescObj;

        @FindBy(xpath = "//h2[@class='typography__Title-sc-2ylieu-1 hFnTIP' ]/span[text()='איך נוכל לעזור לכם?']")
        public WebElement helpUMainHeader;

        @FindBy(xpath = "//h2/span[text()='עבודות לדוגמה']")
        public WebElement exampleJobjsHeader;

        @FindBy(xpath = "//h2/span[text()='כמה מהלקוחות שלנו']")
        public WebElement ourClientsHeader;

        @FindBy(xpath = "//h2/span[text()='לכל שאלה תשובה']")
        public WebElement answersForAllQuestionsMainHeader;

        @FindBy(xpath = "//h2/span[text()='רוצים לשמוע עוד?']")
        public WebElement hearMoreHeader;
        @FindBy(xpath = "//div[@class='serviceCard__Card-sc-2g56at-0 hNxzDJ']//h3")
        public List<WebElement> helpUHeaderList;


        @FindBy(xpath = "//section[@class='questionCard__QuestionCard-t08gdg-0 JaKvb']/h4")
        public List<WebElement >answersForAllQuestionsSectionHeaderList;
        public Headers(){
            PageFactory.initElements(Builder.driverManager.driver,this);
        }
    }


    public class Texts {

        @FindBy(xpath ="//div[@class='serviceCard__Card-sc-2g56at-0 hNxzDJ']//p")
        public List<WebElement> helpUDescList;

        @FindBy(xpath = "//section[@class='questionCard__QuestionCard-t08gdg-0 JaKvb']/p")
        public List<WebElement >answersForAllQuestionsSectionDescList;

        @FindBy(xpath = "//p/span[text()='צרו קשר או השאירו לנו פרטים ונשמח לחזור אליכם.']")
        public WebElement hearMoreDesc1;

        @FindBy(xpath = "//p/span[text()='יחד נבנה את הפתרון המתאים למוצר שלכם.']")
        public WebElement hearMoreDesc2;

        @FindBy(xpath = "//span[@class='commun__ErrorText-zi6nvq-6 bDkbFh']")
        public List<WebElement> contactErrMsgList;

        @FindBy(xpath = "//span[text()='שדה שם הוא שדה חובה']")
        public WebElement nameContactErrMsg;

        @FindBy(xpath = "//span[text()='שדה חברה הוא שדה חובה']")
        public WebElement companyContactErrMsg;

        @FindBy(xpath = "//span[text()='שדה אימייל הוא שדה חובה']")
        public WebElement emailContactErrMsg;

        @FindBy(xpath = "//span[text()='שדה טלפון הוא שדה חובה']")
        public WebElement phoneContactErrMsg;

        public Texts(){
            PageFactory.initElements(Builder.driverManager.driver,this);
        }
    }

    public class TxtBoxes {
        @FindBy(xpath = "//input[@id='name']")
        public WebElement nameContactInput;

        @FindBy(xpath = "//input[@id='email']")
        public WebElement emailContactInput;

        @FindBy(xpath = "//input[@id='company']")
        public WebElement companyContactInput;

        @FindBy(xpath = "//input[@id='telephone']")
        public WebElement phoneContactInput;

        public TxtBoxes(){
            PageFactory.initElements(Builder.driverManager.driver,this);
        }
    }

    public class Buttons {
        @FindBy(xpath = "//a/span[text()='דברו איתנו']")
        public WebElement callUsBtn;

        @FindBy(xpath = "//span[@class='onUnloadPopup__CloseModalBtn-v34ylr-1 gFThxT' and text()='+']")
        public WebElement closePopupBtn;

        public Buttons(){
            PageFactory.initElements(Builder.driverManager.driver,this);
        }
    }

    @FindBy(xpath = "//div[@id='logom']")
    public WebElement logoObj;
}
