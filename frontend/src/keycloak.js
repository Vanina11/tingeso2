import Keycloak from "keycloak-js";

const keycloakConfig = {
    url: 'http://localhost:8082',
    realm: 'mueblesstgo',
    clientId: 'springboot-keycloak',
    onLoad: 'check-sso'
  }
  
  const keycloak = new Keycloak(keycloakConfig)



export default keycloak;