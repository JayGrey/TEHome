package te.homework.task4;

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

    private static void prettyPrint(Triangle.Type type, List<Triangle> triangles) {
        System.out.format("type: %s%n", type.toString());
        System.out.format("total: %d%n", triangles.size());
        System.out.format("square min: %.5f%n", Triangles.findTriangleWithMinSquare(triangles).square);
        System.out.format("square max: %.5f%n", Triangles.findTriangleWithMaxSquare(triangles).square);
        System.out.format("perimeter min: %.5f%n",
                Triangles.findTriangleWithMinPerimeter(triangles).perimeter);
        System.out.format("perimeter max: %.5f%n%n",
                Triangles.findTriangleWithMaxPerimeter(triangles).perimeter);
    }

    public static void main(String[] args) {

        Triangles.sortByType(Triangles.loadFrom("triangles.txt")).forEach(Main::prettyPrint);
    }
}
