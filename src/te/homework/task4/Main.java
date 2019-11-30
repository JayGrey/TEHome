package te.homework.task4;

import java.util.Arrays;
import java.util.List;

/*
9. Определить класс Треугольник на плоскости, вершины которого
имеют тип Точка. Определить площадь и периметр треугольника.
Создать массив/список/множество объектов и подсчитать количество
треугольников разного типа (равносторонний, равнобедренный,
прямоугольный, произвольный). Определить для каждой группы
наибольший и наименьший по площади (периметру) объект.

* */
public class Main {

    public static void main(String[] args) {
        List<Triangle> triangles = Arrays.asList(
                Triangle.of(Point.of(1, 2), Point.of(5, 2), Point.of(1, 6)),
                Triangle.of(Point.of(1, 1), Point.of(4, 1), Point.of(1, 5)),
                Triangle.of(Point.of(1, 1), Point.of(4, 1), Point.of(1, 4)),
                Triangle.of(Point.of(1, 1), Point.of(7, 1), Point.of(4, 6.196152423)),
                Triangle.of(Point.of(0, 0), Point.of(1, 2), Point.of(3, 0))
        );

        Triangles.sortByType(triangles).forEach((t, l) -> {
            System.out.format("type: %s%n", t.toString());
            System.out.format("total: %d%n", l.size());
            System.out.format("square min: %.5f%n", Triangles.findTriangleWithMinSquare(l).square);
            System.out.format("square max: %.5f%n", Triangles.findTriangleWithMaxSquare(l).square);
            System.out.format("perimeter min: %.5f%n",
                    Triangles.findTriangleWithMinPerimeter(l).perimeter);
            System.out.format("perimeter max: %.5f%n%n",
                    Triangles.findTriangleWithMaxPerimeter(l).perimeter);
        });
    }
}
