public class Main {

  public static void main(String[] args) {
    Startup startup = new Startup();
    ApplicationRunner applicationRunner = new ApplicationRunner();
    startup.init();
    applicationRunner.run(startup);
  }
}