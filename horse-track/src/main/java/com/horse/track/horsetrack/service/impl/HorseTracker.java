package com.horse.track.horsetrack.service.impl;

import java.util.Map;

import com.horse.track.horsetrack.model.*;
import com.horse.track.horsetrack.model.enums.Result;
import com.horse.track.horsetrack.service.*;
import com.horse.track.horsetrack.util.HorseTrackUtil;
import com.horse.track.horsetrack.validator.InputValidator;

public class HorseTracker implements Tracker {

	private WinningClearance clearance = new WinningClearanceImpl();
	//private Inventory inventory = new Inventory(10, 10, 10, 10, 10);

	@Override
	public void controlOperation(String input) {
		String control = Character.toString(input.charAt(0));
		control = control.toLowerCase();
		
		switch (control) {
		case "q": {
			System.out.println("Thanks For Playing, Visit Again!");
			System.exit(0);
			break;
		}
		case "r": {
			reloadInventory();
			viewInventory();
			viewHorses();
			break;
		}
		default:
			System.out.println("Invalid Command: " + input);
		}
	}

	@Override
	public void trackerOperation(String input) {
		String in = Character.toString(input.charAt(0));
		if (InputValidator.isNumeric(in)) {
			if (betTheHorse(Integer.parseInt(in), input)) {
				Integer winnerKey = HorseTrackUtil.getWinner();
				Integer betNumber = Integer.parseInt(in);
				Horse winner = (Horse) HorseTrackUtil.getHorses().get(winnerKey);
				Integer bet = HorseTrackUtil.getBetDetails().getBet();
				Integer winNum = winner.getNumber();
				viewHorses();
				viewInventory();
				if (winnerKey == betNumber) {

					StringBuilder sb = new StringBuilder("Payout: " + winner.getName() + ", $" + bet * winNum);

					String result = clearance.clearance(bet * winNum);

					if (!result.isEmpty()) {
						System.out.println(sb.toString());
						System.out.println(result);
					} 
					
				} else {
					// if loser
					Horse loser = (Horse) HorseTrackUtil.getHorses().get(betNumber);
					System.out.println("No Payout: " + loser.getName());
										
				}
				
			} else {
				System.out.println("Invalid Bet: " + input);
			}
			viewHorses();
			viewInventory();
		} else {
			// it doesn't start with a number
			Integer horseNumber = Integer.parseInt(input.substring(1).trim());
			if (in.equalsIgnoreCase("w") && InputValidator.numberRange(horseNumber)) {
				HorseTrackUtil.setWinner(Integer.parseInt(input.substring(1).trim()));
				viewInventory();
				viewHorses();
			} else {
				System.out.println("Invalid Command: " + input);
			}
		}

	}

	@Override
	public boolean betTheHorse(Integer horseNumber, String input) {

		if (!InputValidator.numberRange(horseNumber)) {
			System.out.println("Invalid Horse Number: " + horseNumber);
			return false;
		}
		String bet = input.substring(1).trim();

		if (InputValidator.isNumeric(bet)) {
			HorseTrackUtil.setBetDetails(new Bet(horseNumber, Integer.parseInt(bet)));
			return true;
		}
		return false;
	}

	@Override
	public void viewInventory() {
		WinningClearanceImpl imp = (WinningClearanceImpl)clearance;
		imp.getInventory().displayInventory();
	}

	@Override
	public void viewHorses() {
		StringBuilder sb = new StringBuilder();
		sb.append("Horses:\n");

		for (Map.Entry<Integer, Horse> horse : HorseTrackUtil.getHorses().entrySet()) {
			sb.append(horse.getKey() + ", " + horse.getValue().getName() + ", " + horse.getValue().getNumber() + ", ");
			sb.append(horse.getValue().getResult().equalsIgnoreCase(Result.WIN.getValue()) ? "Won" + "\n"
					: "Lost" + "\n");

		}
		System.out.println(sb.toString().trim());

	}

	@Override
	public void reloadInventory() {
		WinningClearanceImpl imp = (WinningClearanceImpl)clearance;
		imp.setInventory(new Inventory(10, 10, 10, 10, 10));
		viewInventory();
		viewHorses();
	}

}
