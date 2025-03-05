package org.shadcn.postsvc.util;

import org.shadcn.postsvc.dto.response.UserProfileResponse;

public class UserUtil {
    public static String buildFullNameWithBuilder(UserProfileResponse author) {
        StringBuilder fullName = new StringBuilder();
        String firstName = author.getFirstName();
        String middleName = author.getMiddleName();
        String lastName = author.getLastName();
        if (firstName != null && !firstName.isEmpty()) fullName.append(firstName);
        if (middleName != null && !middleName.isEmpty()) {
            if (!fullName.isEmpty()) fullName.append(" ");
            fullName.append(middleName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            if (!fullName.isEmpty()) fullName.append(" ");
            fullName.append(lastName);
        }
        return fullName.toString();
    }
}
