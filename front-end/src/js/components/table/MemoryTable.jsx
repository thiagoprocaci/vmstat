import React from "react";
import { Table } from 'react-bootstrap';
import TrMemory from './TrMemory.jsx';


class MemoryTable extends React.Component {
  
  constructor(props) {
    super(props);
  }


  render() {      
    let html = (<div></div>);       
    if(this.props.memoryStatusList && this.props.memoryStatusList.length > 0 && this.props.perspective === 'memory') {
      
      let mappedTr = this.props.memoryStatusList.map(m =>  <TrMemory memory={m} key={m.date} />)   
      
      html = (
        <div>
          <Table responsive>
            <thead>
              <tr>
                <th>Date</th>
                <th>Machine</th>
                <th>Total Memory (GB)</th>
                <th>Used Memory (GB)</th>
                <th>Active Memory (GB)</th>
                <th>Inactive Memory (GB)</th>
                <th>Free Memory (GB)</th>
                <th>Buffer Memory (GB)</th>
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

export default MemoryTable;