package com.horse.track.horsetrack.model;

public class Inventory {

	private int one;
    private int five;
    private int ten;
    private int twenty;
    private int hundred;

    public Inventory(int one, int five, int ten, int twenty, int hundred) {
        this.one = one;
        this.five = five;
        this.ten = ten;
        this.twenty = twenty;
        this.hundred = hundred;
    }

    
    public int getOne() {
		return one;
	}


	public void setOne(int one) {
		this.one = one;
	}


	public int getFive() {
		return five;
	}


	public void setFive(int five) {
		this.five = five;
	}


	public int getTen() {
		return ten;
	}


	public void setTen(int ten) {
		this.ten = ten;
	}


	public int getTwenty() {
		return twenty;
	}


	public void setTwenty(int twenty) {
		this.twenty = twenty;
	}


	public int getHundred() {
		return hundred;
	}


	public void setHundred(int hundred) {
		this.hundred = hundred;
	}


	public void reload() {
        one = five = ten = twenty = hundred = 10;
    }
	
	public void displayInventory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventory:\n");
        sb.append("$1," + getOne() + "\n");
        sb.append("$5," + getFive() + "\n");
        sb.append("$10 " + getTen() + "\n");
        sb.append("$20," + getTwenty() + "\n");
        sb.append("$100," + getHundred() + "\n");
        System.out.println(sb.toString().trim());
    }
	
	 public int getTotalCashOnHand() {
	        return (one * 1) + (five * 5) + (ten * 10) +  (twenty * 20) + (hundred * 100);
	    }
}
