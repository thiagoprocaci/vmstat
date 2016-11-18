import React from "react";
import Bootstrap from 'bootstrap/dist/css/bootstrap.css';


class SelectOptionWrapper extends React.Component {
  
  constructor(props) {
    super(props);
  }


  render() {      
    let html;            
      html = (
        <option key={this.props.value} value={this.props.value} >{this.props.label}</option>
      )    
    return (html);
  }
}

export default SelectOptionWrapper;