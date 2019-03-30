/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didiraidthat;

import java.time.*;

/**
 *
 * @author siniliu
 */
public class Raid {
    private int id;
    private String star;
    private Gym gym;
    private LocalDate date;
    private LocalTime time;
    private boolean raided;
    //add int how many are attending

    
    public Raid(String star, Gym gym) {
        this.id = id;
        this.star = star;
        this.gym = gym;
        this.date = java.time.LocalDate.now();
        this.time = java.time.LocalTime.now();
        this.raided = false;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isRaided() {
        return raided;
    }

    public Gym getGym() {
        return gym;
    }

    public void setRaided() {
        this.raided = true;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return gym + " " + star + "*\n" + date + "\n" + time+ "\n";
    }
    
    
    
    
}
