package se.atg.service.harrykart.java;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("java-test")
public class HarryKartAppTest {

    private final static URI harryKartApp = URI.create("http://localhost:8181/java/api/play");

    @BeforeAll
    void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @DisplayName("Trying to GET instead of POST should return 405 Method not allowed")
    void useGetOnPostEndpointShouldNotBePossible() {
        when()
                .get(harryKartApp)
        .then()
                .assertThat()
                .statusCode(405);
    }
    
    @Test
    @DisplayName("Calculate rankings of horse race")
    void cantPlayYet() {
    	
    	 String FilePath = "src/main/resources/input_0.xml";
    	         String XMLBodyToPost = null;
				try {
					XMLBodyToPost = new String(Files.readAllBytes(Paths.get(FilePath)));
				} catch (IOException e) {
					e.printStackTrace();
				}
    	
        Response response=given().
                header("Content-Type", ContentType.XML).body(XMLBodyToPost)
        .when()
                .post(harryKartApp)
        .then()
                .assertThat()
                .statusCode(200)
                .header("Content-Type", ContentType.JSON.toString()).extract().response();
        assertEquals(response.jsonPath().getList("ranking").size(), 3);
    }
}
