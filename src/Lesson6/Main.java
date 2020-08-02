package Lesson6;

public class Main {

    public static void main(String[] args) throws Exception {
        animalsDo();
        overrideRunDistance();
        catsNotSweems();
    }

    public static void animalsDo() {
        System.out.println("*** animalsDo ***");
        Animal[] pets = new Animal[2];
        pets[0] = new Cat("Lucky");
        pets[1] = new Dog("Bim");

        for (Animal pet :
                pets) {
            pet.animalInfo();
            pet.run(150);
            pet.jump(5);
            pet.swim(3);
        }
    }

    public static void  overrideRunDistance() {
        System.out.println("*** overrideRunDistance ***");
        Dog dog1 = new Dog("dog1");
        dog1.setMaxRunDistance(50);
        Dog dog2 = new Dog("dog2");
        Dog[] dogs = {
                dog1,
                dog2
        };

        for (Dog dog :
                dogs) {
            dog.animalInfo();
            dog.run(150);
        }
    }

    public static void catsNotSweems() throws Exception {
        System.out.println("*** catsNotSweems ***");

        try {
            Cat cat = new Cat("cat1");
            cat.setMaxSwimDistance(10);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}


