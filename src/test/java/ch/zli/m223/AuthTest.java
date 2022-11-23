package ch.zli.m223;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class AuthTest {
    
    @Test
    public void testSuccsessLogin() {
    given()
        .when().post("http://localhost:8080/session/test@gmail.com/test%9")
                .then()
                .statusCode(200);
    }

    @Test
    public void testRegiSuccsess() {
        given().contentType(ContentType.JSON)
          .body("{\"prename\":\"test\",\"surname\":\"test\",\"email\":\"test@gmail.com\",\"password\":\"test\",\"role\":{\"id\":9}}")
          .when().post("http://localhost:8080/session")
          .then()
             .statusCode(200);
    }

    @Test
    public void LoginFailedEndpoint(){
        String password = "854285";
        String email = "tobias.bertschi@lernende.bbw.ch";

        given()
            .when().post("/session/" + email + "/" + password )
            .then()
                .statusCode(404);
    }


  

   



   
}
