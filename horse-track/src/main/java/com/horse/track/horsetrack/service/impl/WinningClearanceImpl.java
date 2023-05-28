package com.horse.track.horsetrack.service.impl;

import com.horse.track.horsetrack.service.WinningClearance;
import com.horse.track.horsetrack.model.*;
import com.horse.track.horsetrack.model.enums.Doller;

public class WinningClearanceImpl implements WinningClearance{

	    private Inventory inventory = new Inventory(10,10,10,10,10);
	    
	    private static int balance;
	    private static int payout;

	    @Override
		public String clearanceWinnings(Integer theBet) {


	        balance = inventory.getTotalCashOnHand();
	        payout = theBet;

	        if (payout > balance) {
	            System.out.println("Insufficient Funds: " + payout);
	        }
	        int hundred = makeChange(Doller.HUNDRED.getValue());
	        int twenty = makeChange(Doller.TWENTY.getValue());
	        int ten = makeChange(Doller.TEN.getValue());
	        int five = makeChange(Doller.FIVE.getValue());
	        int one = makeChange(Doller.ONE.getValue());

	        if (!adjustInventory(hundred, twenty, ten, five, one)) {
	            return "";
	        }

	        StringBuilder sb = new StringBuilder();
	        sb.append("Dispensing:\n");
	        sb.append("$1," + one + "\n");
	        sb.append("$5," + five + "\n");
	        sb.append("$10," + ten + "\n");
	        sb.append("$20," + twenty + "\n");
	        sb.append("$100," + hundred);
	        return sb.toString();
	    
		}
		

	    private boolean adjustInventory(int hundred, int twenty, int ten, int five, int one) {
	        int oldHundred = inventory.getHundred();
	        int oldTwenty = inventory.getTwenty();
	        int oldTen = inventory.getTen();
	        int oldFive = inventory.getFive();
	        int oldOne = inventory.getOne();

	        boolean success = true;

	        if (inventory.getHundred() >= hundred) {
	        	inventory.setHundred(inventory.getHundred() - hundred);
	        } else {
	            success = false;
	        }
	        if (inventory.getTwenty() >= twenty) {
	        	inventory.setTwenty(inventory.getTwenty() - twenty);
	        } else {
	            success = false;
	        }
	        if (inventory.getTen() >= ten) {
	        	inventory.setTen(inventory.getTen() - ten);
	        } else {
	            success = false;
	        }
	        if (inventory.getFive() >= five) {
	        	inventory.setFive(inventory.getFive() - five);
	        } else {
	            success = false;
	        }
	        if (inventory.getOne() >= one) {
	        	inventory.setOne(inventory.getOne() - one);
	        } else {
	            success = false;
	        }

	        if (success == false) {
	        	inventory.setHundred(oldHundred);
	        	inventory.setTwenty(oldTwenty);
	            inventory.setTen(oldTen);
	            inventory.setFive(oldFive);
	            inventory.setOne(oldOne);
	        }
	        return success;
	    }
	
	 private int makeChange(int currency) {
	        int result = payout / currency;
	        balance -= result * currency;
	        payout -= result * currency;
	        return result;
	    }


	public Inventory getInventory() {
		return inventory;
	}


	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	 
}
