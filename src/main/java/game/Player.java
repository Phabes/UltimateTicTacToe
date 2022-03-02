package game;

public class Player implements IPlayer {
  private final String name;
  private final String sign;
  private Player next;

  public Player(String name, String sign) {
    this.name = name;
    this.sign = sign;
  }

  @Override
  public String getName() {
    return name;
  }

  public String getSign() {
    return sign;
  }

  public void setNextPlayer(Player next) {
    this.next = next;
  }

  public Player getNextPlayer() {
    return this.next;
  }
}
