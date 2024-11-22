package StepDef;

import io.cucumber.java.en.Given;
import pageObjects.RediffPageObject;

public class RediffStepDef {
    RediffPageObject rediff;
    @Given("User in Rediff Page")
    public void user_in_rediff_page() {
        rediff  = new RediffPageObject();
        
    }
    @Given("user enter {string} in fullname field")
    public void user_enter_in_fullname_field(String fullname) throws Exception {
        rediff.enterFullname(fullname);
        
    }
    @Given("user enter {string} in id field")
    public void user_enter_in_id_field(String id) throws Exception {
        rediff.idfield(id);
        
    }
    @Given("user click on check availabilty")
    public void user_click_on_check_availabilty() throws Exception {
        rediff.clickCheckAvailabiltyButton();

    }

    @Given("user should see message {string}")
    public void user_should_see_message(String message) throws Exception {
        rediff.checkAvailabilityMessage(message);
    }

    @Given("user enter {string} in password field")
    public void user_enter_in_password_field(String password) throws Exception {
        rediff.enterpassword(password);
        
    }

    @Given("user enter {string} in retype password field")
    public void user_enter_in_retype_password_field(String reenterpassword) throws Exception {
        rediff.retypepassword(reenterpassword);

    }
    @Given("user enter {string} in email field")
    public void user_enter_in_email_field(String alternateEmailfield) throws Exception {
        rediff.alternateEmailID(alternateEmailfield);
    }

    @Given("user enter {string} in mobile no field")
    public void user_enter_in_mobile_no_field(String mobileno) throws Exception {
        rediff.mobilenofield(mobileno);
    }
    @Given("user selects date of birth as {string} {string} {string}")
    public void user_selects_date_of_birth_as(String day, String month, String year) throws Exception {
        rediff.selectDateOfBirth(day,month,year);
    }

    @Given("user enter {string} in gender field")
    public void user_enter_in_gender_field(String gender) throws Exception {
        rediff.clickGenderButton(gender);
    }

    @Given("user enter {string} in country field")
    public void user_enter_in_country_field(String selectCountryDropDown) throws Exception {
        rediff.selectccountry(selectCountryDropDown);

    }
    @Given("user enter {string} in city field")
    public void user_enter_in_city_field(String city) throws Exception {
        rediff.selectcity(city);
    }

}

