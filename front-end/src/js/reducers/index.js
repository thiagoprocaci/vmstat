import { combineReducers } from "redux"


import login from "./loginReducer"
import audit from "./auditReducer"
import machine from "./machineReducer"

export default combineReducers({  
  login,  
  audit,
  machine,
})
