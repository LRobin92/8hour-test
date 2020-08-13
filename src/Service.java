public class Service {

  private QuestionContainer questionContainer;

  public Service(QuestionContainer questionContainer) {
    this.questionContainer = questionContainer;
  }

  public void questionCreationOrNot(int givenNumber){
    if(givenNumber == 1){
      System.out.println("You chose the creation," +
          " please add a question with '?' mark at the end, then give answer(s) to it. " +
          "If you write 'esc' then you can stop adding more answers to it.");
    } else if (givenNumber == 2){
      System.out.println("You want to get a specific question," +
          " please write down the question title: ");
      for (Question question : questionContainer.getQuestions()) {
        System.out.println(question.getTitle());
      }
    } else {
      System.out.println("Sorry, that's not an option!");
    }
  }

  public void getTheSpecificQuestion(String questionTitle){
    if(isExistingQuestion(questionTitle)){
      for (Question question : questionContainer.getQuestions()) {
        if (question.getTitle().equals(questionTitle)) {
          System.out.println(question.getTitle());
          getTheListOfTheAnswers(question);
        }
      }
    }else {
      System.out.println("the answer to life, universe and everything is 42");
    }
  }

  public Question createNewQuestion(String questionTitle){
    Question question = new Question(questionTitle);
    questionContainer.getQuestions().add(question);
    return question;
  }

  public void getTheListOfTheAnswers(Question question){
    for (String result : question.getAnswerList()) {
      System.out.println( "- " + result);
    }
  }

  public boolean isExistingQuestion(String questionTitle){
    for (int i = 0; i < questionContainer.getQuestions().size() ; i++) {
      if (questionContainer.getQuestions().get(i).getTitle().equals(questionTitle)) {
        return true;
      }
    }
    return false;
  }
}
