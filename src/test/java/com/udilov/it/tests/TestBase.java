package com.udilov.it.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://smoothcomp.com/";
        Configuration.browserSize = "1024x768";
        Configuration.timeout = 3000;
    }
}
