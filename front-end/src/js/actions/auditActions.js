import axios from "axios";



export function getAuditList(machine) {
  if(machine && machine.ip) {
  	return function(dispatch) {
	    axios.get("http://localhost:8081/audit/memory?ipRunnerMachine=" + machine.ip)
	      .then((response) => {
	        dispatch({type: "FETCH_AUDIT_SUCCESS", payload: response.data})
	      })
	      .catch((err) => {
	        dispatch({type: "FETCH_AUDIT_REJECTED", payload: err})
	      })
  	}
  } else {
  	return {
	    type: "FETCH_AUDIT_SUCCESS",
	    payload: []
	  }
	}  
}
