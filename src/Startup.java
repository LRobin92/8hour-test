public class Startup {

  QuestionContainer questionContainer = new QuestionContainer();

  public void init(){
    Question existingQuestion1 = new Question("What is Peters favorite food?");
    Question existingQuestion2 = new Question("What is this test good for?");
    existingQuestion1.getAnswerList().add("Pizza");
    existingQuestion1.getAnswerList().add("Spaghetti");
    existingQuestion1.getAnswerList().add("Ice cream");
    existingQuestion2.getAnswerList().add("Test your skills in java");
    existingQuestion2.getAnswerList().add("Exercise for today");
    questionContainer.getQuestions().add(existingQuestion1);
    questionContainer.getQuestions().add(existingQuestion2);
  }

  public QuestionContainer getQuestionContainer() {
    return questionContainer;
  }
}
