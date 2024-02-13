package com.udilov.it.pages.components;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private final ElementsCollection yearPicker = $$("[aria-label=Year]"),
            monthPicker = $$(".flatpickr-monthDropdown-months"),
            dayPicker = $$(".flatpickr-day");

    public void setDate(String year, String month, String day) {

        yearPicker.filter(visible).first().setValue(year);
        monthPicker.filter(visible).first().selectOption(month);
        dayPicker.filter(attribute("aria-label", month + " " + day + ", " + year)).first()
                .click();
    }
}
