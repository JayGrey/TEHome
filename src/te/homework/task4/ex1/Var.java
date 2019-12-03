package te.homework.task4.ex1;

import java.util.Objects;

class Var {
    public final String name;
    public final int power;

    private Var(String name, int power) {
        this.name = name;
        this.power = power;
    }

    static Var of(String name, int power) {
        if (name == null || name.length() < 1 || power < 1) {
            throw new IllegalArgumentException();
        }

        return new Var(name, power);
    }

    static Var of(String name) {
        return of(name, 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Var variable = (Var) o;
        return name.equals(variable.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + (power == 1 ? "" : "^" + power);
    }
}
