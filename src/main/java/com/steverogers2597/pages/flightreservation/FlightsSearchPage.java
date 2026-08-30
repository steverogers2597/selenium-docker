package com.steverogers2597.pages.flightreservation;

import com.steverogers2597.pages.AbstractPage;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class FlightsSearchPage extends AbstractPage {

    @FindBy(id = "oneway")
    private WebElement selectOneWay;

    @FindBy(id = "twoway")
    private WebElement selectTwoWay;

    @FindBy(id = "passengers")
    private WebElement selectPassengers;

    @FindBy(id = "depart-from")
    private WebElement selectDepartFrom;

    @FindBy(id = "arrive-in")
    private WebElement selectArriveIn;

    @FindBy(id = "service-class1")
    private WebElement selectEconomy;

    @FindBy(id = "service-class2")
    private WebElement selectFirstClass;

    @FindBy(id = "service-class3")
    private WebElement selectBusinessClass;

    @FindBy(id = "search-flights")
    private WebElement searchFlightBtn;

    public FlightsSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchFlightBtn));
        return this.searchFlightBtn.isDisplayed();
    }

    public void selectTravelOption(String option) {
        if (option.equalsIgnoreCase("One Way")) {
            this.selectOneWay.click();
        } else if (option.equalsIgnoreCase("Two Way")) {
            this.selectTwoWay.click();
        }
        else
            throw new IllegalArgumentException("Invalid option: " + option +
                    ". Use 'oneway' or 'twoway'.");
    }

    public void selectPassengerOption(String noOfPassengers) {
        Select passengers = new Select(this.selectPassengers);
        passengers.selectByValue(noOfPassengers);
    }

    public void selectDepartFromOption(String departFrom) {
        Select depart = new Select(this.selectDepartFrom);

        List<String> availableCities = depart.getOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        if (!availableCities.contains(departFrom)) {
            throw new IllegalArgumentException("Invalid depart from: " + departFrom);
        }

        depart.selectByValue(departFrom);
    }

    public void selectArriveInOption(String arriveIn) {
        Select arrive = new Select(this.selectArriveIn);

        List<String> availableCities = arrive.getOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        if (!availableCities.contains(arriveIn)) {
            throw new IllegalArgumentException("Invalid depart from: " + arriveIn);
        }

        arrive.selectByValue(arriveIn);
    }

    public void selectServiceClass(String option) {
        if (option.equalsIgnoreCase("Economy")) {
            this.selectEconomy.click();
        } else if (option.equalsIgnoreCase("First Class")) {
            this.selectFirstClass.click();
        } else if (option.equalsIgnoreCase("Business")) {
            this.selectBusinessClass.click();
        } else
            throw new IllegalArgumentException("Invalid option: " + option +
                    ". Use 'Economy' or 'First Class' or 'Business'.");
    }

    public void clickSearchFlightBtn() {
        this.searchFlightBtn.click();
    }

}
