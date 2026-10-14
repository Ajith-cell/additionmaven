package com.example.addition;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Usage: java -jar maven-addition.jar <integer> <integer>");
        }

        int left = Integer.parseInt(args[0]);
        int right = Integer.parseInt(args[1]);
        System.out.println(Addition.add(left, right));
    }
}
