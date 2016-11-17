let authenticated = false;

export function getLoggedUser() {
  return {
    type: "GET_LOGGED_USER",
    payload: {
      name: "Isaac Newton",
      username: "inewton",
    }
  }
}

export function isAuthenticated() {
	return {
    type: "IS_AUTHENTICATED",
    payload: {
      authenticated: authenticated,
    }
  }
}

export function doLogin() {
  authenticated = true
  return {
    type: "DO_LOGIN",
    payload: {
      authenticated: authenticated,
    }
  }
}

export function logout() {
 authenticated = false
  return {
    type: "LOGOUT",
    payload: {
      authenticated: authenticated,
    }
  }

}