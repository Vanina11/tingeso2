import Keycloak from "keycloak-js";

const keycloakConfig = {
  url: "http://host.docker.internal:8082",
  realm: "mueblesstgo",
  clientId: "springboot-keycloak",
  onLoad: "login-required",
};

const keycloak = new Keycloak(keycloakConfig);

keycloak.init({ onLoad: keycloakConfig.onLoad }).then((authenticated) => {
  if (authenticated) {
    localStorage.setItem("react-token", keycloak.token);
    localStorage.setItem("react-refresh-token", keycloak.refreshToken);
    localStorage.setItem("react-id-token", keycloak.idToken);
    localStorage.setItem("name", keycloak.tokenParsed.name);
    console.log(keycloak.idToken);
  } else {
    keycloak.login();
  }
});

export default keycloak;
