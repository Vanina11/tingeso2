import React, { Component } from "react";
import Keycloak from "keycloak-js";
import InicioComponent from "./InicioComponent";

class LoginComponent extends Component{
    // Realiza autenticación con Keycloak
    constructor(props) {
        super(props);
        this.state = { keycloak: null, authenticated: false };
      }
    
      componentDidMount() {
        const keycloak = new Keycloak('/keycloak.json');
        keycloak.init({onLoad: 'login-required'}).then(authenticated => {
          this.setState({ keycloak: keycloak, authenticated: authenticated })
        })
      }
    
      render() {
        if (this.state.keycloak) {
          if (this.state.authenticated) return (
            <div>
              <p>This is a Keycloak-secured component of your application. You shouldn't be able
              to see this unless you've authenticated with Keycloak.</p>
                <InicioComponent keycloack={this.state.keycloack}/>
            </div>
          ); else return (<div>Unable to authenticate!</div>)
        }
        return (
          <div>Initializing Keycloak...</div>
          
        );
      }
}

export default LoginComponent;