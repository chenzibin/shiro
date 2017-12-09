package snake;

import snake.function.Convertible;
import snake.function.NumericConvert;

import java.util.ArrayList;
import java.util.List;

/**
 * 蛇形走位
 */
public class SnakeGo<T> {

    /*宽*/
    private int width;

    /*高*/
    private int height;

    /*最小长宽*/
    public static final int MIN_LENGTH = 3;

    /*方位*/
    private int position;

    /*左上*/
    public static final int POSITION_UPPER_LEFT = 1;

    /*左下*/
    public static final int POSITION_LOWER_LEFT = 2;

    /*右上*/
    public static final int POSITION_UPPER_RIGHT = 3;

    /*右下*/
    public static final int POSITION_LOWER_RIGHT = 4;

    /*方向*/
    private int direct;

    /*顺时针*/
    public static final int DIRECT_CLOCKWISE = 1;
    /*逆时针*/
    public static final int DIRECT_ANTICLOCKWISE = 2;

    /*当前值*/
    private T value;

    /*函数类*/
    private Convertible<T> convert;

    private List<SnakePoint<T>> snake;

    public SnakeGo(int width, int height, int initPosition, int initDirect, T value, Convertible<T> convert) {
        this.width = width;
        if (this.width < MIN_LENGTH) {
            this.width = MIN_LENGTH;
        }
        this.height = height;
        if (this.height < MIN_LENGTH) {
            this.height = MIN_LENGTH;
        }
        this.position = initPosition;
        if (this.position != POSITION_LOWER_LEFT && this.position != POSITION_LOWER_RIGHT
                && this.position != POSITION_UPPER_LEFT && initPosition != POSITION_UPPER_RIGHT) {
            this.position = POSITION_UPPER_LEFT;
        }
        this.direct = initDirect;
        if (this.direct != DIRECT_CLOCKWISE && this.direct != DIRECT_ANTICLOCKWISE) {
            this.direct = DIRECT_CLOCKWISE;
        }

        this.value = value;
        this.convert = convert;
    }

    private void build() {
        snake = new ArrayList<>();
        SnakePoint point = null;
        if (this.position == POSITION_UPPER_LEFT) {
            point = new SnakePoint<>(0 , 0 , value);
        } else if (this.position == POSITION_UPPER_RIGHT) {
            point = new SnakePoint<>(this.width - 1, 0, value);
        } else if (this.position == POSITION_LOWER_LEFT) {
            point = new SnakePoint<>(0, this.height - 1, value);
        } else if (this.position == POSITION_LOWER_RIGHT) {
            point = new SnakePoint<>(this.width - 1, this.height - 1, value);
        }
        snake.add(point);

        while (hasNextPoint()) {
            snake.add(nextPoint());
        }
    }

    private boolean hasNextPoint() {
        if (snake.size() < width * height) {
            return true;
        }
        return false;
    }

    private SnakePoint<T> nextPoint() {

        SnakePoint<T> currentPoint = snake.get(snake.size() - 1);
        SnakePoint<T> prevPoint = null;
        SnakePoint<T> nextPoint = new SnakePoint<>();

        final T nextValue = convert.convert(currentPoint.getValue());
        nextPoint.setValue(nextValue);
        if (snake.size() == 1) {
            prevPoint = generateTempPoint(currentPoint);
        } else {
            prevPoint = snake.get(snake.size() - 2);
        }

        final int shiftX = currentPoint.getX() - prevPoint.getX();
        if (shiftX != 0) {
            nextPoint.setPoint(currentPoint.getX() + shiftX, currentPoint.getY());
            if (checkPoint(nextPoint)) {
                return nextPoint;
            }
            if (this.direct == DIRECT_CLOCKWISE) {
                nextPoint.setPoint(currentPoint.getX(), currentPoint.getY() + shiftX);
                if (checkPoint(nextPoint)) {
                    return nextPoint;
                }
            } else {
                nextPoint.setPoint(currentPoint.getX(), currentPoint.getY() - shiftX);
                if (checkPoint(nextPoint)) {
                    return nextPoint;
                }
            }
        }

        final int shiftY = currentPoint.getY() - prevPoint.getY();
        if (shiftY != 0) {
            nextPoint.setPoint(currentPoint.getX(), currentPoint.getY() + shiftY);
            if (checkPoint(nextPoint)) {
                return nextPoint;
            }
            if (this.direct == DIRECT_CLOCKWISE) {
                nextPoint.setPoint(currentPoint.getX() - shiftY, currentPoint.getY());
                if (checkPoint(nextPoint)) {
                    return nextPoint;
                }
            } else {
                nextPoint.setPoint(currentPoint.getX() + shiftY, currentPoint.getY());
                if (checkPoint(nextPoint)) {
                    return nextPoint;
                }
            }
        }
        return null;
    }

    private SnakePoint<T> generateTempPoint(SnakePoint<T> currentPoint) {
        SnakePoint<T> tempPoint = new SnakePoint<>();
        if (this.direct == DIRECT_CLOCKWISE) {
            if (currentPoint.getY() == 0) {
                tempPoint.setPoint(currentPoint.getX() - 1, 0);
            } else {
                tempPoint.setPoint(currentPoint.getX() + 1, 0);
            }
        } else {
            if (currentPoint.getY() == 0) {
                tempPoint.setPoint(currentPoint.getX() + 1, 0);
            } else {
                tempPoint.setPoint(currentPoint.getX() - 1, 0);
            }
        }
        return tempPoint;
    }

    private boolean checkPoint(SnakePoint point) {
        return checkPoint(point.getX(), point.getY());
    }

    private boolean checkPoint(int x, int y) {
        // 边界判断
        if (x < 0 || y < 0 || x > width - 1 || y > height - 1) {
            return false;
        }
        // 是否存在判断
        for (SnakePoint point : snake) {
            if (point.getX() == x && point.getY() == y) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String[][] format = new String[height][width];
        for (SnakePoint point : snake) {
            format[point.getY()][point.getX()] = point.getValue().toString();
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String value = format[i][j];
                buffer.append(value);
                for (int space = 10; space > value.length(); space--) {
                    buffer.append(" ");
                }
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Convertible<Integer> numericConvert = new NumericConvert();
        SnakeGo<Integer> snakeGo = new SnakeGo<>(10, 5, 0, 0, 0, numericConvert);
        snakeGo.build();

        System.out.println(snakeGo);
    }
}
