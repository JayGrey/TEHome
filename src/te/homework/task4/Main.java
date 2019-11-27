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
    private static Triangle findMinBySquare(List<Triangle> list) {
        return Collections.min(list, Comparator.comparingDouble(t -> t.square));
    }

    private static Triangle findMaxBySquare(List<Triangle> list) {
        return Collections.max(list, Comparator.comparingDouble(t -> t.square));
    }

    static Triangle findMinByPerimeter(List<Triangle> list) {
        return Collections.min(list, Comparator.comparingDouble(t -> t.perimeter));
    }

    static Triangle findMaxByPerimeter(List<Triangle> list) {
        return Collections.max(list, Comparator.comparingDouble(t -> t.perimeter));
    }

    public static void main(String[] args) {
        Triangle[] triangles = new Triangle[]{
                new Triangle(Point.of(1, 2), Point.of(5, 2), Point.of(1, 6)),
                new Triangle(Point.of(1, 1), Point.of(4, 1), Point.of(1, 5)),
                new Triangle(Point.of(1, 1), Point.of(4, 1), Point.of(1, 4)),
                new Triangle(Point.of(1, 1), Point.of(7, 1), Point.of(4, 6.196152423)),
                new Triangle(Point.of(0, 0), Point.of(1, 2), Point.of(3, 0)),
        };

        Map<Triangle.Type, List<Triangle>> sortedByType = new HashMap<>();

        for (Triangle triangle : triangles) {
            List<Triangle> list = sortedByType.getOrDefault(triangle.type, new ArrayList<>());
            list.add(triangle);
            sortedByType.put(triangle.type, list);
        }

        sortedByType.forEach((t, l) -> {
            System.out.format("type: %s%n", t.toString());
            System.out.format("total: %d%n", l.size());
            System.out.format("square min: %.5f%n", findMinBySquare(l).square);
            System.out.format("square max: %.5f%n", findMaxBySquare(l).square);
            System.out.format("perimeter min: %.5f%n", findMinByPerimeter(l).perimeter);
            System.out.format("perimeter max: %.5f%n%n", findMaxByPerimeter(l).perimeter);
        });
    }
}
