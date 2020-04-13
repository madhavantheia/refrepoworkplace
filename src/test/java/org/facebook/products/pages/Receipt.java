package org.facebook.products.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Receipt extends PageObject {

    @FindBy(tagName = "h1")
    private WebElement header;

    public Receipt(WebDriver driver) {
        super(driver);
    }

    public String confirmationHeader(){
        return header.getText();
    }
}
