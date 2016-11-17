import axios from "axios";



export function getAuditList() {
  return function(dispatch) {
    axios.get("http://localhost:8081/audit/")
      .then((response) => {
        dispatch({type: "FETCH_AUDIT_SUCCESS", payload: response.data})
      })
      .catch((err) => {
        dispatch({type: "FETCH_AUDIT_REJECTED", payload: err})
      })
  }
}
