Feature: Smoke
  As a user
  I want to test all main REST functionality
  So that I can be sure that REST works correctly

  Scenario: Get author by author id
    When User creates new author
    Then User checks that status code is 201
    When User gets author by author id
    Then User checks that status code is 200
    Then User checks that author response body is as expected

  Scenario: Get genre by not valid book id
    When User gets genre by book id
    Then User checks that status code is 400
    Then User checks that error message is "'bookId' value must be of 'Long' type!"

  Scenario: Post book
    When User creates new book
    Then User checks that status code is 201
    Then User checks that book response body is as expected

  Scenario: Post author with already existed author id
    When User creates new author with already existed author id
    Then User checks that status code is 409
    Then User checks that error message is "Author with such 'authorId' already exists!"

  Scenario: Put genre
    Given User creates new genre
    And User checks that status code is 201
    And User sets genre name
    And User sets genre description
    When User updates existed genre
    Then User checks that status code is 200
    Then User checks that genre response body is as expected

  Scenario: Put book with not exist book id
    Given User creates new book
    And User checks that status code is 201
    And User sets book language
    And User sets book name
    And User sets book id
    When User updates book with not exist book id
    Then User checks that status code is 404
    Then User checks that error message with book id is "Book with 'bookId' = '%s' doesn't exist!"

  Scenario: Delete genre by genre id
    Given User creates new genre
    And User checks that status code is 201
    When User deletes existed genre
    Then User checks that status code is 204
    When User gets genre by genre id
    Then User checks that status code is 404
    Then User checks that error message with genre id is "Genre with 'genreId' = '%s' doesn't exist!"

  Scenario: Delete author with not exist id
    When User deletes existed author
    Then User checks that status code is 404
    Then User checks that error message with author id is "Author with 'authorId' = '%s' doesn't exist!"