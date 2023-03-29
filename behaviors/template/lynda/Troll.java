package designPatterns.behaviors.template.lynda;

public class Troll extends Character{

    public void chooseWeapons(){
        System.out.println("Pick up club");
    }

    public void fight(){
        System.out.println("Defend with club");
    }

    public void returns(){
        System.out.println("Return to the mountain");

    }
    public void defendAgainstAttack() {
        chooseWeapons();
        fight();
        returns();
    }
}
