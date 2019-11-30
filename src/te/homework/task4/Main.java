package te.homework.task4;

import java.util.*;

/*
9. Определить класс Треугольник на плоскости, вершины которого
имеют тип Точка. Определить площадь и периметр треугольника.
Создать массив/список/множество объектов и подсчитать количество
треугольников разного типа (равносторонний, равнобедренный,
прямоугольный, произвольный). Определить для каждой группы
наибольший и наименьший по площади (периметру) объект.

* */
public class Main {
    static Triangle findTriangleWithMinSquare(List<Triangle> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("list must not be null");
        }

        return Collections.min(list, Comparator.comparingDouble(t -> t.square));
    }

    static Triangle findTriangleWithMaxSquare(List<Triangle> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("list must not be null");
        }

        return Collections.max(list, Comparator.comparingDouble(t -> t.square));
    }

    static Triangle findTriangleWithMinPerimeter(List<Triangle> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("list must not be null");
        }

        return Collections.min(list, Comparator.comparingDouble(t -> t.perimeter));
    }

    static Triangle findTriangleWithMaxPerimeter(List<Triangle> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("list must not be null");
        }

        return Collections.max(list, Comparator.comparingDouble(t -> t.perimeter));
    }

    static Map<Triangle.Type, List<Triangle>> sortByType(List<Triangle> triangles) {

        if (triangles == null) {
            throw new IllegalArgumentException("list must not be null");
        }

        Map<Triangle.Type, List<Triangle>> result = new HashMap<>();

        for (Triangle triangle : triangles) {
            for (Triangle.Type t : Triangle.Type.values()) {
                if (triangle.type.contains(t)) {
                    List<Triangle> list = result.getOrDefault(t, new ArrayList<>());
                    list.add(triangle);
                    result.put(t, list);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Triangle> triangles = Arrays.asList(
                Triangle.of(Point.of(1, 2), Point.of(5, 2), Point.of(1, 6)),
                Triangle.of(Point.of(1, 1), Point.of(4, 1), Point.of(1, 5)),
                Triangle.of(Point.of(1, 1), Point.of(4, 1), Point.of(1, 4)),
                Triangle.of(Point.of(1, 1), Point.of(7, 1), Point.of(4, 6.196152423)),
                Triangle.of(Point.of(0, 0), Point.of(1, 2), Point.of(3, 0))
        );

        sortByType(triangles).forEach((t, l) -> {
            System.out.format("type: %s%n", t.toString());
            System.out.format("total: %d%n", l.size());
            System.out.format("square min: %.5f%n", findTriangleWithMinSquare(l).square);
            System.out.format("square max: %.5f%n", findTriangleWithMaxSquare(l).square);
            System.out.format("perimeter min: %.5f%n", findTriangleWithMinPerimeter(l).perimeter);
            System.out.format("perimeter max: %.5f%n%n", findTriangleWithMaxPerimeter(l).perimeter);
        });
    }
}
