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


  

   



   
}
