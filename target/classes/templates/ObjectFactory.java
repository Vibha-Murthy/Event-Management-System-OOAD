package com.example.mvceventtracker;

public class ObjectFactory {
    public static Object createObject(String objectType) {
        switch (objectType) {
            case "event":
                return new Event();
            case "product":
                return new Product();
            case "attendee":
                return new Attendee();
            case "speaker":
                return new Speaker();
            default:
                throw new IllegalArgumentException("Invalid object type: " + objectType);
        }
    }
}