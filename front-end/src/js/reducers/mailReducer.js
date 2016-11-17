export default function reducer(state={
    mailList: []
  }, action) {
    switch (action.type) {      
      case "GET_MAIL_LIST": {
        return {
          ...state,          
          mailList: action.payload.mailList,
        }
      }              
    }
    return state
}