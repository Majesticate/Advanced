package PokemonTrainer;


public class Trainer {
    private final int DEFAULT_BADGES_NUMBER = 0;
    private String name;
    private int badges;

    public Trainer(String name) {
        this.name = name;
        this.badges = DEFAULT_BADGES_NUMBER;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }
}
