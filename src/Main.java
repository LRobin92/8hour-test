import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int counter = 0;
    Scanner scanner = new Scanner(System.in);
    QuestionContainer questionContainer = new QuestionContainer();
    Service service = new Service(questionContainer);
    Question existingQuestion1 = new Question("What is Peters favorite food?");
    Question existingQuestion2 = new Question("What is this test good for?");
    existingQuestion1.getAnswerList().add("Pizza");
    existingQuestion1.getAnswerList().add("Spaghetti");
    existingQuestion1.getAnswerList().add("Ice cream");
    existingQuestion2.getAnswerList().add("Test your skills in java");
    existingQuestion2.getAnswerList().add("Exercise for today");
    questionContainer.getQuestions().add(existingQuestion1);
    questionContainer.getQuestions().add(existingQuestion2);

    do {
      System.out.println("Please enter 1 if you would like to create a question or 2 if you " +
          "would like to get an existing question:");

      int userFirstInput = scanner.nextInt();
      service.questionCreationOrNot(userFirstInput);

      if (userFirstInput == 1) {
        boolean validQuestionCreated = true;
        Scanner sc = new Scanner(System.in);
        String questionTitle = sc.nextLine();
        if (!questionTitle.endsWith("?")) {
          validQuestionCreated = false;
          System.out.println("Please note that question should be ended by a question mark");
        } else if (questionTitle.length() > 256) {
          validQuestionCreated = false;
          System.out.println("Questions can not be more then 255 characters length!");
        }

        if (validQuestionCreated){
          Question currentQuestion = service.createNewQuestion(questionTitle);
          String answer = "";
          Scanner sc1 = new Scanner(System.in);

          while (!answer.equals("esc")) {
            answer = sc1.nextLine();
            if (answer.length() > 256) {
              System.out.println("Answer can not be more then 255 characters length!");
            } else if(!answer.equals("esc")){
              currentQuestion.getAnswerList().add(answer);
            } else if(answer.equals("esc") && currentQuestion.getAnswerList().size() == 0){
              questionContainer.getQuestions().remove(questionContainer.getQuestions().size()-1);
              System.out.println("Sorry no answer provided, creation declined.");
            }
          }
        }
      }

      if (userFirstInput == 2) {
        Scanner scanner1 = new Scanner(System.in);
        String selectedQuestionTitle = scanner1.nextLine();
        service.getTheSpecificQuestion(selectedQuestionTitle);
      }

      System.out.println("Would you like to continue? If yes enter 3, if no hit any other number");
      int userInput2 = scanner.nextInt();
      System.out.println(userInput2);
      if (userInput2 == 3) {
        System.out.println("Thank you for continuing");
      } else if (userInput2 != 3){
        System.out.println("Good bye!");
        counter++;
      }
    } while (counter < 1);

  }
}