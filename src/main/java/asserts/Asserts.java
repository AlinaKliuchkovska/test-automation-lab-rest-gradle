package asserts;

import io.restassured.response.Response;
import org.junit.Assert;

public class Asserts {

    public Asserts statusCodeIs(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.statusCode(), expectedStatusCode);
        return this;
    }

    public Asserts errorMessageIs(Response response, String expectedErrorMessage) {
        Assert.assertEquals(response.jsonPath().get("errorMessage"), expectedErrorMessage);
        return this;
    }

    public Asserts authorIdIs(Response response, Long expectedId) {
        Assert.assertEquals(response.jsonPath().get("authorId"), expectedId);
        return this;
    }

    public Asserts authorNameIs(Response response, String expectedFirst, String expectedSecond) {
        Assert.assertEquals(response.jsonPath().get("authorName.first"), expectedFirst);
        Assert.assertEquals(response.jsonPath().get("authorName.second"), expectedSecond);
        return this;
    }

    public Asserts nationalityIs(Response response, String expected) {
        Assert.assertEquals(response.jsonPath().get("nationality"), expected);
        return this;
    }

    public Asserts genreIdIs(Response response, Long expectedId) {
        Assert.assertEquals(response.jsonPath().get("genreId"), expectedId);
        return this;
    }

    public Asserts genreNameIs(Response response, String expectedGenreName) {
        Assert.assertEquals(response.jsonPath().get("genreName"), expectedGenreName);
        return this;
    }

    public Asserts genreDescriptionIs(Response response, String expectedGenreDescription) {
        Assert.assertEquals(response.jsonPath().get("genreDescription"), expectedGenreDescription);
        return this;
    }

    public Asserts bookIdIs(Response response, Long expectedBookId) {
        Assert.assertEquals(response.jsonPath().get("bookId"), expectedBookId);
        return this;
    }

    public Asserts bookNameIs(Response response, String expectedBookName) {
        Assert.assertEquals(response.jsonPath().get("bookName"), expectedBookName);
        return this;
    }

    public Asserts bookLanguageIs(Response response, String expectedBookLanguage) {
        Assert.assertEquals(response.jsonPath().get("bookLanguage"), expectedBookLanguage);
        return this;
    }

    public Asserts publicationYearIs(Response response, Integer expectedPublicationYear) {
        Assert.assertEquals(response.jsonPath().get("publicationYear"), expectedPublicationYear);
        return this;
    }

    public Asserts pageCountIs(Response response, Integer expectedPageCount) {
        Assert.assertEquals(response.jsonPath().get("additional.pageCount"), expectedPageCount);
        return this;
    }
}