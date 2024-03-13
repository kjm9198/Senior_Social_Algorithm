public class Client {
    private int ID;
    private int tokens;

    public Client(int ID, int tokens) {
        this.ID = ID;
        this.tokens = tokens;
    }

    public int getTokens() {
        return tokens;
    }
    public int getID() {
        return ID;
    }
    public void payToken() {
        tokens--;
    }
}
