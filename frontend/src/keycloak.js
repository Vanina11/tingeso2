import Keycloak from "keycloak-js";

const keycloakConfig = {
  url: "http://localhost:8082",
  realm: "mueblesstgo",
  clientId: "springboot-keycloak",
  onLoad: "login-required",
};

const keycloak = new Keycloak(keycloakConfig);

keycloak.init({ onLoad: keycloakConfig.onLoad }).then((authenticated) => {
  if (authenticated) {
    localStorage.setItem("react-token", keycloak.token);
    console.log(keycloak.token);
    localStorage.setItem("react-refresh-token", keycloak.refreshToken);
    console.log(keycloak.refreshToken);
    localStorage.setItem("react-id-token", keycloak.idToken);
  } else {
    keycloak.login();
  }
});

export default keycloak;
