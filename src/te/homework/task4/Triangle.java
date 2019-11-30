package te.homework.task4;

import java.util.*;

public class Triangle {
    private static final double EPSILON = 1E-8;

    final Point a;
    final Point b;
    final Point c;

    final double square;
    final double perimeter;
    final Set<Type> type;

    private Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        square = getSquare();
        perimeter = getPerimeter();
        type = getType();
    }

    static Triangle of(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException();
        }
        return new Triangle(a, b, c);
    }

    private double getSquare() {
        return Math.abs((a.x - c.x) * (b.y - c.y) - (a.y - c.y) * (b.x - c.x)) / 2;
    }

    private double getPerimeter() {
        return a.distance(b) + b.distance(c) + c.distance(a);
    }

    private boolean isEquilateral() {
        double ab = a.distance(b);
        double bc = b.distance(c);
        double ac = a.distance(c);

        return Math.abs(ab - bc) < EPSILON && Math.abs(ab - ac) < EPSILON;

    }

    private boolean isIsosceles() {
        double ab = a.distance(b);
        double bc = b.distance(c);
        double ac = c.distance(a);

        return Math.abs(ab - bc) < EPSILON
                || Math.abs(ac - bc) < EPSILON
                || Math.abs(ac - ab) < EPSILON;
    }

    private boolean isRight() {
        double[] sides = new double[3];
        sides[0] = a.distance(b);
        sides[1] = b.distance(c);
        sides[2] = c.distance(a);

        Arrays.sort(sides);

        return Math.pow(sides[0], 2) + Math.pow(sides[1], 2) - Math.pow(sides[2], 2) < EPSILON;
    }

    private Set<Type> getType() {
        Set<Type> result = new HashSet<>();

        if (isEquilateral()) {
            result.add(Type.EQUILATERAL);
        }

        if (isIsosceles()) {
            result.add(Type.ISOSCELES);
        }

        if (isRight()) {
            result.add(Type.RIGHT);
        }

        if (result.isEmpty()) {
            result.add(Type.ARBITRARY);
        }

        return Collections.unmodifiableSet(EnumSet.copyOf(result));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) o;
        return a.equals(triangle.a) &&
                b.equals(triangle.b) &&
                c.equals(triangle.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    enum Type {EQUILATERAL, ISOSCELES, RIGHT, ARBITRARY}

}
