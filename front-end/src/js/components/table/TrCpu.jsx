import React from "react";


class TrCpu extends React.Component {
  
  constructor(props) {
    super(props);
  }


  render() {         

    let html;            
      html = (
        <tr>                                
            <td>{this.props.cpu.date}</td>
            <td>{this.props.cpu.ipRunnerMachine}</td>
            <td>{this.props.cpu.nonNiceUserCpuTicks}</td>
            <td>{this.props.cpu.niceUserCpuTicks}</td>
            <td>{this.props.cpu.systemCpuTicks}</td>
            <td>{this.props.cpu.idleCpuTicks}</td>
            <td>{this.props.cpu.ioWaitCpuTicks}</td>
            <td>{this.props.cpu.irqCpuTicks}</td>
            <td>{this.props.cpu.softirqCpuTicks}</td>
            <td>{this.props.cpu.stolenCpuTicks}</td>
        </tr>
      )    
    return (html);
  }
}

export default TrCpu;