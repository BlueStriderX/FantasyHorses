package net.thederpgamerx.fantasyhorses.old.main;

import net.thederpgamerx.fantasyhorses.old.horses.FantasyHorse;

public class PlayerData {

    /* Horse Data File Template
		playerUUID + ".yml"
		    !!net.thederpgamerx.fantasyhorses.old.main.PlayerData
			name: <playerName>
			uuid: <playerUUID>
			horseSlotsMax: <horseSlotsMax>
			horseSlotsFilled: <horseSlotsFilled>
			<horse1>:
				name: <horseName>
				uuid: <horseUUID>
				level: <horseLevel>
				health: <horseHealth>
				maxHealth: <horseMaxHealth>
				armor: <horseArmor>
				speed: <horseSpeed>
				jump: <horseJump>
				style: <horseStyle>
				color: <horseColor>
			<horse2>:
				name: <horseName>
				...
			*/

    private String name;
    private int horseSlotsMax;
    private int horseSlotsFilled;
    private FantasyHorse[] horses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHorseSlotsMax() {
        return horseSlotsMax;
    }

    public void setHorseSlotsMax(int horseSlotsMax) {
        this.horseSlotsMax = horseSlotsMax;
    }

    public int getHorseSlotsFilled() {
        return horseSlotsFilled;
    }

    public void setHorseSlotsFilled(int horseSlotsFilled) {
        this.horseSlotsFilled = horseSlotsFilled;
    }

    public FantasyHorse[] getHorses() {
        return horses;
    }
}
