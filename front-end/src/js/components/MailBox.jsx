import React from "react";
import { connect } from "react-redux"

import Bootstrap from 'bootstrap/dist/css/bootstrap.css';
import { Table } from 'react-bootstrap';
import { Button } from 'react-bootstrap';

import { getMailList } from "../actions/mailActions";
import { deleteMail } from "../actions/mailActions";

import MailBoxRow from './MailBoxRow.jsx';



@connect((store) => {
  return {
    mailList: store.mail.mailList
  };
})

class MailBox extends React.Component {
  
  constructor(props) {
    super(props);
  }

  componentWillMount() {
    let vo = getMailList();
    this.props.dispatch(vo)
  }


  render() {
    const { mailList } = this.props;
    let mappedMail = mailList.map(mail =>  <MailBoxRow mail={mail} key={mail.id} />)
    return (
      <div>
        <Table responsive striped condensed hove>
          <thead>
            <tr>
              <th>Mail Title</th>
              <th>Sent by</th>
              <th>Date</th>
              <th>#</th>              
            </tr>
          </thead>
          <tbody>
            {mappedMail}
          </tbody>
        </Table>
       </div>
    );
  }
}


export default MailBox;