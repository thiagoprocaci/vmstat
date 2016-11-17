export default function reducer(state={
    auditList: [],    
    error: null,
  }, action) {

    switch (action.type) {      
      case "FETCH_AUDIT_SUCCESS": {
        return {
          ...state,          
          auditList: action.payload,
          error : null,
        }
      }
      case "FETCH_AUDIT_REJECTED": {
        return {
          ...state,          
          auditList: [],
          error: action.payload,
        }
      }
      
    }

    return state
}
