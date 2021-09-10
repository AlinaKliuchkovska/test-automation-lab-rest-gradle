package endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Author;

public class AuthorEndpoints {

    public Response getAuthorByAuthorId(Long authorId) {
        return RestAssured.
                when().get(String.format("/api/library/author/%s", authorId));
    }

    public Response createNewAuthor(Author author) {
        return RestAssured.
                with().body(author)
                .contentType("application/json")
                .when().post("/api/library/author");
    }

    public Response deleteExistedAuthor(Author author) {
        return RestAssured.
                when().delete(String.format("/api/library/author/%s", author.getAuthorId()));
    }

    public Response getAllAuthors() {
        return RestAssured.
                when().get("/api/library/authors");
    }
}