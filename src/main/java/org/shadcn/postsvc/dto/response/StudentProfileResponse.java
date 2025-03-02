package org.shadcn.postsvc.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shadcn.courseservice.enums.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentProfileResponse extends UserProfileResponse {
    String studentId;

    String grade;

    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate enrollmentDate;

    String major;

    String guardianName;

    String guardianPhoneNumber;

    String email;

    String avatarPath;
    // 54 dân tộc :)))
    String nation;

    String religion;

    String citizenId;
    // At the moment just have Information technology and Business Administration
    String faculty;
    // Ex: Đại học chính quy Tiếng Việt K10
    String degreeLevel;

    String schoolYear;

    String present;

    Gender gender;
}
