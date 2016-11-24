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
  }   

  selectMachineIp(event) {  
    let selectedMachineIp = event.target.value    
    if(selectedMachineIp) {         
      for (var i = 0; i < this.props.machineList.length; i++) {
        if(this.props.machineList[i] && this.props.machineList[i].ip === selectedMachineIp) {
          this.props.onSelectMachine(this.props.machineList[i])
          break
        }
      }      
    } else {
      this.props.onSelectMachine(null)
    }
    
  }

  render() {     
    const divMachineStyle = {
      width: '150px',
      marginLeft: '20px'
    };

    let mappedMachine = this.props.machineList.map(machine =>  <SelectOptionWrapper value={machine.ip} label={machine.ip} key={machine.ip} />)    
    let html;            
    html = (
    <div style={divMachineStyle}>
       <Form>   
          <FormGroup controlId="formControlsSelect" >
            <ControlLabel>IP Machine</ControlLabel>
            <FormControl componentClass="select" placeholder="select" onChange={this.selectMachineIp.bind(this)}>              
             <SelectOptionWrapper value="" label="" key="" />)
             {mappedMachine}
            </FormControl>
          </FormGroup>         
        </Form>
    </div>
    )    
    return (html);
  }
}

export default MachineSelector;