import java.util.HashMap;
import java.util.Objects;

public abstract class Monster {
    private Integer hp;
    private Integer xp = 10;
    private Integer maxHP;
    private HashMap<String, Integer> items;
    private Integer agi = 10;
    private Integer def = 10;
    private Integer str = 10;
    private Attack attack;


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

    public Integer getAgility() {
        return agility;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer attackTarget(Monster monster) {

        int damage = attack.attack(monster);
        monster.takeDamage(damage);
        return damage;
    }

    /**
     * This method calues if the target has taken any damage, and determines
     * if the targets hp has fallen below 0.  If the damage value is greater
     * than 0, the damaage amount is subtracted from current hp value.
     *
     * @param damage
     * @return
     */
    public boolean takeDamage(Integer damage) {
        if (damage > 0) {
            hp = hp - damage;
            System.out.println(String.format("The creature was hit for [%d] damage", damage));
            if (hp <= 0) {
                System.out.println("Oh no! the creature has perished");
                System.out.println(toString());
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * THis method returns an integer value between min and max.
     * This is goofy.  rand.nextInt(n) returns a number between 0-n
     * to get the value we want, a value between str - maxStr
     * We need to get a random number from maxStr-str and
     * add str back in.
     *
     * @param min
     * @param max
     * @return a random integer between min and max
     */
    public Integer getAttribute(Integer min, Integer max) {
        Random rand = new Random();
        if (min > max) {
            Integer temp = min;
            min = max;
            max = temp;
        }
        return rand.nextInt(max - min) + min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return Objects.equals(hp, monster.hp) &&
                Objects.equals(xp, monster.xp) &&
                Objects.equals(maxHP, monster.maxHP) &&
                Objects.equals(items, monster.items) &&
                Objects.equals(agi, monster.agi) &&
                Objects.equals(def, monster.def) &&
                Objects.equals(str, monster.str) &&
                Objects.equals(attack, monster.attack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, xp, maxHP, items, agi, def, str, attack);
    }

    @Override
    public String toString() {
        return "hp=" + getHp() + "/" + getMaxHP();
    }
}
