import React from "react";
import {LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend} from 'recharts';
import ChartTitle from './ChartTitle.jsx';

class PagesLineChart extends React.Component {
  
  constructor(props) {
    super(props);
  }


  render() {      
    let html = (<div></div>);       
    if(this.props.pagesStatusList && this.props.pagesStatusList.length > 0 && this.props.perspective === 'pages') {
      html = (
        <div>
          <ChartTitle label="Pages"></ChartTitle>          
          <LineChart margin={{ top: 5, right: 30, left: 20, bottom: 5 }} width={800} height={600} data={this.props.pagesStatusList}>
                 <XAxis dataKey="date" padding={{left: 30, right: 30}}/>
                 <YAxis/>
                 <CartesianGrid strokeDasharray="3 3"/>
                 <Tooltip/>
                 <Legend />
                 <Line type="monotone" dataKey="pagesPagedIn" name="Pages Paged In" stroke="#8884d8" activeDot={{r: 8}}/>
                 <Line type="monotone" dataKey="pagesPagedOut" name="Pages Paged Out" stroke="#82ca9d" activeDot={{r: 7}} />
                 <Line type="monotone" dataKey="pagesSwappedIn" name="Pages Swapped In" stroke="#ff0000" activeDot={{r: 6}} />
                 <Line type="monotone" dataKey="pagesSwappedOut" name="Pages Swapped Out" stroke="#000099" activeDot={{r: 5}} />                        
            </LineChart>
        </div>
        )
    }           
    return (html);
  }
}

export default PagesLineChart;