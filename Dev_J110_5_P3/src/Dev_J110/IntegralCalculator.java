
package Dev_J110;

import java.util.function.BiFunction;

//Это класс, который умеет вычислять определенный интеграл двумерной функции
public class IntegralCalculator { 
    
    public static double calculator(BiFunction<Double, Double, Double> bi, double xS, double xF, double yS, double yF, int segments) {
           if(segments > 0) {
               double integral = 0;
               double cellSquare = ((xF - xS) * (yF - yS)) / Math.pow(segments, 2);
               double deltaX = (xF - xS)/(2 * segments);
               double deltaY = (yF - yS)/(2 * segments); 
               double currentX = xS;
               double currentY = yS;
               for(int j = 0; j < segments; j++) {                  
                   for(int i = 0; i < segments; i++) {
                      integral += bi.apply((currentX + deltaX), (currentY + deltaY)) * cellSquare; 
    /*Закомментные System.out.print используются для отладки и котнроля. Выводят в консоль массив координат X и Y, для которых производится вычисление
      значения функции в каждом прямоугольнике. Пара координат - центр прямоугольника, т.е. точка пересечения его диагоналей.
    */
                      //System.out.printf("[X=%4.4f, Y=%4.4f]  ", (currentX + deltaX), (currentY + deltaY)); 
                      currentX += 2*deltaX;                     
                   }
                   currentX = xS;
                   currentY += 2*deltaY;
                   //System.out.println();
               }           
                //System.out.printf("S прямоугольника =%.5f%n", cellSquare);                
                return integral;   }                      
            else
               throw new IllegalArgumentException("Количество прямоугольников задано некорректно.");
    }
         
}
