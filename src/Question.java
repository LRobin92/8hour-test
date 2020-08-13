import java.util.ArrayList;
import java.util.List;

public class Question {

  private String title;
  private List<String> answerList;


  public Question(String title) {
    this.title = title;
    this.answerList = new ArrayList<>();
  }

  public String getTitle() {
    return title;
  }

  public List<String> getAnswerList() {
    return answerList;
  }
}
