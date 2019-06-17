package com.hobart.sample.core.dto;

import java.io.Serializable;

public class LoginAuthDto implements Serializable{
    private static final long serialVersionUID = -1137852221455042256L;
    
    private String userId;
    
    private String userAccount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
