
package Dev_J110;

import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
 
    /*Вызов метода вычисления интеграла с использованием реализации функционального интерфейса 
     BiFunction через вложенный класс Xy. */
    double xy = IntegralCalculator.calculator(new Xy(), 1, 3, 1, 3, 100); 
    
    /*Вызов метода вычисления интеграла с использованием реализации функционального интерфейса 
     BiFunction через анонимный внутренний класс. */
    double mnogoXy = IntegralCalculator.calculator(new BiFunction<Double, Double, Double>() {
        @Override
        public Double apply(Double x, Double y) {
              return (Math.pow(x, 2) + x) * (2 * y + 1); }
              }, 3, 4, 7, 10, 100);
    
    /*Вызов метода вычисления интеграла с использованием реализации функционального интерфейса
      BiFunction через ссылку на метод экземпляра.*/
    Exponenta e = new Exponenta();
    double exp = IntegralCalculator.calculator(e::getValue, 0.01, 2, 0.5, 4, 100);    
    
    /*Вызов метода вычисления интеграла с использованием реализации функционального интерфейса 
      BiFunction через ссылку на статический метод.*/
    double sum = IntegralCalculator.calculator(SumX2Y3::getValue, 1, 3, 1, 2, 100);

    /*Вызов метода вычисления интеграла с использованием реализации функционального интерфейса 
      BiFunction через лямбда-выражение. */
    double sin = IntegralCalculator.calculator((x,y) -> x * y * Math.sin(x * y), 0, 1, 0, 1, 100);

        System.out.println("\u222Bx\u0387y = " + xy);
        System.out.println("\u222B(x\u00B2+x)\u0387(2y+1) = " + mnogoXy); 
        System.out.println("\u222Be^(-x\u0387y) = " + exp); 
        System.out.println("\u222Bx\u00B2+y\u00B3 = " + sum); 
        System.out.println("\u222Bx\u0387y\u0387Sin(x\u0387y) = " + sin); 
    } 
    
    //вложенный класс Xy.
    private static class Xy implements BiFunction<Double, Double, Double> {

        @Override
        public Double apply(Double x, Double y) {
             return x*y;
        } 
    }
}
