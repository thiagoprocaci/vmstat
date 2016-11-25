import React from "react";
import { Table } from 'react-bootstrap';
import TrCpu from './TrCpu.jsx';


class CpuTable extends React.Component {
  
  constructor(props) {
    super(props);
  }


  render() {      
    let html = (<div></div>);       
    if(this.props.cpuStatusList && this.props.cpuStatusList.length > 0 && this.props.perspective === 'cpu') {
      
      let mappedTr = this.props.cpuStatusList.map(c =>  <TrCpu cpu={c} key={c.date} />)   
      
      html = (
        <div>
          <Table responsive>
            <thead>
              <tr>
                <th>Date</th>
                <th>Machine</th>
                <th>Non-nice User Cpu Ticks</th>
                <th>Nice User Cpu Ticks</th>
                <th>System Cpu Ticks</th>
                <th>Idle Cpu Ticks</th>
                <th>IO Wait Cpu Ticks</th>
                <th>IRQ Cpu Ticks</th>
                <th>Softirq Cpu Ticks</th>
                <th>Stolen Cpu Ticks</th>               
              </tr>
            </thead>       
             <tbody>
             {mappedTr}
            </tbody>
          </Table>
          
        </div>
        )
    }           
    return (html);
  }
}

export default CpuTable;