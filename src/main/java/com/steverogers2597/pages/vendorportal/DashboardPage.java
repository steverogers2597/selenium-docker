package com.steverogers2597.pages.vendorportal;

import com.steverogers2597.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends AbstractPage {

    public static final Logger log = LoggerFactory.getLogger(DashboardPage.class);

    @FindBy(id = "monthly-earning")
    private WebElement monthlyEarningElement;

    @FindBy(id = "annual-earning")
    private WebElement annualEarningElement;

    @FindBy(id = "profit-margin")
    private WebElement profitMarginElement;

    @FindBy(id = "available-inventory")
    private WebElement availableInventoryElement;

    @FindBy(xpath = "//div[@id='dataTable_filter']//input")
    private WebElement searchBoxElement;

    @FindBy(id = "dataTable_info")
    private WebElement searchResultsCountElement;

    @FindBy(xpath = "//img[@class = 'img-profile rounded-circle']")
    private WebElement profileImageElement;

    @FindBy(linkText = "Logout")
    private WebElement logoutButtonElement;

    @FindBy(css = "#logoutModal a")
    private WebElement modalLogoutElement;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.monthlyEarningElement));
        return this.monthlyEarningElement.isDisplayed();
    }

    public String getMonthlyEarning() {
        return this.monthlyEarningElement.getText();
    }

    public String getAnnualEarning() {
        return this.annualEarningElement.getText();
    }

    public String getProfitMargin() {
        return this.profitMarginElement.getText();
    }

    public String getAvailableInventory() {
        return this.availableInventoryElement.getText();
    }

    public void searchOrderHistoryBy(String keyword){
        this.searchBoxElement.sendKeys(keyword);
    }

    /*
    Showing 1 to 10 of 32 entries (filtered from 99 total entries)
    arr[0] = "Showing"
    arr[1] = "1"
    arr[2] = "to"
    arr[3] = "10"
    arr[4] = "of"
    arr[5] = "32" <-- We need this total count
    ......
    ......
    */
    public int getSearchResultsCount(){
        String resultsText = this.searchResultsCountElement.getText();
        String arr[] = resultsText.split(" ");
        int count = Integer.parseInt(arr[5]);
        log.info("Results count: {}", count);
        return count;
    }

    public void logout(){
        this.profileImageElement.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutButtonElement));
        this.logoutButtonElement.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.modalLogoutElement));
        this.modalLogoutElement.click();
    }
}
