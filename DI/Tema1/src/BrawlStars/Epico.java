package BrawlStars;

public class Epico extends Brawler {
    private final int supplier;

    public Epico(String name, int health, int supplier){
        super(name, health);
        this.supplier = supplier;
    }

    @Override
    public void actionByType(Brawler brawler) {
        this.increaseHealth(supplier);
        System.out.printf("%s Increase health to %s\n%s\n", this, getHealth(), brawler);
    }
}