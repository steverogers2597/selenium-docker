package com.steverogers2597.pages.flightreservation;

import com.steverogers2597.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FLightsSelectionPage extends AbstractPage {

    @FindBy(name = "departure-flight")
    private List<WebElement> departureFlightsOptions;

    @FindBy(name = "arrival-flight")
    private List<WebElement> arrivalFlightsOptions;

    @FindBy(id = "confirm-flights")
    private WebElement confirmFlightsButton;

    public FLightsSelectionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmFlightsButton));
        return this.confirmFlightsButton.isDisplayed();
    }

    public void selectFlights(String departureFlight, String arrivalFlight) {
        boolean departureSelected = false;
        boolean arrivalSelected = false;

        // Select departure
        for (WebElement option : departureFlightsOptions) {
            if (option.getAttribute("value").equalsIgnoreCase(departureFlight)) {
                option.click();
                departureSelected = true;
                break;
            }
        }

        // Select arrival
        for (WebElement option : arrivalFlightsOptions) {
            if (option.getDomAttribute("value").equalsIgnoreCase(arrivalFlight)) {
                option.click();
                arrivalSelected = true;
                break;
            }
        }
    }

    public void confirmFlight(){
        this.confirmFlightsButton.click();
    }
}
