package com.hrb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * Created by x148128 on 08/02/2016.
 */
@Getter
@Setter
@ToString
public class User {
    private String username;
    private String password;
    private String email;
    private Date birthDate;
    private String profession;
    private int signInCodeStatus;
    private boolean emailConfigured;

    public boolean isEmailConfigured() {
        return StringUtils.isNotBlank(email);
    }

    private String gender = "M";

    private String maritalStatus = "";

    private String favoriteMovieType = "";
}
