package BrawlStars;

public abstract class Brawler {

    private String name;
    private int health;


    public Brawler(String name, int health) {
        this.name = name;
        this.health = health;
    }

    //region GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    //endregion

    public void increaseHealth(int supply)
    {
        setHealth(getHealth() + supply);
    }

    public void reduceHealth(Brawler brawler, int damage)
    {
        brawler.setHealth(brawler.getHealth() - damage);
    }

    public String toString() {
        return String.format("[%s:%d]", this.getName(), this.getHealth());
    }

    public abstract void actionByType(Brawler brawler);
}