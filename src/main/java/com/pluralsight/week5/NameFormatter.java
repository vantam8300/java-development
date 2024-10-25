package com.pluralsight.week5;

public class NameFormatter {
    private String Prefix;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Suffix;

    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    public static String format(String prefix,
                                String firstName,
                                String middleName,
                                String lastName,
                                String suffix) {
        StringBuilder sb = new StringBuilder();
        sb.append(lastName).append(", ");
        if (!prefix.isEmpty()) {
            sb.append(prefix).append(" ");
        }
        sb.append(firstName);
        if (!middleName.isEmpty()) {
            sb.append(" ").append(middleName);
        }
        if (!suffix.isEmpty()) {
            sb.append(", ").append(suffix);
        }

        return sb.toString();
    }

    public static String format(String fullName) {
        String[] nameInArray = fullName.split(" ");
        String lastName = nameInArray[nameInArray.length - 1];
        String firstName = nameInArray[0];
        StringBuilder middleName = new StringBuilder();
        for (int i=1; i<nameInArray.length - 1; i++) {
            middleName.append(nameInArray[i]);
        }

        return lastName + ", " + firstName + " " + middleName.toString();
    }

    private NameFormatter(String prefix, String firstName, String middleName, String lastName, String suffix) {
        Prefix = prefix;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        Suffix = suffix;
    }

    public String getPrefix() {
        return Prefix;
    }

    public void setPrefix(String prefix) {
        Prefix = prefix;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSuffix() {
        return Suffix;
    }

    public void setSuffix(String suffix) {
        Suffix = suffix;
    }
}
