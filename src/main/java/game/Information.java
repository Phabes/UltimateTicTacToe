package game;

public class Information {
  private Player player1;
  private Player player2;
  private Player currentPlayer;
  private int currentY = -1;
  private int currentX = -1;

  public Information(Player p1, Player p2) {
    this.player1 = p1;
    this.player2 = p2;
    this.currentPlayer = p1;
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
    if (this.currentPlayer.equals(this.player1))
      this.currentPlayer = this.player2;
    else
      this.currentPlayer = this.player1;
  }
}
