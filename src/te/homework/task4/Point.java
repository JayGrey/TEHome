package te.homework.task4;

import java.util.Objects;

public class Point {
    public final double x;
    public final double y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    static Point of(double x, double y) {
        if (!Double.isFinite(x) || !Double.isFinite(y)) {
            throw new IllegalArgumentException("Values must be finite");
        }

        return new Point(x, y);
    }

    double distance(Point other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }

        return Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2));
    }

    @Override
    public String toString() {
        return String.format("Point[%f; %f]", x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
