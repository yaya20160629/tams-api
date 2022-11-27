package com.tams.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/operator")
  @PreAuthorize("hasRole('OPERATOR')")
  public String moderatorAccess() {
    return "Operator Board.";
  }
  
  @GetMapping("/super_admin")
  @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('OPERATOR') or hasRole('USER') or hasRole('ADMIN')")
  public String superAdminAccess() {
    return "Super Admin Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN') or hasRole('OPERATOR') or hasRole('USER')")
  public String adminAccess() {
    return "Admin Board.";
  }
}
