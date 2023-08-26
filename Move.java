/* A class describing a move in the board
 * Every produced child corresponds to a move
 * and we need to keep the moves as well as the states.
 */
public class Move
{
    private int row;
    private int col;
    private double value;

    Move()
    {
        row = -1;
        col = -1;
        value = 0;
    }

    Move(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.value = -1;
    }

    Move(double value) {
        this.row = -1;
        this.col = -1;
        this.value = value; //value of the heuristic
    }

    Move(int row, int col, double value)
    {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }

    double getValue() {
        return value;
    }

    void setRow(int row) {
        this.row = row;
    }

    void setCol(int col) {
        this.col = col;
    }

    void setValue(double value) {
        this.value = value;
    }

    public String toString() { //shows move
        return row + "," +col;
    }
}