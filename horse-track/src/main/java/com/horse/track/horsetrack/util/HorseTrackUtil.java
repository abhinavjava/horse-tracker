package com.horse.track.horsetrack.util;

import java.util.HashMap;
import java.util.Map;

import com.horse.track.horsetrack.model.*;
import com.horse.track.horsetrack.model.enums.Result;

public class HorseTrackUtil {
	
	private static Map<Integer, Horse> horses = new HashMap<Integer, Horse>();
    
	static {
        horses.put(1, new Horse(5,"That Darn Gray Cat", Result.WIN.getValue()));
        horses.put(2, new Horse(10,"Fort Utopia", Result.LOST.getValue()));
        horses.put(3, new Horse(9,"Count Sheep",Result.LOST.getValue()));
        horses.put(4, new Horse(4,"Ms Traitour", Result.LOST.getValue()));
        horses.put(5, new Horse(3,"Real Princess",Result.LOST.getValue()));
        horses.put(6, new Horse(5,"Pa Kettle",Result.LOST.getValue()));
        horses.put(7, new Horse( 6,"Gin Stinger",Result.LOST.getValue()));
    }

    private static Bet bet = new Bet(0, 0);

	public static Map<Integer, Horse> getHorses() {
		return horses;
	}


	public static Bet getBetDetails() {
		return bet;
	}

	public static void setBetDetails(Bet bet) {
		HorseTrackUtil.bet = bet;
	}
    
	 public static void setWinner(Integer key) {
	        for (Map.Entry<Integer, Horse> horse : horses.entrySet()) {
	            horse.getValue().setResult(Result.LOST.getValue());
	            if (horse.getKey() == key) {
	                horse.getValue().setResult(Result.WIN.getValue());
	            }
	        }
	    }

	    public static Integer getWinner() {
	        for (Map.Entry<Integer, Horse> horse : horses.entrySet()) {
	            if (horse.getValue().getResult().equalsIgnoreCase(Result.WIN.getValue())) {
	                return horse.getKey();
	            }
	        }
	        return 0;
	    }

}
