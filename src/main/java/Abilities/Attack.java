package Abilities;

import Monsters.Monster;

public interface Attack extends Ability{
    Integer attack(Monster target);
}
