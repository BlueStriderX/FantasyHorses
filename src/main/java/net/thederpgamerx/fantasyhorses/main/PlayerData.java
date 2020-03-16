package net.thederpgamerx.fantasyhorses.main;

import java.util.List;
import java.util.Map;

public class PlayerData {

    /* Horse Data File Template
		playerUUID + ".yml"
		    !!net.thederpgamerx.fantasyhorses.main.PlayerData
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
    private Map<String, List<String>> horses;

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

    public Map<String, List<String>> getHorses() {
        return horses;
    }

    public void setHorses(Map<String, List<String>> horses) {
        this.horses = horses;
    }
}
