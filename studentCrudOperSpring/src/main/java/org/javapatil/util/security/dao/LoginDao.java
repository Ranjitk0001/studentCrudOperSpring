package org.javapatil.util.security.dao;

import org.javapatil.util.security.admin.LoginRequest;
import org.javapatil.util.security.admin.User;

public interface LoginDao {
  //This is login method.
  User getUserData(LoginRequest loginRequest);
}
