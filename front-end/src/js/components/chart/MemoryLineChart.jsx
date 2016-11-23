import React from "react";
import Bootstrap from 'bootstrap/dist/css/bootstrap.css';
import {LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend} from 'recharts';

class MemoryLineChart extends React.Component {
  
  constructor(props) {
    super(props);
  }


  render() {      
    let html = (<div></div>);       
    if(this.props.memoryStatusList && this.props.memoryStatusList.length > 0) {
      html = (
        <div>
          Memory Chart (GB)
          <LineChart width={800} height={600} data={this.props.memoryStatusList}>
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