package testing.java;
import org.example.logic.Operations;
import org.example.model.Polynomial;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestingUnit {
    @Test
    public void testAddition(){
        //Arrange
        String polynomialString="+5x^5-2x^2+1";
        String polynomialString1 = "+1x^7-4x^3-3x^2+1";

        Polynomial p1 = new Polynomial();
        Polynomial p2=new Polynomial();
        final Operations op=new Operations();

        Polynomial.fromString(polynomialString, p1);
        Polynomial.fromString(polynomialString1,p2);
        Polynomial result=op.add(p1,p2);

        assertEquals(result.hashToString(),"+2.0-5.0x^2-4.0x^3+5.0x^5+1.0x^7");

    }
    @Test
    public void testSubtraction(){
        String polynomialString="+5x^5-2x^2+1";
        String polynomialString1 = "+1x^7-4x^3-3x^2+1";

        Polynomial p1 = new Polynomial();
        Polynomial p2=new Polynomial();
        final Operations op=new Operations();

        Polynomial.fromString(polynomialString, p1);
        Polynomial.fromString(polynomialString1,p2);
        Polynomial result=op.substraction(p1,p2);

        assertEquals(result.hashToString(),"+1.0x^2+4.0x^3+5.0x^5-1.0x^7");
    }

    @Test
    public void testMultiplication(){
        String polynomialString="-2x^2+1";
        String polynomialString1 ="-4x^3+1";

        Polynomial p1 = new Polynomial();
        Polynomial p2=new Polynomial();
        final Operations op=new Operations();

        Polynomial.fromString(polynomialString, p1);
        Polynomial.fromString(polynomialString1,p2);
        Polynomial result=op.multiply(p1,p2);

        assertEquals(result.hashToString(),"+1.0-2.0x^2-2.0x^3-2.0x^4+8.0x^5");
    }

    @Test
    public void testIntegration(){
        String polynomialString="-2x^3+1";

        Polynomial p1 = new Polynomial();
        final Operations op=new Operations();

        Polynomial.fromString(polynomialString, p1);
        Polynomial result=op.integrate(p1);

        assertEquals(result.hashToString(),"+1.0x-0.5x^4");
    }

    @Test
    public void testDerivation(){
        String polynomialString="-2x^3+1";

        Polynomial p1 = new Polynomial();
        final Operations op=new Operations();

        Polynomial.fromString(polynomialString, p1);
        Polynomial result=op.derivate(p1);

        assertEquals(result.hashToString(),"-6.0x^2");
    }

}
