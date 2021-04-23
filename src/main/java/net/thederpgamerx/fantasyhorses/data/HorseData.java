package net.thederpgamerx.fantasyhorses.data;

import java.io.Serializable;

/**
 * HorseData.java
 * <Description>
 * ================================
 * Created: 12/19/2020
 * Author: TheDerpGamerX
 */
public class HorseData implements Serializable {

    //ID
    public String horseId;
    public String entityId;
    public String ownerId;
    public String lastStableId;

    //Data
    public String icon;
    public String worldName;
    public float[] pos;
    public int styleType;
    public int colorType;
    public int gearType;
    public int chestSize;

    //Levels
    public int healthLevel;
    public int speedLevel;
    public int jumpLevel;

    //Stats
    public float maxHealth;
    public float currentHealth;
    public float speed;
    public float jump;
}
