import React from "react";


class TrMemory extends React.Component {
  
  constructor(props) {
    super(props);
  }


  render() {      
    

    let html;            
      html = (
        <tr>                                
            <td>{this.props.memory.date}</td>
            <td>{this.props.memory.ipRunnerMachine}</td>
            <td>{this.props.memory.totalMemory}</td>
            <td>{this.props.memory.usedMemory}</td>
            <td>{this.props.memory.activeMemory}</td>
            <td>{this.props.memory.inactiveMemory}</td>
            <td>{this.props.memory.freeMemory}</td>
            <td>{this.props.memory.bufferMemory}</td>
        </tr>
      )    
    return (html);
  }
}

export default TrMemory;