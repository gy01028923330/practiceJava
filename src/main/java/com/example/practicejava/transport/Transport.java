package com.example.practicejava.transport;


import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transport {

    int speed;
    int distance;
    String type;

    public int getTotalPrice() {
        return speed * distance;
    }

    public int getWaitingTime(Transport transport) {
        if(transport instanceof Subway) {
            return speed * 3;
        } else if (transport instanceof Taxi) {
            return speed * 5;
        } else if (transport instanceof Bus) {
            return speed * 10;
        } else {
            return 100;
        }
    }

    public int getWaitingTime(String type) {
        if(type.equals("bus")) {
            return speed * 3;
        } else if(type.equals("subway")) {
            return speed * 5;
        } else if(type.equals("taxi")) {
            return speed * 10;
        } else {
            return 0;
        }

    }
}

