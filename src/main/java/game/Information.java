package game;

public class Information {
  private Player currentPlayer;
  private int currentY = -1;
  private int currentX = -1;

  public Information(Player currentPlayer) {
    this.currentPlayer = currentPlayer;
  }

  public int getCurrentY() {
    return this.currentY;
  }

  public int getCurrentX() {
    return this.currentX;
  }

  public void setCurrentY(int y) {
    this.currentY = y;
  }

  public void setCurrentX(int x) {
    this.currentX = x;
  }

  public Player getCurrentPlayer() {
    return this.currentPlayer;
  }

  public void changePlayer() {
    this.currentPlayer = this.currentPlayer.getNextPlayer();
  }
}
