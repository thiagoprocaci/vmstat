import { combineReducers } from "redux"

import tweets from "./tweetsReducer"
import user from "./userReducer"
import login from "./loginReducer"
import mail from "./mailReducer"
import audit from "./auditReducer"

export default combineReducers({
  tweets,
  user,
  login,
  mail,
  audit,
})
