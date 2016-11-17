export default function reducer(state={
    currentUser: {
      name: null,
      username: null,
    },
    authenticated : false ,
    error: null,
  }, action) {
    switch (action.type) {      
      case "GET_LOGGED_USER": {
        return {
          ...state,
          authenticated : true,
          currentUser: action.payload,
        }
      } 
      case "IS_AUTHENTICATED": {
        return {
          ...state,
          authenticated : action.payload.authenticated,
        }
      }
      case "DO_LOGIN": {
        return {
          ...state,
          authenticated : action.payload.authenticated,
        }
      }
      case "LOGOUT": {
        return {
          ...state,
          authenticated : action.payload.authenticated,
        }
      }             
    }
    return state
}