export default function reducer(state={
    machineList: [],    
    error: null,
  }, action) {

    switch (action.type) {      
      case "FETCH_MACHINE_SUCCESS": {
        return {
          ...state,          
          machineList: action.payload,
          error : null,
        }
      }
      case "FETCH_MACHINE_REJECTED": {
        return {
          ...state,          
          machineList: [],
          error: action.payload,
        }
      }
      
    }
    return state
}