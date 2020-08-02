package Lesson6;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
        maxRunDistance = 500;
        maxJumpHeight = 10f;
        maxSwimDistance = 0.5f;
    }
    @Override
    protected void setMaxRunDistance(float value) {
        this.maxRunDistance = value;
    }
    @Override
    protected void setMaxSwimDistance(float value) {
        this.maxSwimDistance = value;
    }
    @Override
    protected void setMaxJumpHeight(float value) {
        this.maxJumpHeight = value;
    }
}


