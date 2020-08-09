package Lesson7;

public class Cat extends Animal {
    public Cat(String name, float appetite ) {
        super(name);
        maxRunDistance = 200;
        maxJumpHeight = 2f;
        maxSwimDistance = 0;
        this.setFull(false);
        this.setAppetite(appetite);
    }

    @Override
    protected void setMaxRunDistance(float value) {
        this.maxRunDistance = value;
    }

    @Override
    protected void setMaxSwimDistance(float value) throws Exception {
        throw new Exception("Cat's don't like to sweem");
    }

    @Override
    protected void setMaxJumpHeight(float value) {
        this.maxJumpHeight = value;
    }

    @Override
    public void swim(float distance) {
        System.out.println("swim: " + false);
    }

    // каждого кота есть аппетит, т.е. количество еды, которое он съедает за один раз
    private float appetite;

    //Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
    // Если коту удалось поесть (хватило еды), сытость = true;
    private boolean isFull;

    public void eat(Plate plate){
        if (plate.getValue() >= getAppetite()) {
            plate.getFood(getAppetite());
            this.setFull(true);
        }
    }

    @Override
    public void animalInfo() {
        super.animalInfo();
        System.out.println("Is full: " + isFull());
    }

    public float getAppetite() {
        return appetite;
    }

    public void setAppetite(float appetite) {
        this.appetite = appetite;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
