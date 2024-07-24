import java.util.HashMap;
import java.util.Objects;

public abstract class Monster {
    private int hp;
    private int xp = 10;
    private int maxHP;
    private HashMap<String, Integer> items;

    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.xp = xp;
        this.items = items;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return hp == monster.hp && xp == monster.xp && maxHP == monster.maxHP && Objects.equals(items, monster.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, xp, maxHP, items);
    }
    @Override
    public String toString() {
        return "has : hp=" + getHp()  +"/" + getMaxHP();
    }
}
