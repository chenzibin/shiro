package snake;

public class SnakePoint<T> {

    private int x;

    private int y;

    private T value;

    public SnakePoint() {
    }

    public SnakePoint(int x, int y, T value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
