import axios from "axios";

export function getMachineList() {
  return function(dispatch) {
    axios.get("http://localhost:8081/machine/")
      .then((response) => {
        dispatch({type: "FETCH_MACHINE_SUCCESS", payload: response.data})
      })
      .catch((err) => {
        dispatch({type: "FETCH_MACHINE_REJECTED", payload: err})
      })
  }
}
