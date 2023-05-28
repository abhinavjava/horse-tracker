package com.horse.track.horsetrack;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.horse.track.horsetrack.service.*;
import com.horse.track.horsetrack.service.impl.HorseTracker;
import com.horse.track.horsetrack.validator.InputValidator;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class HorseTrackApplication implements CommandLineRunner{

	Tracker tracker = new HorseTracker();
	Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		SpringApplication.run(HorseTrackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

        do {
           play(console.nextLine());
        
        } while (true);
		
	}
	
	public void play(String input) {
        int inputLength = input.length();

        if (inputLength == 0) {
            System.out.println("Invalid Command: ");
            return;
        }
        if (inputLength == 1) {
        	tracker.controlOperation(input);
            return;
        }
        if (InputValidator.havingNumber(input) && inputLength >= 2) {
        	tracker.trackerOperation(input);
        } else {
        	 System.out.println("Invalid Command: " + input);
        }
	}
	
	@PostConstruct
	public void initialconfig() {
		tracker.viewInventory();
		tracker.viewHorses();
	}

}
