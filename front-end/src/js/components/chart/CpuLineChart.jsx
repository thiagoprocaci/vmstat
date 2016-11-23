import React from "react";
import Bootstrap from 'bootstrap/dist/css/bootstrap.css';
import {LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend} from 'recharts';

class CpuLineChart extends React.Component {
  
  constructor(props) {
    super(props);
  }


  render() {      
    let html = (<div></div>);       
    if(this.props.cpuStatusList && this.props.cpuStatusList.length > 0) {
      html = (
        <div>
          CPU Ticks
          <LineChart width={800} height={600} data={this.props.cpuStatusList}>
                 <XAxis dataKey="date" padding={{left: 30, right: 30}}/>
                 <YAxis/>
                 <CartesianGrid strokeDasharray="3 3"/>
                 <Tooltip/>
                 <Legend />
                 <Line type="monotone" dataKey="nonNiceUserCpuTicks" name="Non-nice User Cpu Ticks" stroke="#8884d8" activeDot={{r: 8}}/>
                 <Line type="monotone" dataKey="niceUserCpuTicks" name="Nice User Cpu Ticks" stroke="#82ca9d" activeDot={{r: 7}} />
                 <Line type="monotone" dataKey="systemCpuTicks" name="System Cpu Ticks" stroke="#ff0000" activeDot={{r: 6}} />
                 <Line type="monotone" dataKey="idleCpuTicks" name="Idle Cpu Ticks" stroke="#000099" activeDot={{r: 5}} />       
                 <Line type="monotone" dataKey="ioWaitCpuTicks" name="IO Wait Cpu Ticks" stroke="#00cc00" activeDot={{r: 3}} />
                 <Line type="monotone" dataKey="irqCpuTicks" name="IRQ Cpu Ticks" stroke="#333300" activeDot={{r: 2}} />
                 <Line type="monotone" dataKey="softirqCpuTicks" name="Softirq Cpu Ticks" stroke="#333300" activeDot={{r: 1}} />
                 <Line type="monotone" dataKey="stolenCpuTicks" name="Stolen Cpu Ticks" stroke="#333300"  />
            </LineChart>
        </div>
        )
    }           
    return (html);
  }
}

export default CpuLineChart;