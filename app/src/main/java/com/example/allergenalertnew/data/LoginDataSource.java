package com.example.allergenalertnew.data;

import com.example.allergenalertnew.data.model.LoggedInUser;

import java.io.IOException;
import java.util.HashMap;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
        HashMap<String, String> acceptedLogins = new HashMap<String, String>();
        acceptedLogins.put("login1@gmail.com", "password1");
        acceptedLogins.put("login2@gmail.com", "password2");
        acceptedLogins.put("login3@gmail.com", "password3");
        acceptedLogins.put("login4@gmail.com", "password4");
        acceptedLogins.put("login5@gmail.com", "password5");

        try {
            // TODO: handle loggedInUser authentication
            if (acceptedLogins.get(username).equals(password)) {
                //java.util.UUID.randomUUID().toString()
                LoggedInUser user = new LoggedInUser(username, "Name");
                return new Result.Success<>(user);
            }
            return new Result.Error(new IOException("Error logging in"));
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}