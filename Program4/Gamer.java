/*
 Program 4
 Name: Tien Nguyen
 Date:April-20-2016
 Class:Computer Science 150
 Description: This class is for program 4 to set and get the values. 
Override the tring and use comparator to compare the stats and professions.
 */
package program4;

import java.util.Comparator;

/**
 *
 * @author tiennguyen
 */
public class Gamer {
       
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int strength;
    private int fighter;
    private int ranger;
    private int mage;
    private int cleric;
    private int rouge;
    private int bard;
   
//declared the variables and makes getters and setters
    public int getFighter() {
        return fighter;
    }

    public int getRanger() {
        return ranger;
    }

    public int getMage() {
        return mage;
    }

    public int getCleric() {
        return cleric;
    }

    public int getRouge() {
        return rouge;
    }

    public int getBard() {
        return bard;
    }

    public void setFighter(int fighter) {
        this.fighter = fighter;
    }

    public void setRanger(int ranger) {
        this.ranger = ranger;
    }

    public void setMage(int mage) {
        this.mage = mage;
    }

    public void setCleric(int cleric) {
        this.cleric = cleric;
    }

    public void setRouge(int rouge) {
        this.rouge = rouge;
    }

    public void setBard(int bard) {
        this.bard = bard;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    //This formula calculates the profession to evaluate the quality of a stat block. 
    public void formula() {
        fighter = ((strength * 10) + (constitution * 5) + (dexterity * 5) + (wisdom * 2) + (charisma * 2) + intelligence);
        ranger = ((constitution * 10) + (strength * 5) + (wisdom * 5) + (intelligence * 2) + (dexterity * 2) + charisma);
        mage = ((intelligence * 10) + (wisdom * 5) + (charisma * 5) + (strength * 2) + (dexterity * 2) + constitution);
        cleric = ((wisdom * 10) + (constitution * 5) + (charisma * 5) + (strength * 2) + (intelligence * 2) + dexterity);
        rouge = ((dexterity * 10) + (strength * 5) + (intelligence * 5) + (constitution * 2) + (charisma * 2) + wisdom);
        bard = ((charisma * 10) + (intelligence * 5) + (dexterity * 5) + (wisdom * 2) + (constitution * 2) + strength);

    }
    //store the 10 stat blocks followed by their rating for each profession. 
    @Override
    public String toString() {
        return "Str=" + strength + "  "
                + "Con=" + constitution + "  "
                + "Int=" + intelligence + "  "
                + "Wis=" + wisdom + "  "
                + "Dex=" + dexterity + "  "
                + "Cha=" + charisma + "  "
                + "Fighter=" + fighter + "  "
                + "Ranger=" + ranger + "  "
                + "Mage=" + mage + "  "
                + "Cleric=" + cleric + "  "
                + "Rouge=" + rouge + "  "
                + "Bard=" + bard + "  ";
    }
    
    //compare the 2stats and 2profession using the comparator
     public static Comparator<Gamer> intelligenceComp = new Comparator<Gamer>() {
        @Override
        public int compare(Gamer stat1, Gamer stat2) {
            return stat1.getIntelligence() - stat2.getIntelligence();
        }
    };
    public static Comparator<Gamer> constitutionComp = new Comparator<Gamer>() {
        @Override
        public int compare(Gamer stat1, Gamer stat2) {
            return stat1.getConstitution() - stat2.getConstitution();
        }
    };
    public static Comparator<Gamer> wisdomComp = new Comparator<Gamer>() {
        @Override
        public int compare(Gamer stat1, Gamer stat2) {
            return stat1.getWisdom() - stat2.getWisdom();
        }
    };
    public static Comparator<Gamer> dexterityComp = new Comparator<Gamer>() {
        @Override
        public int compare(Gamer stat1, Gamer stat2) {
            return stat1.getDexterity() - stat2.getDexterity();
        }
    };
    public static Comparator<Gamer> charismaComp = new Comparator<Gamer>() {
        @Override
        public int compare(Gamer stat1, Gamer stat2) {
            return stat1.getCharisma() - stat2.getCharisma();
        }
    };
    public static Comparator<Gamer> strengthComp = new Comparator<Gamer>() {
        @Override
        public int compare(Gamer stat1, Gamer stat2) {
            return stat1.getStrength() - stat2.getStrength();
        }
    };
    public static Comparator<Gamer> fighterComp = new Comparator<Gamer>() {
        @Override
        public int compare(Gamer stat1, Gamer stat2) {
            return stat1.getFighter() - stat2.getFighter();
        }
    };
    public static Comparator<Gamer> rangerComp = new Comparator<Gamer>() {
        @Override
        public int compare(Gamer stat1, Gamer stat2) {
            return stat1.getRanger() - stat2.getRanger();
        }
    };
    public static Comparator<Gamer> bardComp = new Comparator<Gamer>() {
        @Override
        public int compare(Gamer stat1, Gamer stat2) {
            return stat1.getBard() - stat2.getBard();
        }
    };
    public static Comparator<Gamer> rougeComp = new Comparator<Gamer>() {
        @Override
        public int compare(Gamer stat1, Gamer stat2) {
            return stat1.getRouge() - stat2.getRouge();
        }
    };
    public static Comparator<Gamer> clericComp = new Comparator<Gamer>() {
        @Override
        public int compare(Gamer stat1, Gamer stat2) {
            return stat1.getCleric() - stat2.getCleric();
        }
    };
    public static Comparator<Gamer> mageComp = new Comparator<Gamer>() {
        @Override
        public int compare(Gamer stat1, Gamer stat2) {
            return stat1.getMage() - stat2.getMage();
        }
    
            };
}