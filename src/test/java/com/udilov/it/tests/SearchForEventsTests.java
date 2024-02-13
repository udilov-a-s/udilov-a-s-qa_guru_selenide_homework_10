package com.udilov.it.tests;

import com.udilov.it.pages.SearchForEventsPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Тесты на поиск мероприятий")
public class SearchForEventsTests extends TestBase {

    SearchForEventsPage searchForEventsPage = new SearchForEventsPage();

    @BeforeEach
    void setUp() {
        searchForEventsPage.openPage();
    }

    @ValueSource(strings = {
            "cup", "sport", "tron"
    })
    @ParameterizedTest(name = "Поиск мероприятия по названию {0} с выдачай")
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE")
    })
    public void searchForEventsByNameShouldHaveResultTest(String eventName) {

        searchForEventsPage.setEventName(eventName)
                .checkEventCardTitle(eventName);
    }

    @ValueSource(strings = {
            "ccup", "sportt", "atron"
    })
    @ParameterizedTest(name = "Поиск мероприятия по названию {0} без выдачи")
    @Tags({
            @Tag("WEB")
    })
    public void searchForEventsByNameShouldHaveEmptyResultTest(String eventName) {

        searchForEventsPage.setEventName(eventName)
                .checkSearchResultIsEmpty();
    }

    //Название теста и соответствующих методов(проверок) нужно более информативное - есть в выдачи, нет в выдачи и тд.
    @CsvSource(value = {
            "2024, March, 22",
            "2024, April, 13",
            "2024, March, 29"
    })
    @ParameterizedTest(name = "Поиск мероприятий по дате {0} {1} {2} с выдачей")
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE")
    })
    public void searchForEventsByDateShouldHaveResultTest(String year, String month, String day) {

        searchForEventsPage.setEndDate(year, month, day)
                .setStartDate(year, month, day)
                .checkEventCardDate(month, day);
    }

    @CsvFileSource(resources = "/testData/searchForEventsByDateShouldBeEmpty.csv")
    @ParameterizedTest(name = "Поиск мероприятий по дате {0} {1} {2} без выдачи")
    @Tags({
            @Tag("WEB")
    })
    public void searchForEventsByDateShouldHaveEmptyResultTest(String year, String month, String day) {

        searchForEventsPage.setEndDate(year, month, day)
                .setStartDate(year, month, day)
                .checkSearchResultIsEmpty();
    }

    @ValueSource(strings = {
            "Costa Rica", "Brazil", "Japan"
    })
    @ParameterizedTest(name = "Поиск мероприятий по стране {0} с выдачей")
    @Tags({
        @Tag("WEB"),
        @Tag("SMOKE")
    })
    public void searchForEventsByCountriesShouldHaveResultTest(String countries) {

        searchForEventsPage.setCountries(countries)
                .checkEventCardCountries(countries);
    }

    @ValueSource(strings = {
            "Aruba", "Madagascar", "Russia"
    })
    @ParameterizedTest(name = "Поиск мероприятий по стране {0} без выдачи")
    @Tags({
            @Tag("WEB")
    })
    public void searchForEventsByCountriesShouldHaveEmptyResultTest(String countries) {

        searchForEventsPage.setCountries(countries)
                .checkSearchResultIsEmpty();
    }
}


