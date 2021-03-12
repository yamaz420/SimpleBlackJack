package CardGame;

/** ===============================================================
 * || typ <EntityKlass>.. lagrar data gällande score och spelaren ||
 * ===============================================================*/
public class Player {
  //  private static CardGame cardGame;
  private String name;
  private int numOfCards;
  private int score;
  private int lastCard;

  public Player() {
    //DefaultKonstruktor
    this.name = "";
    this.numOfCards = 0;
    this.score = 0;
  }


  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if ((name != null) && (name != "")) ;
    this.name = name;
  }

  public int getNumOfCards() {
    return numOfCards;
  }

  public void setNumOfCards(int cardss) {
    this.numOfCards = numOfCards;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void addToScore(int value) {
    score = score + value;
  }

  public void iAddToNumOfCards(int value) {
    numOfCards = numOfCards + value;
  }

  public void reset() { //initierar värdena egenteligen..
    name = "Mapundo";
    numOfCards = 0;
    score = 0;
  }
}