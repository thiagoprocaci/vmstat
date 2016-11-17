import React from "react";
import { connect } from "react-redux"

import Bootstrap from 'bootstrap/dist/css/bootstrap.css';
import { Table } from 'react-bootstrap';
import { Button } from 'react-bootstrap';

import { getMailList } from "../actions/mailActions";
import { deleteMail } from "../actions/mailActions";
import { openMail } from "../actions/mailActions";

import ReadMailModal from './ReadMailModal.jsx';


@connect((store) => {
  return {
    mailList: store.mail.mailList
  };
})

class MailBoxRow extends React.Component {
  
  constructor(props) {
    super(props);
  }

  componentWillMount() {
    this.state = {display : true, mail : this.props.mail, showModal: false};
  }

  deleteMail(id) {
    let vo = deleteMail(id);
    this.props.dispatch(vo);
    this.setState( {display : false, mail : this.state.mail, showModal: false});
  }

  openMail(id) {
    let vo = openMail(id)
    this.props.dispatch(vo)
    this.setState( {display : true, mail : this.state.mail, showModal: true});
  }

  hideMail() {
    this.setState( {display : true, mail : this.state.mail, showModal: false});
  }

  render() {  
    let display  = this.state.display; 
    if(!display) {
      return null;
    }
    const unreadMailStyle = {
        fontWeight: "bold",
        cursor: "pointer"
    };
    const readMailStyle = {
        cursor: "pointer"
    };       
    let mail = this.state.mail; 
    let html;        
    if(mail.read) {
      html = (<tr style={readMailStyle}>                                
                  <td onClick={this.openMail.bind(this, mail.id)}>{mail.title}</td>
                  <td onClick={this.openMail.bind(this, mail.id)}>{mail.sentBy}</td>
                  <td onClick={this.openMail.bind(this, mail.id)} >{mail.dateTime}</td>
                  <td onClick={this.deleteMail.bind(this, mail.id)}><Button bsStyle="danger" >Delete</Button> <ReadMailModal title={mail.title} show={this.state.showModal} onHide={this.hideMail.bind(this)} /></td>
                </tr>)
    } else {
     html = (<tr style={unreadMailStyle}>                                
                  <td onClick={this.openMail.bind(this, mail.id)}>{mail.title}</td>
                  <td onClick={this.openMail.bind(this, mail.id)}>{mail.sentBy}</td>
                  <td onClick={this.openMail.bind(this, mail.id)}>{mail.dateTime}</td>
                  <td><Button bsStyle="danger" onClick={this.deleteMail.bind(this, mail.id)}>Delete</Button>
                  <ReadMailModal title={mail.title} show={this.state.showModal} onHide={this.hideMail.bind(this)} /></td>
                </tr>)
    }     
    return (html);
  }
}

export default MailBoxRow;