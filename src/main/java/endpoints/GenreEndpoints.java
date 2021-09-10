package endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Genre;

public class GenreEndpoints {
    public Response getGenreByBookId(Object bookId) {
        return RestAssured.
                when().get(String.format("/api/library/book/%s/genre", bookId));
    }

    public Response getGenreByGenreId(Long genreId) {
        return RestAssured.
                when().get(String.format("/api/library/genre/%s", genreId));
    }

    public Response updateExistedGenre(Genre genre) {
        return RestAssured.
                with().body(genre)
                .contentType("application/json")
                .when().put("/api/library/genre");
    }

    public Response createNewGenre(Genre genre) {
        return RestAssured.
                with().body(genre)
                .contentType("application/json")
                .when().post("/api/library/genre");
    }

    public Response deleteExistedGenre(Long genreId) {
        return RestAssured.
                when().delete(String.format("/api/library/genre/%s", genreId));
    }

    public Response getAllGenres() {
        return RestAssured.
                when().get("/api/library/genres");
    }
}