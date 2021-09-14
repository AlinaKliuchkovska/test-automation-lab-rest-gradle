package rest;

import asserts.Asserts;
import endpoints.AuthorEndpoints;
import endpoints.GenreEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Author;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.RandomGenerators;

public class TestRest {
    private static final AuthorEndpoints authorEndpoints = new AuthorEndpoints();
    private static final GenreEndpoints genreEndpoints = new GenreEndpoints();
    private static final Asserts asserts = new Asserts();

    @BeforeSuite
    public void setUrl(){
//        RestAssured.baseURI = System.getenv("baseURI");
        RestAssured.baseURI = "http://localhost:9090/";
    }

    @Test
    public void getAuthorByAuthorIdTest() {
        Author author = new Author(RandomGenerators.randomIdGenerator(), RandomGenerators.randomStringGenerator());
        authorEndpoints
                .createNewAuthor(author);
        Response response = authorEndpoints
                .getAuthorByAuthorId(author.getAuthorId());
        asserts.statusCodeIs(response, 200)
                .authorIdIs(response, author.getAuthorId())
                .authorNameIs(response, author.getAuthorName().getFirst(), author.getAuthorName().getSecond())
                .nationalityIs(response, author.getNationality());
    }

    @Test
    public void getGenreByNotValidBookIdTest() {
        Response response = genreEndpoints
                .getGenreByBookId(RandomGenerators.randomStringGenerator());
        asserts.statusCodeIs(response, 200)
                .errorMessageIs(response, "'bookId' value must be of 'Long' type!");
    }
}