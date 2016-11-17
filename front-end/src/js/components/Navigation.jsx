import React from "react";
import { IndexLink, Link } from "react-router";
import { connect } from "react-redux"

import Bootstrap from 'bootstrap/dist/css/bootstrap.css';
import { Navbar } from 'react-bootstrap';
import { NavItem } from 'react-bootstrap';
import { NavDropdown } from 'react-bootstrap';
import { MenuItem } from 'react-bootstrap';
import { Nav } from 'react-bootstrap';

import { getLoggedUser } from "../actions/loginActions";
import { logout } from "../actions/loginActions";


@connect((store) => {
  return {
    currentUser: store.login.currentUser
  };
})


class Navigation extends React.Component {

  componentWillMount() {
    this.props.dispatch(getLoggedUser())
  }

  logout() {
    this.props.dispatch(logout())
  }

  constructor() {
    super()    
  }  

  render() {   
   const { currentUser } = this.props;


    return (
      <div>
          <Navbar>
            <Navbar.Header>
              <Navbar.Brand>
                <a href="#">Mail Box</a>
              </Navbar.Brand>
            </Navbar.Header>
            <Nav>
              <NavItem eventKey={1} href="#settings">Settings</NavItem>
              <NavItem eventKey={2} href="#">Link</NavItem>              
              <NavDropdown id="dropdownAction" eventKey={3} title="Dropdown" id="basic-nav-dropdown">
                <MenuItem id="action" eventKey={3.1}>Action</MenuItem>
                <MenuItem id="action2" eventKey={3.2}>Another action</MenuItem>
                <MenuItem id="action3" eventKey={3.3}>Something else here</MenuItem>
                <MenuItem divider />
                <MenuItem id="action4" eventKey={3.3}>Separated link</MenuItem>
              </NavDropdown>
              <NavItem eventKey={4} href="#vmstatCharts">Charts</NavItem>
            </Nav>
            <Nav pullRight>
              <NavDropdown id="dropdownLogout" eventKey={1}  title={"Welcome " +  currentUser.name + "!"}>
                <MenuItem  id="logout"eventKey={1.1} onClick={this.logout.bind(this)}>Logout</MenuItem>
              </NavDropdown>
          </Nav>
          </Navbar>
        </div>
    );
  }
}

export default Navigation;