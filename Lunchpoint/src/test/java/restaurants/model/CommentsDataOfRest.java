package restaurants.model;

/**
 * Created by Slava on 31.03.2017.
 */
public class CommentsDataOfRest {
  private String id;
  private String comment;

  public CommentsDataOfRest(String id, String comment) {
    this.id = id;
    this.comment = comment;
  }

  public CommentsDataOfRest(String comment) {
    this.comment = comment;
  }

  /*public CommentsDataOfRest(String id) {
    this.id = id;
  }*/

  @Override
  public String toString() {
    return "CommentsDataOfRest{" +
            "id='" + id + '\'' +
            ", comment='" + comment + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CommentsDataOfRest that = (CommentsDataOfRest) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    return comment != null ? comment.equals(that.comment) : that.comment == null;

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (comment != null ? comment.hashCode() : 0);
    return result;
  }
}
