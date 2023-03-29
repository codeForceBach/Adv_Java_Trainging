package designPatterns.behaviors.template.lynda;

public class Pirate extends Character{
    public void chooseWeapons(){
        System.out.println("Pick up Sword");
    }

    public void fight(){
        System.out.println("Defend with sword");
    }

    public void returns(){
        System.out.println("Return to the ship");
    }
    public void defendAgainstAttack() {
        chooseWeapons();
        fight();
        returns();
    }
}
