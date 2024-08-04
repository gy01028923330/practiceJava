package com.example.practicejava.transport;

import lombok.ToString;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

	Subway subway = new Subway();
	Taxi taxi = new Taxi();
	Bus bus = new Bus();

	subway.setDistance(100);

	}

}