package te.homework.task4;

import java.util.*;

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
}
