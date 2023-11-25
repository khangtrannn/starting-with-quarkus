package org.khang.quarkus.starting;

import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
public class BookResourceIT extends BookResourceTest {
    // Execute the same tests but in packaged mode.
    @Test
  public void shouldGetABook() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
      .pathParam("id", 1).
    when()
      .get("/api/books/{id}").
    then()
      .statusCode(Response.Status.OK.getStatusCode())
      .body("title", is("Understanding Quarkus"))
      .body("author", is("Antonio"))
      .body("yearOfPublication", is(2020))
      .body("genre", is("Information Technology"));
  }
}
