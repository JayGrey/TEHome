package te.homework.task4.ex1;

import java.util.Arrays;
import java.util.List;

public class Polynomial {
    List<Monomial> monomials;

    public Polynomial(Monomial[] monomials) {
        this.monomials = Arrays.asList(monomials);
    }

    static Polynomial of(Monomial... monomials) {
        return new Polynomial(monomials);
    }
}
