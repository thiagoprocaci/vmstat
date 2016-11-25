import React from "react";
import {LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend} from 'recharts';
import ChartTitle from './ChartTitle.jsx';

class MemoryLineChart extends React.Component {
  
  constructor(props) {
    super(props);
  }


  render() {      
    let html = (<div></div>);       
    if(this.props.memoryStatusList && this.props.memoryStatusList.length > 0 && this.props.perspective === 'memory') {
      html = (
        <div>
         <ChartTitle label="Memory Chart (GB)"></ChartTitle>          
          <LineChart margin={{ top: 5, right: 30, left: 20, bottom: 5 }} width={800} height={600} data={this.props.memoryStatusList}>
                 <XAxis dataKey="date" padding={{left: 30, right: 30}}/>
                 <YAxis/>
                 <CartesianGrid strokeDasharray="3 3"/>
                 <Tooltip/>
                 <Legend />
                 <Line type="monotone" dataKey="totalMemory" name="Total Memory" stroke="#8884d8" activeDot={{r: 8}}/>
                 <Line type="monotone" dataKey="usedMemory" name="Used Memory" stroke="#82ca9d" activeDot={{r: 7}} />
                 <Line type="monotone" dataKey="activeMemory" name="Active Memory" stroke="#ff0000" activeDot={{r: 6}} />
                 <Line type="monotone" dataKey="inactiveMemory" name="Inactive Memory" stroke="#000099" activeDot={{r: 5}} />       
                 <Line type="monotone" dataKey="freeMemory" name="Free Memory" stroke="#00cc00" activeDot={{r: 3}} />
                 <Line type="monotone" dataKey="bufferMemory" name="Buffer Memory" stroke="#333300" activeDot={{r: 2}} />
            </LineChart>
        </div>
        )
    }           
    return (html);
  }
}

export default MemoryLineChart;