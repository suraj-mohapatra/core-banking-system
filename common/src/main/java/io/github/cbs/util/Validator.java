package io.github.cbs.util;

public final class Validator {

    private Validator() {

    }

    public static boolean isValidPan(String pan) {
        return pan != null &&
                pan.matches("[A-Z]{5}[0-9]{4}[A-Z]");
    }

    public static boolean isValidAadhaar(String aadhaar) {
        return aadhaar != null &&
                aadhaar.matches("\\d{12}");
    }

    public static boolean isValidMobile(String mobile) {
        return mobile != null &&
                mobile.matches("[6-9]\\d{9}");
    }

    public static boolean isValidEmail(String email) {
        return email != null &&
                email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isValidIfsc(String ifsc) {
        return ifsc != null &&
                ifsc.matches("^[A-Z]{4}0[A-Z0-9]{6}$");
    }


}