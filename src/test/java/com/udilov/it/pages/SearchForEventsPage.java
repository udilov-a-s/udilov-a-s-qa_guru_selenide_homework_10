package com.udilov.it.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.udilov.it.pages.components.CalendarComponent;
import com.udilov.it.pages.components.EventCardComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SearchForEventsPage {

    private final SelenideElement eventNameInput = $("[placeholder='Search event...']"),
            countriesInput = $("[aria-placeholder='Select countries']");

    private final ElementsCollection startDateInput = $$("[placeholder='Start date']"),
            endDateInput = $$("[placeholder='End date']");

    public void openPage() {

        open("en/events/upcoming");
    }

    public SearchForEventsPage setEventName(String value) {

        eventNameInput.setValue(value).pressEnter();
        return this;
    }

    CalendarComponent calendarComponent = new CalendarComponent();

    public SearchForEventsPage setStartDate(String year, String month, String day) {

        startDateInput.filter(visible).first().click();
        calendarComponent.setDate(year, month, day);

        return this;
    }

    public SearchForEventsPage setEndDate(String year, String month, String day) {

        endDateInput.filter(visible).first().click();
        calendarComponent.setDate(year, month, day);

        return this;
    }

    public SearchForEventsPage setCountries(String value) {

        countriesInput.setValue(value).pressEnter();
        return this;
    }

    EventCardComponent eventCardComponent = new EventCardComponent();

    public void checkEventCardTitle(String value) {

        eventCardComponent.getFirstEventCard().getEventTitle().shouldHave(text(value));
    }

    public void checkEventCardDate(String month, String day) {

        eventCardComponent.getFirstEventCard().getEventDate().shouldHave(text(month + " " + day));
    }

    public void checkEventCardCountries(String value) {

        eventCardComponent.getFirstEventCard().getEventLocation().shouldHave(text(value));
    }

    public void checkSearchResultIsEmpty() {
        eventCardComponent.getEventCard().shouldBe(CollectionCondition.size(0));
    }
}
