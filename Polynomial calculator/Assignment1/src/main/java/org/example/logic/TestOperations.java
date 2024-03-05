package org.example.logic;

import org.example.model.Polynomial;
import org.example.view.PolynomialCalculator;
import org.example.logic.Operations;

public class TestOperations {
    public TestOperations() {
        Operations op=new Operations();
        Polynomial p1 = new Polynomial();
        Polynomial p2=new Polynomial();

        String polynomialString="+5x^5-2x^2+1";
        String polynomialString1 = "+1x^7-4x^3-3x^2+1";

        Polynomial.fromString(polynomialString,p1);
        Polynomial.fromString(polynomialString1,p2);

        System.out.println(p1.hashToString());

        Polynomial.showPolynom(p1);

        System.out.println(p1.getMaxDegree());
        System.out.println(p2.getMaxDegree());

        System.out.println(p1.poly);
        System.out.println(p2.getPoly());

        Polynomial r=op.add(p1,p2);
        System.out.println(r.getPoly());

        r=op.substraction(p1,p2);
        System.out.println(r.hashToString());
    }

}
