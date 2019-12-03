package te.homework.task4.ex1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Monomial {
    private static final double EPSILON = 1e-8;

    final double c;
    final Map<String, Integer> variables;
    final boolean isZero;

    private Monomial(double c, Map<String, Integer> variables) {
        if (!Double.isFinite(c) || variables == null) {
            throw new IllegalArgumentException();
        }

        this.isZero = Math.abs(c) <= EPSILON;
        this.c = c;
        this.variables = variables;
    }


    static Monomial of(double c, Var... variables) {
        throwIfNull(variables);

        Map<String, Integer> map = new HashMap<>();

        for (Var variable : variables) {
            if (!map.containsKey(variable.name)) {
                map.put(variable.name, variable.power);
            }
        }

        return new Monomial(c, map);
    }

    private static void throwIfNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
    }

    Monomial multiply(Monomial other) {
        throwIfNull(other);

        double newC = c * other.c;

        Map<String, Integer> newVariables = new HashMap<>(variables);
        other.variables.forEach((key, value) -> newVariables.merge(key, value, Integer::sum));

        return new Monomial(newC, newVariables);
    }

    public Monomial addSimilar(Monomial other) {
        if (variables.equals(other.variables)) {
            return new Monomial(c + other.c, variables);
        }
        return null;
    }

    @Override
    public String toString() {
        if (isZero) {
            return "";
        }

        String vars = variables.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getKey() + (e.getValue() == 1 ? "" : "^" + e.getValue()))
                .collect(Collectors.joining());
        return String.format("%.04f%s", c, vars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Monomial other = (Monomial) o;
        if (isZero == other.isZero) {
            return true;
        } else {
            return Math.abs(c - other.c) <= EPSILON &&
                    variables.equals(other.variables);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(c, variables);
    }


}
