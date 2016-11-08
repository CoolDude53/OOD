package HW7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class SimpleHW7Test
{
    public static void main(String[] args)
    {
        Polynomial x = new Variable("x");
        Polynomial y = new Variable("y");
        Polynomial three = new Number(3);
        Polynomial xPlusThree = new PlusOp(x, three);
        Polynomial p = new ProductOp(xPlusThree, y);

        String s = p.toString();
        System.out.println(s + "\n");

        //((x * 1) + 3) * ((y + 0) + (z * 0))
        Polynomial one = new Number(1);
        Polynomial xTimesOne = new ProductOp(x, one);
        Polynomial firstTerm = new PlusOp(xTimesOne, three);
        Polynomial z = new Variable("z");
        Polynomial zero = new Number(0);
        Polynomial yPlusZero = new PlusOp(y, zero);
        Polynomial zTimesZero = new ProductOp(z, zero);
        Polynomial secondTerm = new PlusOp(yPlusZero, zTimesZero);
        Polynomial finalTerm = new ProductOp(firstTerm, secondTerm);

        HashMap<String, Integer> varMap = new HashMap<>();
        varMap.put("x", 3);
        varMap.put("y", 4);
        varMap.put("z", 5);
        System.out.println(finalTerm);
        System.out.println(finalTerm.evaluate(varMap));
        System.out.println(finalTerm.reduce());
        System.out.println(getVarsExternal(finalTerm));
        System.out.println(getVarsInternal(finalTerm) + "\n");


        //((x + 3) * y) + ((z + x) – (x + z))
        Polynomial firstTerm2 = new ProductOp(xPlusThree, y);
        Polynomial zPlusX = new PlusOp(z, x);
        Polynomial xPlusZ = new PlusOp(x, z);
        Polynomial secondTerm2 = new MinusOp(zPlusX, xPlusZ);
        Polynomial finalTerm2 = new PlusOp(firstTerm2, secondTerm2);

        System.out.println(finalTerm2);
        System.out.println(finalTerm2.evaluate(varMap));
        System.out.println(finalTerm2.reduce());
        System.out.println(getVarsExternal(finalTerm2));
        System.out.println(getVarsInternal(finalTerm2));
    }

    private static Set<Variable> getVarsExternal(Polynomial p)
    {
        HashSet<Variable> vars = new HashSet<>();

        for (Polynomial poly : p)
        {
            if (!poly.iterator().hasNext())
            {
                try
                {
                    poly.evaluate(null);
                } catch (NoSuchElementException ignored)
                {
                    vars.add((Variable) poly);
                }
            }
        }

        return vars;
    }

    private static Set<Variable> getVarsInternal(Polynomial p)
    {
        HashSet<Variable> vars = new HashSet<>();

        p.traverse(polynomial ->
        {
            if (!polynomial.iterator().hasNext())
            {
                try
                {
                    polynomial.evaluate(null);
                } catch (NoSuchElementException ignored)
                {
                    vars.add((Variable) polynomial);
                }
            }
        });

        return vars;
    }
}
