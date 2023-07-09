package org.example;

/**
 * This class stores information about one specific DVD.
 *
 * @author david
 */
public class DVD {

  private final int id;
  private String title;
  private String date;
  private int age;
  private String director;
  private String studio;
  private String commentary;

  public DVD(int id, String title, String date, int age,
             String director, String studio,
             String commentary) {

    this.id = id;
    this.title = title;
    this.age = age;
    this.date = date;
    this.director = director;
    this.studio = studio;
    this.commentary = commentary;

  }

  /**
   * This method gets the ID of a DVD.
   *
   * @return the DVDs ID
   */
  public int getId() { return this.id; }

  /**
   * This method gets the commentary of a DVD.
   *
   * @return the commentary left on the DVD
   */
  public String getCommentary() {
    return commentary;
  }

  /**
   * This method gets the studio who produced the DVD.
   *
   * @return the studio of the DVD object.
   */
  public String getStudio() {
    return studio;
  }

  /**
   * This method gets the director of the DVD.
   *
   * @return the director of the DVD
   */
  public String getDirector() {
    return director;
  }

  /**
   * This method gets the release date of the DVD.
   *
   * @return the release date of the DVD
   */
  public String getDate() { return date; }

  /**
   * This method gets the age rating of the DVD.
   *
   * @return the age rating of the DVD
   */
  public int getAge() {
    return age;
  }

  /**
   * This method gets the title of the DVD.
   *
   * @return the DVD title
   */
  public String getTitle() {
    return title;
  }

  /**
   * This method sets the commentary of a DVD.
   */
  public void setCommentary(String commentary) {
     this.commentary = commentary;
  }

  /**
   * This method sets the studio who produced the DVD.
   */
  public void setStudio(String studio) {
    this.studio = studio;
  }

  /**
   * This method sets the director of the DVD.
   */
  public void setDirector(String director) {
    this.director = director;
  }

  /**
   * This method sets the release date of the DVD.
   */
  public void setDate(String date) {
    this.date = date;
  }

  /**
   * This method sets the age rating of the DVD.
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * This method sets the title of the DVD.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * This method gets a string representation of a DVD object.
   *
   * @return a string representation of a DVD object
   */
  @Override
  public String toString() {
    return "DVD{" +
            "title='" + title + '\'' +
            ", date='" + date + '\'' +
            ", age=" + age +
            ", director='" + director + '\'' +
            ", studio='" + studio + '\'' +
            ", commentary='" + commentary + '\'' +
            '}';
  }
}
