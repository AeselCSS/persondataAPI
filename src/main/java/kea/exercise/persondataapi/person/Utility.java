package kea.exercise.persondataapi.person;

import java.util.List;

public class Utility {

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    private static String capitalizeFullName(String fullName) {
        String[] names = fullName.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(capitalize(name)).append(" ");
        }
        return sb.toString().trim();
    }

    public static List<String> nameParts(String fullName) {
        String capitalizedFullName = capitalizeFullName(fullName);
        int firstSpaceIndex = capitalizedFullName.indexOf(' ');
        int lastSpaceIndex = capitalizedFullName.lastIndexOf(' ');

        String firstName = firstSpaceIndex == -1 ? capitalizedFullName : capitalizedFullName.substring(0, firstSpaceIndex);
        String middleName = firstSpaceIndex == -1 || firstSpaceIndex == lastSpaceIndex ? "" : capitalizedFullName.substring(firstSpaceIndex + 1, lastSpaceIndex);
        String lastName = lastSpaceIndex == -1 ? "" : capitalizedFullName.substring(lastSpaceIndex + 1);

        return List.of(capitalizedFullName, firstName, middleName, lastName);
    }

    public static String encodedName(String name) {
        return name.trim().replace(" ", "%20");
    }
}
