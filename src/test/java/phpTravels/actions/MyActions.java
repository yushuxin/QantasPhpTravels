package phpTravels.actions;

import phpTravels.pages.AccountPage;
import phpTravels.pages.BookingPage;
import phpTravels.pages.HomePage;
import phpTravels.pages.HotelDetailPage;
import phpTravels.pages.LoginPage;
import phpTravels.pages.SearchHotelResultPage;
import phpTravels.pages.SearchHotelTab;
import support.MyWebDriver;

public class MyActions {

  public String EMAIL = "user@phptravels.com";
  public String PASSWORD = "demouser";

  public String LOGIN_URL = "https://www.phptravels.net/login";
  public String HOME_URL = "https://www.phptravels.net";

  private MyWebDriver driver;

  public MyActions(MyWebDriver driver) {
    this.driver = driver;
  }

  public void login() {
    driver.get(LOGIN_URL);
    driver.manage().window().maximize();
    LoginPage loginPage = new LoginPage(driver);
    loginPage.inputEmail(EMAIL);
    loginPage.inputPassword(PASSWORD);
    loginPage.clickLogin();
  }

  public void gotoHomePage(){
    AccountPage accountPage = new AccountPage(driver);
    accountPage.clickHomeLink();
  }

  public void searchHotel(String destination){
    SearchHotelTab searchHotelTab = new SearchHotelTab(driver);
    searchHotelTab.setDestination(destination);
    searchHotelTab.clickSearch();
  }

  public void bookHotel(String hotelName, String roomName) {
    SearchHotelResultPage searchHotelResultPage = new SearchHotelResultPage(driver);
    searchHotelResultPage.clickHotelName(hotelName);

    HotelDetailPage hotelDetailPage = new HotelDetailPage(driver);
    hotelDetailPage.clickSeePriceAndDate();

    hotelDetailPage.selectRoom(roomName);
    hotelDetailPage.clickBookNow();

    BookingPage bookingPage = new BookingPage(driver);
    bookingPage.clickConfirmThisBooking();
  }

  public void gotoAccountPage() {
    HomePage homePage = new HomePage(driver);
    homePage.clickLoginDropDown();
    homePage.clickAccountItem();
  }

  public boolean verifyBookingExist(String hotelName){
    AccountPage accountPage = new AccountPage(driver);
    return accountPage.verifyBookingExist(hotelName);
  }

}
