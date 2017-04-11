package restaurants.utils;

import restaurants.model.RestDataOfMainPage;

/**
 * Created by Slava on 14.03.2017.
 */
public class MainPgUtils {
  public static final RestDataOfMainPage restEditDataOfMainPg = new RestDataOfMainPage()
          .withLng(30.39818839999998)
          .withId(2219)
          .withNameOfMainImg("MainImg.jpg")
          .withNameOfRest("Slava test selenium")
          .withAddressOfRest("вул.Жолудєва 8")
          .withSeoOfRest("slavkotest123")
          .withDescriptionOfRest("Здесь описание ресторана")
          .withAddressOnTheMapOfRest("вулиця Жолудєва, 8, Київ, Украина, 03134")
          .withGpsOfRest("50.4167724,30.39818839999998")
          .withIndexOfRest("03134")
          .withTelOfRest("0632223344")
          .withEmailOfRest("optibayukraine@gmail.com")
          .withBookingEmailOfRest("slava17puh123@gmail.com")
          .withSiteOfRest("my_site123.com")
          .withFbOfRest("my_fb.com")
          .withInstagramOfRest("my_instagram.com")
          .withTwitterOfRest("my_twitter.com")
          .withNetworkOfRest("Aroma espresso bars")
          .withTypeOfRest("Бистро")
          .withTypeOfCuisine("BBQ")
          .withAdditionalServiceOfRest("Happy hours")
          .withOtherFeaturesOfRest("Cork-fee");


  public static final RestDataOfMainPage restDefaultDataOfMainPageAllField = new RestDataOfMainPage()
          .withLng(30.39818839999998)
          .withId(2219)
          .withNameOfMainImg("MainImg.jpg")
          .withNameOfRest("Slava test123")
          .withAddressOfRest("вул.Академика Белецкого, 9а")
          .withSeoOfRest("viacheslav")
          .withDescriptionOfRest("Здесь описание ресторана тест создание ресторана")
          .withAddressOnTheMapOfRest("9A, вулиця Академіка Білецького, 9А, Київ, Украина")
          .withGpsOfRest("50.430206,30.417633000000023")
          .withIndexOfRest("03126")
          .withTelOfRest("0671112299")
          .withEmailOfRest("create123@gmail.com")
          .withBookingEmailOfRest("test123@gmail.com")
          .withNetworkOfRest("Carte Blanche")
          .withTypeOfRest("Винотека")
          .withTypeOfCuisine("Авторская")
          .withAdditionalServiceOfRest("Еда с собой")
          .withOtherFeaturesOfRest("Бильярд");
}