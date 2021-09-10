package models;

public class Author {
    private String authorDescription;
    private Long authorId;
    private Name authorName;
    private String nationality;
    private Birth birth;

    public Author(){
    }

    public Author(Long authorId, String authorDescription) {
        this.authorId = authorId;
        this.authorName = new Name("Author", "Name");
        this.nationality = "Indonesian";
        this.birth = new Birth("1973-03-28", "UA","Lviv");
        this.authorDescription = authorDescription;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Name getAuthorName() {
        return authorName;
    }

    public void setAuthorName(Name authorName) {
        this.authorName = authorName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Birth getBirth() {
        return birth;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }
}
