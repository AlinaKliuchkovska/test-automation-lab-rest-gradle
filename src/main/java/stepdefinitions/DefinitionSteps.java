package stepdefinitions;

import asserts.Asserts;
import endpoints.AuthorEndpoints;
import endpoints.BookEndpoints;
import endpoints.GenreEndpoints;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Author;
import models.Book;
import models.Genre;
import utils.RandomGenerators;

public class DefinitionSteps {

    private static final AuthorEndpoints authorEndpoints = new AuthorEndpoints();
    private static final GenreEndpoints genreEndpoints = new GenreEndpoints();
    private static final BookEndpoints bookEndpoints = new BookEndpoints();
    private static final Asserts asserts = new Asserts();
    private Response response;
    private Author author;
    private Book book;
    private Genre genre;

    @Before
    public void setUrl(){
        RestAssured.baseURI = System.getenv("baseURI");
    }

    @When("User creates new author")
    public void createNewAuthor() {
        author = new Author(RandomGenerators.randomIdGenerator(), RandomGenerators.randomStringGenerator());
        response = authorEndpoints.createNewAuthor(author);
    }

    @When("User gets author by author id")
    public void getAuthorByAuthorId() {
        response = authorEndpoints.getAuthorByAuthorId(author.getAuthorId());
    }

    @Then("User checks that status code is {int}")
    public void userChecksThatStatusCodeIsStatusCode(int expectedStatusCode) {
        asserts.statusCodeIs(response, expectedStatusCode);
    }

    @Then("User checks that author response body is as expected")
    public void userChecksThatResponseBodyIsAsExpected() {
        asserts.authorIdIs(response, author.getAuthorId())
                .authorNameIs(response, author.getAuthorName().getFirst(), author.getAuthorName().getSecond())
                .nationalityIs(response, author.getNationality());
    }

    @When("User gets genre by book id")
    public void userGetsGenreByBookId() {
        response = genreEndpoints.getGenreByBookId(RandomGenerators.randomStringGenerator());
    }

    @Then("User checks that error message is {string}")
    public void userChecksThatErrorMessageIs(String expectedErrorMessage) {
        asserts.errorMessageIs(response, expectedErrorMessage);
    }

    @Then("User checks that error message with book id is {string}")
    public void userChecksThatErrorMessageWithBookIdIs(String expectedErrorMessage) {
        asserts.errorMessageIs(response, (String.format(expectedErrorMessage, book.getBookId())));
    }

    @Then("User checks that error message with author id is {string}")
    public void userChecksThatErrorMessageWithAuthorIdIs(String expectedErrorMessage) {
        asserts.errorMessageIs(response, (String.format(expectedErrorMessage, author.getAuthorId())));
    }

    @Then("User checks that error message with genre id is {string}")
    public void userChecksThatErrorMessageWithGenreIdIs(String expectedErrorMessage) {
        asserts.errorMessageIs(response, (String.format(expectedErrorMessage, genre.getGenreId())));
    }

    @When("User creates new book")
    public void userCreatesNewBook() {
        book = new Book(RandomGenerators.randomIdGenerator(), RandomGenerators.randomStringGenerator(), RandomGenerators.randomStringGenerator());
        response = bookEndpoints.createNewBook(getIdOfExistedAuthor(), getIdOfExistedGenre(), book);
    }

    @Then("User checks that book response body is as expected")
    public void userChecksThatBookResponseBodyIsAsExpected() {
        asserts.bookIdIs(response, book.getBookId())
                .bookNameIs(response, book.getBookName())
                .bookLanguageIs(response, book.getBookLanguage())
                .pageCountIs(response, book.getAdditional().getPageCount())
                .publicationYearIs(response, book.getPublicationYear());
    }

    @When("User creates new author with already existed author id")
    public void userCreatesNewAuthorWithAlreadyExistedAuthorId() {
        author = new Author(getIdOfExistedAuthor(), RandomGenerators.randomStringGenerator());
        response = authorEndpoints.createNewAuthor(author);
    }

    @Given("User creates new genre")
    public void userCreatesNewGenre() {
        genre = new Genre(RandomGenerators.randomIdGenerator(), RandomGenerators.randomStringGenerator(), RandomGenerators.randomStringGenerator());
        response = genreEndpoints.createNewGenre(genre);
    }

    @And("User sets genre name")
    public void userSetsGenreName() {
        genre.setGenreName(RandomGenerators.randomStringGenerator());
    }

    @And("User sets genre description")
    public void userSetsGenreDescription() {
        genre.setGenreDescription(RandomGenerators.randomStringGenerator());
    }

    @When("User updates existed genre")
    public void userUpdatesExistedGenre() {
        response = genreEndpoints.updateExistedGenre(genre);
    }

    @Then("User checks that genre response body is as expected")
    public void userChecksThatGenreResponseBodyIsAsExpected() {
        asserts.genreIdIs(response, genre.getGenreId())
                .genreNameIs(response, genre.getGenreName())
                .genreDescriptionIs(response, genre.getGenreDescription());
    }

    @And("User sets book language")
    public void userSetsBookLanguage() {
        book.setBookLanguage(RandomGenerators.randomStringGenerator());
    }

    @And("User sets book name")
    public void userSetsBookName() {
        book.setBookName(RandomGenerators.randomStringGenerator());
    }

    @And("User sets book id")
    public void userSetsBookId() {
        book.setBookId(RandomGenerators.randomIdGenerator());
    }

    @When("User updates book with not exist book id")
    public void userUpdatesBookWithNotExistBookId() {
        response = bookEndpoints.updateExistedBook(book);
    }

    @When("User deletes existed genre")
    public void userDeletesExistedGenre() {
        response = genreEndpoints.deleteExistedGenre(genre.getGenreId());
    }

    @When("User gets genre by genre id")
    public void userGetsGenreByGenreId() {
        response = genreEndpoints.getGenreByGenreId(genre.getGenreId());
    }

    @When("User deletes existed author")
    public void userDeletesExistedAuthor() {
        author = new Author(RandomGenerators.randomIdGenerator(), RandomGenerators.randomStringGenerator());
        response = authorEndpoints.deleteExistedAuthor(author);
    }

    public Long getIdOfExistedAuthor() {
        return authorEndpoints
                .getAllAuthors()
                .then()
                .extract().body().jsonPath().getList(".", Author.class)
                .get(0).getAuthorId();
    }

    public Long getIdOfExistedGenre() {
        return genreEndpoints.getAllGenres()
                .then()
                .extract().body().jsonPath().getList(".", Genre.class)
                .get(0).getGenreId();
    }
}