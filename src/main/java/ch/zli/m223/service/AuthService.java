package ch.zli.m223.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import ch.zli.m223.model.Credential;
import ch.zli.m223.model.User;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthService {

  @Inject
  AdminService adminService;

  public Response authenticate(Credential credential) {
    Optional<User> user = adminService.findByEmail(credential.getEmail());

    try {
      if (user.isPresent() && user.get().getPassword().equals(credential.getPassword())) {
        String token = Jwt
            .issuer("https://zli.example.com/")
            .upn(credential.getEmail())
            .groups(new HashSet<>(Arrays.asList("User", "Admin")))
            .expiresIn(Duration.ofHours(12))
            .sign();
        return Response
            .ok(user.get())
            .cookie(new NewCookie("punchclock", token))
            .header("Authorization", "Bearer " + token)
            .build();
      }
    } catch (Exception e) {
      System.err.println("Couldn't validate password.");
    }

    return Response.status(Response.Status.FORBIDDEN).build();
  }
}
