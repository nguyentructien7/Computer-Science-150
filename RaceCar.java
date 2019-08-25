package program1;

public class RaceCar implements Comparable<RaceCar>{

    private String carNumber;
    private String driverName;
    private int points;
    private int races;
    private int wins;
    private int ledLaps;
    private int ledMostLaps;
    private int rank;

    public RaceCar() {
        carNumber = "";
        driverName = "";
        points = 0;
        races = 0;
        wins = 0;
        ledLaps = 0;
        ledMostLaps = 0;
        rank=1;

    }
 public void setRank(int rank){
        
            this.rank = rank;
       
    }
    public int getRank(){
        return rank;
    }
    public String getCarNumber() {
        return carNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setPoints(int points) {

        
            this.points += points;
       

    }

    public void setRaces() {
        
            this.races ++;
     
    }

    public void setWins() {
        
            this.wins++;
       
    }

    public void setLedLaps() {
        
            this.ledLaps++;
        
    }

    public void setLedMostLaps() {
        
            this.ledMostLaps++;
       
    }

    public void setCarNumber(String carNumb) {
        this.carNumber = carNumb;
   
    }

    public void setDriverName(String driver) {
        this.driverName = driver;
        
    } 

    public int getPoints() {
        return points;
    }

    public int getRaces() {
        return races;
    }

    public int getWins() {
        return wins;
    }

    public int getLedLaps() {
        return ledLaps;
    }

    public int getLedMostLaps() {
        return ledMostLaps;
    }

  public int compareTo(RaceCar person)
  {
      int compareqty = ((RaceCar)person).getPoints();
      
      return compareqty - this.points;
  }

 

}
