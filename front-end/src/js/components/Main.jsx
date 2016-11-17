import React from "react"
import { connect } from "react-redux"

import Navigation from './Navigation.jsx';
import Login from './Login.jsx';

import { isAuthenticated } from "../actions/loginActions";




@connect((store) => {
  return {
    authenticated: store.login.authenticated,
  };
})

class Main extends React.Component {

  componentWillMount() {
    this.props.dispatch(isAuthenticated())
  }

  constructor() {
    super()    
  }  

  render() {
    const { authenticated } = this.props;
    
    let html;
    if (authenticated) {
      html = (
        <div><Navigation  /> {this.props.children}</div>
      )
    } else {
      html = (
        <Login />
      )
    }
    return ( <div>{ html }</div>)
  }
}


export default Main;