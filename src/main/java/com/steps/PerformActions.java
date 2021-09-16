package com.steps;

import com.pages.HomePage;
import com.pages.RepositoriesPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class PerformActions {

    @Given("user navigate to django github page")
    public void navigatetoPage(){
        HomePage.openHomePage();
    }

    @When("User clicks on repositories Link")
    public void clickonRepositoriesLink() {
        HomePage.clickOnRepositories();
    }

    @Then("all repositories must be shown to user")
        public void showrespositories(){
        RepositoriesPage.checkrepositories();


        }

        @Then("verify all respotories are shown to user")
                public void verifyallrepositories(){



        }
    }


