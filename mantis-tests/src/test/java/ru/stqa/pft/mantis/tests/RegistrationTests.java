package ru.stqa.pft.mantis.tests;


import org.testng.annotations.Test;

/**
 * Created by marru on 05.09.2017.
 */
public class ReistrationTests extends TestBase {

    @Test
    public void testRegistration(){
        app.registration().start("user1","mail@mail.com");

    }
}
