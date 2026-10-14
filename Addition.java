package com.example.addition;

public final class Addition {
    private Addition() {
    }

    public static int add(int left, int right) {
        return Math.addExact(left, right);
    }
}
