package Lesson6;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
        maxRunDistance = 200;
        maxJumpHeight = 2f;
        maxSwimDistance = 0;
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
}
