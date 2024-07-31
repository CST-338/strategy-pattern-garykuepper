package Abilities;
import Monsters.Monster;
public class RangedAttack implements Attack{

    Monster attacker;

    public RangedAttack(Monster attacker) {
        this.attacker = attacker;
    }

    @Override
    public Integer attack(Monster target) {
        String message = attacker + " uses a range attack on " + target;
        System.out.println(message);
        return attacker.getAgility() - target.getDefense();
    }
}
