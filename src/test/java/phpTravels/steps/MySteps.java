package phpTravels.steps;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import phpTravels.actions.MyActions;

public class MySteps {

  private String hotelName;

  private MyActions myActions;

  public MySteps(MyActions myActions) {
    this.myActions = myActions;
  }

  @Given("I have logged in")
  public void i_have_logged_in() {
    myActions.login();
  }

  @Given("I am on home page")
  public void i_am_on_home_page() {
    myActions.gotoHomePage();
  }

  @When("I searched hotels")
  public void i_searched_hotels() {
    myActions.searchHotel("london");
  }

  @When("I booked a {string} in {string}")
  public void i_booked_a_hotel(String roomName, String hotelName) {
    this.hotelName = hotelName;
    myActions.bookHotel(hotelName, roomName);
  }

  @Then("The hotel booking should be in my account page")
  public void the_hotel_booking_should_be_in_my_account_page() {
    myActions.gotoAccountPage();
    assertTrue(myActions.verifyBookingExist(hotelName));
  }

}
