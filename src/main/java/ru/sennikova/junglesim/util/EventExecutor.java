package ru.sennikova.junglesim.util;

import ru.sennikova.junglesim.entity.Dolphin;

public class EventExecutor {

    public void startSimulation(Dolphin dolphin) {
        while (dolphin.getHealth() > 0) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 16) {
                swimEvent(dolphin);
            } else if (eventNumber >= 16 && eventNumber < 30) {
                sleepEvent(dolphin);
            } else if (eventNumber >= 31 && eventNumber < 40) {
                dolphinEat(dolphin);
            } else if (eventNumber >= 40 && eventNumber < 46) {
                poacherAttack(dolphin);
            } else if (eventNumber >= 46 && eventNumber < 51) {
                helpDrowning(dolphin);
            } else if (eventNumber >= 51 && eventNumber < 54) {
                rescueFromShark(dolphin);
            } else if (eventNumber >= 54 && eventNumber < 65) {
                fishnetTangledUp(dolphin);
            } else if (eventNumber >= 65 && eventNumber < 70) {
                dolphinariumEvent(dolphin);
                break;
            } else if (eventNumber >= 70 && eventNumber < 82) {
                dolphinEatLite(dolphin);
            } else if (eventNumber >= 83 && eventNumber < 91) {
                jumpOut(dolphin);
            } else if (eventNumber >= 91 && eventNumber <= 100) {
                surfingEvent(dolphin);
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        System.out.println("The end!!");
    }

    private void sleepEvent(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        energy = energy + 100;
        dolphin.setEnergy(energy);
        System.out.println("Дельфин поспал. Вся энергия: " + dolphin.getEnergy() + " Все здоровье: " + dolphin.getHealth());
    }

    private void swimEvent(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        int health = dolphin.getHealth();
        energy = energy - 100;
        dolphin.setEnergy(energy);
        dolphin.setHealth(health);
        checkEnergy(dolphin);
        checkHP(dolphin);
        System.out.println("Дельфин проплыл одну морскую милю. На пути не встретилось достойная пища. Вся энергия: " + dolphin.getEnergy() + " Все здоровье: " + dolphin.getHealth());
    }

    private void dolphinEat(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        int health = dolphin.getHealth();
        energy = energy - 50;
        health = health + dolphin.getFeed() * 6;
        dolphin.setEnergy(energy);
        dolphin.setHealth(health);
        checkEnergy(dolphin);
        checkHP(dolphin);
        System.out.println("Дельфин съел осьминога или небольшую акулу. Вся энергия: " + dolphin.getEnergy() + " Все здоровье: " + dolphin.getHealth());    //данные о рационе дельфинов взяты из википедии
    }

    private void poacherAttack(Dolphin dolphin) {
        int health = dolphin.getHealth();
        int energy = dolphin.getEnergy();
        health = health - 300;
        energy = energy - 200;
        dolphin.setHealth(health);
        dolphin.setEnergy(energy);
        checkEnergy(dolphin);
        checkHP(dolphin);
        System.out.println("На дельфина напали браконьеры! Вся энергия: " + dolphin.getEnergy() + " Все здоровье: " + dolphin.getHealth());
    }

    private void helpDrowning(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        int health = dolphin.getHealth();
        energy = energy - 200;
        dolphin.setEnergy(energy);
        dolphin.setHealth(health);
        checkEnergy(dolphin);
        checkHP(dolphin);
        System.out.println("Дельфин помог тонущему человеку! Вся энергия: " + dolphin.getEnergy() + " Все здоровье: " + dolphin.getHealth());
    }

    private void rescueFromShark(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        int health = dolphin.getHealth();
        energy = energy - 300;
        health = health - 150;
        dolphin.setEnergy(energy);
        dolphin.setHealth(health);
        checkEnergy(dolphin);
        checkHP(dolphin);
        System.out.println("Дельфин спас пловца от белой акулы! Вся энергия: " + dolphin.getEnergy() + " Все здоровье: " + dolphin.getHealth());  //Такие случаи реально бывают
    }

    private void fishnetTangledUp(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        int health = dolphin.getHealth();
        energy = energy - 400;
        health = health - 100;
        dolphin.setEnergy(energy);
        dolphin.setHealth(health);
        checkEnergy(dolphin);
        checkHP(dolphin);
        System.out.println("Дельфин запутался в рыболовных сетях!! Вся энергия: " + dolphin.getEnergy() + " Все здоровье: " + dolphin.getHealth());
    }

    private void dolphinEatLite(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        int health = dolphin.getHealth();
        energy = energy - 20;
        health = health + dolphin.getFeed() * 2;
        dolphin.setEnergy(energy);
        dolphin.setHealth(health);
        checkEnergy(dolphin);
        checkHP(dolphin);
        System.out.println("Дельфин поел мелкой рыбы или креветок. Вся энергия: " + dolphin.getEnergy() + " Все здоровье: " + dolphin.getHealth());
    }

    private void jumpOut(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        int health = dolphin.getHealth();
        energy = energy - 50;
        dolphin.setEnergy(energy);
        dolphin.setHealth(health);
        checkEnergy(dolphin);
        checkHP(dolphin);
        System.out.println("Дельфин выпрыгнул на 4-5 метров из воды, чтобы полюбоваться красивым закатом или восхитительным рассветом. Настроение: 1000. Вся энергия: " + dolphin.getEnergy() + " Все здоровье: " + dolphin.getHealth());
    }

    private void surfingEvent(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        int health = dolphin.getHealth();
        energy = energy - 30;
        dolphin.setEnergy(energy);
        dolphin.setHealth(health);
        checkEnergy(dolphin);
        checkHP(dolphin);
        System.out.println("Дельфин катается на волнах, создаваемых судами. Настроение: 1000. Вся энергия: " + dolphin.getEnergy() + " Все здоровье: " + dolphin.getHealth());
    }

    private void dolphinariumEvent(Dolphin dolphin) {
        System.out.println("Дельфина поймали, чтобы до конца его дней заключить в дельфинарий.");
    }

    private void checkHP(Dolphin dolphin) {
        int health = dolphin.getHealth();
        if (health <= 0) {
            health = 0;
        }
        if (health > 1000) {
            health = 1000;
        }
        dolphin.setHealth(health);
    }

    private void checkEnergy(Dolphin dolphin) {
        int health = dolphin.getHealth();
        int energy = dolphin.getEnergy();
        if (energy < 0) {
            energy = 0;
            health = health - 10;
        }
        if (energy > 1000) {
            energy = 1000;
        }
        dolphin.setEnergy(energy);
        dolphin.setHealth(health);


    }
}



