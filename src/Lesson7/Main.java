package Lesson7;

public class Main {

    public static void main(String[] args) throws Exception {
        Plate plate = CreatePlate(2.5f);
        Cat[] cats = CreateCats();
        Test(plate, cats);
    }

    private static void Test(Plate plate, Cat[] cats) {
        for (Cat cat :
                cats) {

            if (plate.getValue() < cat.getAppetite()) {
                System.out.println("Недостаточно еды в миске. Кол-во: " + plate.getValue() + ", аппетит " + cat.name + " = " + cat.getAppetite());
                System.out.println("Наполняем миску на " + cat.getAppetite());
                plate.addFood(cat.getAppetite());
            }
            cat.eat(plate);
            cat.animalInfo();
            plate.info();
        }
    }

    private static Plate CreatePlate(float capacity) {
        Plate plate = new Plate(capacity);
        //заполним 1/2
        plate.addFood(capacity * 0.5f);
        return plate;
    }

    private static Cat[] CreateCats() {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Tom", 0.5f);
        cats[1] = new Cat("Murzik", 0.7f);
        cats[2] = new Cat("Glutton", 1f);
        return cats;
    }
}


