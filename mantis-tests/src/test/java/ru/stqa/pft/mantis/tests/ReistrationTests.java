package ru.stqa.pft.mantis.tests;


/**
 * Created by marru on 05.09.2017.
 */
public class ReistrationTests extends TestBase {
    @org.testng.annotations.Test
    public void testRegistration(){
        app.registration().start("user1","mail@mail.com");

    }
}
