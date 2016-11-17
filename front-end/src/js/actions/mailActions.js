let today = currentDay();
let mailList = [
            {
              id : 1,
              title: "My new theory",
              sentBy: "Albert Einsten",
              dateTime: today,
              read : false,
            },
            {
              id : 2,
              title: "The dancing universe - my new book",
              sentBy: "Marcelo Gleiser",
              dateTime: today,
              read : false
            },
            {
              id : 3,
              title: "I've discovered Europa, Calisto",
              sentBy: "Galileu Galilei",
              dateTime: today,
              read : false
            }
          ];

function currentDay() {
	let today = new Date();
	let dd = today.getDate();
	let mm = today.getMonth()+1; 

	let yyyy = today.getFullYear();
	if(dd<10){
    	dd='0'+dd
	} 
	if(mm<10){
    	mm='0'+mm
	} 
	let todayString = dd+'/'+mm+'/'+yyyy;
	return todayString;	
}


export function getMailList() { 
  return {
    type: "GET_MAIL_LIST",
    payload: { 
      		mailList : mailList
    }
  }
}

export function deleteMail(id) { 
  if(mailList && mailList.length > 0) {
    for (let i = 0; i < mailList.length; i++) { 
      if(mailList[i].id === id) {
        mailList.splice(i, 1);
        break;
      }
    }
  }  
  return {
    type: "GET_MAIL_LIST",
    payload: { 
          mailList : mailList
    }
  }
}

export function openMail(id) {
  if(mailList && mailList.length > 0) {
    for (let i = 0; i < mailList.length; i++) { 
      if(mailList[i].id === id) {
        mailList[i].read = true
        break;
      }
    }
  }
  return {
    type: "GET_MAIL_LIST",
    payload: { 
          mailList : mailList
    }
  }
}