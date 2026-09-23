package BrawlStars;

public class Legendario extends Brawler {
    private final int damage;

    public Legendario(String name, int health, int damage){
        super(name, health);
        this.damage = damage;
    }

    @Override
    public void actionByType(Brawler brawler) {
        this.reduceHealth(brawler, damage);
        System.out.printf("%s Apply -%d damage to %s\n%s\n", this, damage, brawler.getName(), brawler);
    }
}
