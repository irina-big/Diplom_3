
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static pageObjects.AllLocators.BASE_URL;

public class Client {
    //private final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    protected RequestSpecification getSpecification(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    };
}
