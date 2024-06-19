package com.photon.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {

    private int UserId;

    private String userFirstName;

    private String userLastName;

    private String userEmailId;

    private int userMobileNumber;

    private String userGender;

    private String userDOB;
}
