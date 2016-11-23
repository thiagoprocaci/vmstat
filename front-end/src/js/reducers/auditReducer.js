export default function reducer(state={
    memoryStatusList: [],    
    pagesStatusList: [],    
    cpuStatusList: [],        
    error: null,
  }, action) {

    switch (action.type) {      
      case "FETCH_AUDIT_SUCCESS": {
        return {
          ...state,          
          memoryStatusList: action.payload.memoryStatusList,
          pagesStatusList: action.payload.pagesStatusList,
          cpuStatusList: action.payload.cpuStatusList,
          error : null,
        }
      }
      case "FETCH_AUDIT_REJECTED": {
        return {
          ...state,          
          memoryStatusList: [],    
          pagesStatusList: [],    
          cpuStatusList: [],
          error: action.payload,
        }
      }
      
    }
    return state
}


