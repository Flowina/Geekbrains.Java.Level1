package Lesson6;

abstract class Animal {
    protected String name;
    protected float maxRunDistance;
    protected float maxSwimDistance;
    protected float maxJumpHeight;


    public Animal(String name) {
        this.name = name;
    }

    //У каждого животного есть ограничения на действия: бег
    public float getMaxRunDistance(){
        return maxRunDistance;
    }
    protected abstract void setMaxRunDistance(float value) throws Exception;

    //У каждого животного есть ограничения на действия: плавание
    public float getMaxSwimDistance(){
        return maxSwimDistance;
    }
    protected abstract void setMaxSwimDistance(float value) throws Exception;

    //У каждого животного есть ограничения на действия: прыжок
    public float getMaxJumpHeight() {
        return  maxJumpHeight;
    }
    protected abstract void setMaxJumpHeight(float value) throws Exception;

    public void run(float distance) {
        boolean result = distance <= getMaxRunDistance();
        System.out.println("run(" + distance + "):" + result);
    }

    public void swim(float distance) {
        boolean result = distance <= getMaxSwimDistance();
        System.out.println("swim(" + distance + "):" + result);
    }

    public void jump(float height) {
        boolean result = height <= getMaxJumpHeight();
        System.out.println("jump(" + height + "):" + result);
    }

    public void animalInfo() {
        System.out.println("Animal: " + name);
    }
}


