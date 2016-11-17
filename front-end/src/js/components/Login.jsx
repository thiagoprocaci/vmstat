import React from "react";
import { connect } from "react-redux"


import Bootstrap from 'bootstrap/dist/css/bootstrap.css';
import { Form } from 'react-bootstrap';
import { FormGroup } from 'react-bootstrap';
import { Col } from 'react-bootstrap';
import { FormControl } from 'react-bootstrap';
import { Button } from 'react-bootstrap';
import { ControlLabel } from 'react-bootstrap';
import { Checkbox } from 'react-bootstrap';



import { doLogin } from "../actions/loginActions";


@connect((store) => {
  return {
    isAuthenticated: store.login.isAuthenticated
  };
})


class Login extends React.Component {

  doLogin() {
    this.props.dispatch(doLogin())
  }

  render() {
  	const divLoginStyle = {
	  width: '100%',
	  marginTop: '10%'

	};
	const innerDivLoginStyle = {
	  width: '50%' ,
	  margin: '0 auto'
	};	


    return (
    <div style={divLoginStyle}>
	     <div style={innerDivLoginStyle}>
		      <Form horizontal>
			    <FormGroup controlId="formHorizontalEmail">
			      <Col componentClass={ControlLabel} sm={2}>
			        Email
			      </Col>
			      <Col sm={10}>
			        <FormControl type="email" placeholder="Email" />
			      </Col>
			    </FormGroup>

			    <FormGroup controlId="formHorizontalPassword">
			      <Col componentClass={ControlLabel} sm={2}>
			        Password
			      </Col>
			      <Col sm={10}>
			        <FormControl type="password" placeholder="Password" />
			      </Col>
			    </FormGroup>

			    <FormGroup>
			      <Col smOffset={2} sm={10}>
			        <Checkbox>Remember me</Checkbox>
			      </Col>
			    </FormGroup>

			    <FormGroup>
			      <Col smOffset={2} sm={10}>
			        <Button  onClick={this.doLogin.bind(this)}>
			          Sign in
			        </Button>
			      </Col>
			    </FormGroup>
			  </Form>
		  </div>
     </div>
    );
  }
}


export default Login;