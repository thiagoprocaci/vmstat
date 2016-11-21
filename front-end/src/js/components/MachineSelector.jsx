import React from "react";
import { connect } from "react-redux"

import Bootstrap from 'bootstrap/dist/css/bootstrap.css';
import { Form } from 'react-bootstrap';
import { FormGroup } from 'react-bootstrap';
import { FormControl } from 'react-bootstrap';
import { Button } from 'react-bootstrap';
import { ControlLabel } from 'react-bootstrap';


import SelectOptionWrapper from './wrapper/SelectOptionWrapper.jsx';


class MachineSelector extends React.Component {
  
  constructor(props) {
    super(props);
    this.state = {selectedMachineIp : ""};
  }   

  selectMachineIp(event) {  
    let selectedMachineIp = event.target.value
    this.setState( {selectedMachineIp : selectedMachineIp});
    this.props.onSelectMachine(selectedMachineIp)
  }

  render() {     
    let mappedMachine = this.props.machineList.map(machine =>  <SelectOptionWrapper value={machine.ip} label={machine.ip} key={machine.ip} />)
    
    let html;            
    html = (
       <Form>   
          <FormGroup controlId="formControlsSelect" >
            <ControlLabel>IP Machine</ControlLabel>
            <FormControl componentClass="select" placeholder="select" onChange={this.selectMachineIp.bind(this)}>              
             <SelectOptionWrapper value="" label="" key="" />)
             {mappedMachine}
            </FormControl>
          </FormGroup>         
        </Form>
    )    
    return (html);
  }
}

export default MachineSelector;