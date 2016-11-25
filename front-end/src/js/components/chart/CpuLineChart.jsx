import React from "react";
import {LineChart, BarChart, Bar, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend} from 'recharts';
import ChartTitle from './ChartTitle.jsx';


class CpuLineChart extends React.Component {
  
  constructor(props) {
    super(props);
  }


  render() {      
    let html = (<div></div>);       
    if(this.props.cpuStatusList && this.props.cpuStatusList.length > 0 && this.props.perspective === 'cpu') {
      html = (
        <div>
          <ChartTitle label="CPU Ticks"></ChartTitle>          
          <BarChart margin={{ top: 5, right: 30, left: 20, bottom: 5 }} width={800} height={600} data={this.props.cpuStatusList}>
                 <XAxis dataKey="date" padding={{left: 30, right: 30}}/>
                 <YAxis/>
                 <CartesianGrid strokeDasharray="3 3"/>
                 <Tooltip/>
                 <Legend />
                 <Bar  dataKey="nonNiceUserCpuTicks" name="Non-nice User Cpu Ticks" fill="#8884d8" />
                 <Bar  dataKey="niceUserCpuTicks" name="Nice User Cpu Ticks" fill="#82ca9d"  />
                 <Bar  dataKey="systemCpuTicks" name="System Cpu Ticks" fill="#ff0000"  />
                 <Bar  dataKey="idleCpuTicks" name="Idle Cpu Ticks" fill="#000099"  />       
                 <Bar  dataKey="ioWaitCpuTicks" name="IO Wait Cpu Ticks" fill="#00cc00"  />
                 <Bar  dataKey="irqCpuTicks" name="IRQ Cpu Ticks" fill="#bf00ff"  />
                 <Bar  dataKey="softirqCpuTicks" name="Softirq Cpu Ticks" fill="#ff00ff"  />
                 <Bar  dataKey="stolenCpuTicks" name="Stolen Cpu Ticks" fill="#ff8000"  />
            </BarChart>
        </div>
        )
    }           
    return (html);
  }
}

export default CpuLineChart;