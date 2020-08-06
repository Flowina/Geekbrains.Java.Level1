package Lesson7;

import java.text.DecimalFormat;

public class Plate {
    private static DecimalFormat df = new DecimalFormat("0.00");
    private float value;
    private float capacity;

    public Plate(float capacity) {
        this.capacity = capacity;
    }

    // добавляет еду в тарелку, но не более, чем может поместиться
    public void addFood(float value){
        float newValue = this.value + value;
        if (newValue > this.capacity) {
            this.value = this.capacity;
        } else {
            this.value = newValue;
        }
    }

    // достает еду из тарелки в указанном объеме,
    // но не более, чем доступно
    public float getFood(float value){
        float result;
        if (this.value < value) {
            result = this.value;
            this.value = 0;
        } else {
            this.value = this.value - value;
            result = value;
        }

        return result;
    }

    // возвращает текущий объем еды в тарелке
    public float getValue() {
        return this.value;
    }

    public void info() {
        System.out.println("Plate: capacity = " + capacity + ", value = " + value + " (" + df.format(value * 100 / capacity) + "%)");
    }
}
