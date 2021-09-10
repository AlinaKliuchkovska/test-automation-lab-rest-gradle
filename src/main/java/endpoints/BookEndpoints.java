package endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Book;

public class BookEndpoints {
    public Response createNewBook(Long authorId, Long genreId, Book book) {
        return RestAssured.
                with()
                .body(book)
                .contentType("application/json")
                .when().post(String.format("/api/library/book/%s/%s", authorId, genreId));
    }

    public Response updateExistedBook(Book book) {
        return RestAssured.
                with().body(book)
                .contentType("application/json")
                .when().put("/api/library/book");
    }
}