package rpg_lab;

public class Axe implements Weapon {

    private int attackPoints;
    private int durabilityPoints;

    public Axe(int attack, int durability) {
        this.attackPoints = attack;
        this.durabilityPoints = durability;
    }


    public void attack(Target target) {
        if (this.durabilityPoints <= 0) {
            throw new IllegalStateException("Axe is broken.");
        }

        target.takeAttack(this.attackPoints);
        this.durabilityPoints -= 1;
    }


    public int getAttackPoints() {
        return this.attackPoints;
    }

    public void setDurabilityPoints(int durabilityPoints) {
        this.durabilityPoints = durabilityPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDurability() {
        return this.durabilityPoints;
    }


}
