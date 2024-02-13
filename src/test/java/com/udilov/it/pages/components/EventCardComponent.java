package com.udilov.it.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EventCardComponent {
    private final ElementsCollection eventCard = $$(".panel");

    private final SelenideElement eventTitle = $(".event-title"),
            eventLocation = $(".location"),
            eventDate = $(".flex-grow-1.date");

    public ElementsCollection getEventCard() {
        return eventCard;
    }

    public SelenideElement getEventTitle() {
        return eventTitle;
    }

    public SelenideElement getEventLocation() {
        return eventLocation;
    }

    public SelenideElement getEventDate() {
        return eventDate;
    }

    public EventCardComponent getFirstEventCard() {

        eventCard.first();
        return this;
    }
}
