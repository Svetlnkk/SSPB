package ru.ulstu.is.sbapp;

import java.util.Arrays;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SbappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbappApplication.class, args);
	}
	@GetMapping("/array")
	public String array(@RequestParam(value="size", defaultValue = "10") int size){
		int [][] array=new int[size][size];

		Random rand =new Random();
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array.length; j++){
				array[i][j]=rand.nextInt(100-10+1);
			}
		}
		String res ="";
		for(int i=0; i<array.length; i++){
			res+=Arrays.toString(array[i]);
		}
		return res;
	}

}
