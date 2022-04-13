
package Dev_J110;

/*Класс Exponenta с методом double getValue(double x, double y). Функциональный интерфейс 
будет реализован через ссылку на этот экземплярный метод.*/
public class Exponenta {

    public double getValue(double x, double y) {       
        return Math.exp(-(x * y));
    } 
}
