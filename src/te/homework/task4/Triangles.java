package te.homework.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public interface Triangles {
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

    static Optional<Triangle> stringToTriangle(String string) {
        try {
            String[] coords = string.trim().split("\\s+");
            return Optional.of(Triangle.of(
                    Point.of(Double.parseDouble(coords[0]), Double.parseDouble(coords[1])),
                    Point.of(Double.parseDouble(coords[2]), Double.parseDouble(coords[3])),
                    Point.of(Double.parseDouble(coords[4]), Double.parseDouble(coords[5]))
            ));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    static List<Triangle> loadFrom(String filename) {
        try {
            return Files.lines(Paths.get(filename))
                    .map(Triangles::stringToTriangle)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
