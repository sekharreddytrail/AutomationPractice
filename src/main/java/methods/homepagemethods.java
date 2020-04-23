package methods;


import Utilities.util;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertTrue;

public class homepagemethods extends util {

    //repository for elements

    @FindBy(id = "searchInput")
    public WebElement searchtext;

    @FindBy(css = ".sprite.svg-search-icon")
    public WebElement searchbutton;

    @FindBy(id = "firstHeading")
    public WebElement HeaderText;

    @FindBy(id = "p-lang-label")
    public WebElement LanguageText;

    @FindBy(css = "li[class^='interlanguage-link'] a[class='interlanguage-link-target']")
    public List<WebElement> navigateToDesiredLanguage;

    @FindBy(xpath = "//div[@id='p-lang']//ul")
    public List<WebElement> verifyDesiredLanguage;


    public void enterSearchText(String searchelement) {


        waitforelementtoappear(searchtext);
        searchtext.sendKeys(searchelement);


    }


    public void clickSearchButton() {


        waitforelementtoappear(searchbutton);
        searchbutton.click();


    }


    public void verifyHeaderText(String verifyText) {


        waitforelementtoappear(HeaderText);
        assertThat(HeaderText.getText(), equalToIgnoringCase(verifyText));


    }

    public void verifyLanguage(String verifyText) {


        waitforelementtoappear(HeaderText);
        Assert.assertEquals(LanguageText.getText(), verifyText);


    }

    public void navigateToSearchLanguage(String SearchLanguage) throws InterruptedException {


        try {
            List<WebElement> li = navigateToDesiredLanguage;
            li.stream().filter(x -> x.getText().equals(SearchLanguage)).forEach(element -> element.click());
            Thread.sleep(1000);
        } catch (StaleElementReferenceException e) {

        }

    }


    public void verifySearchLanguagehasEnglish(String SearchLanguage) {


        // waitforelementtoappear(verifyDesiredLanguage);
        List<WebElement> li = verifyDesiredLanguage;
        Boolean AssertKeyword = li.stream().anyMatch(x -> x.getText().contains(SearchLanguage));
        assertTrue(AssertKeyword);

    }


}







