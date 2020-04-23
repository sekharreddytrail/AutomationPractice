package StepDefinitions;

import Utilities.util;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jxl.read.biff.BiffException;
import methods.homepagemethods;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class homepagestepdefs extends util {

    //creating object for methods
    public homepagemethods homepage_method;

    //contructor initialising config file and homepage method
    public homepagestepdefs() throws IOException {

        intialise();
        homepage_method = PageFactory.initElements(open_browser(), homepagemethods.class);

    }



    @Before()
    public void firstbefore() {
        System.out.println("BEFORE STEP");

    }

    //quiting browser
    @After()
    public void firstafter() {
        quitbrowser();
    }

    //opening browser and navigating to website
    @Given("^Navigate to website$")
    public void navigateToWebsite() {
        gotowebsite();

    }

// SEARCH FOR STRING
    @When("^Search for (.*) in wikipedia$")
    public void searchForInWikipedia(String Searchstring) {
        homepage_method.enterSearchText(Searchstring);
        homepage_method.clickSearchButton();
    }

    //VERIFY FOR THE STRING ENTERED
    @Then("^Verify the search page heading is (.*)$")
    public void verifyTheSearchPageHeadingIs(String VerifyString) {
        homepage_method.verifyHeaderText(VerifyString);
    }

    //VERIFY FOR SEARCH FOR LANGUAGES

    @Then("^Verify search page for other (.*)$")
    public void verifySearchPageForOtherLanguages(String VerifyString) {
        homepage_method.verifyLanguage(VerifyString);
    }

    // NAVIGATE TO DIFFERENT LANGUAGE
    @When("^I navigate to different language (.*)$")
    public void iNavigateToDifferentLanguage(String desiredLanguage) throws InterruptedException {
        homepage_method.navigateToSearchLanguage(desiredLanguage);
    }

    // VERIFY ENGLISH WORD IN DIFFERENT LANGUGAGE
    @Then("^I verify search page of new language has (.*)$")
    public void iVerifySearchPageOfNewLanguageHasEnglish(String verifyLanguage) {
        homepage_method.verifySearchLanguagehasEnglish(verifyLanguage);
    }
}
