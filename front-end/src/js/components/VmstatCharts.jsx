import React from "react";
import { connect } from "react-redux"
import {LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend} from 'recharts';

import MachineSelector from './MachineSelector.jsx';
import { getAuditList } from "../actions/auditActions";
import { getMachineList } from "../actions/machineActions";

@connect((store) => {
  return {
    auditList: store.audit.auditList,
    machineList: store.machine.machineList
  };
})

class VmstatCharts extends React.Component {


  componentWillMount() {
    this.props.dispatch(getAuditList())
    this.props.dispatch(getMachineList())   
  }

  selectMachine(a) {  	
  	console.log(a)
  }

  render() {	 

	const { auditList, machineList  } = this.props;		
  	return (
  	<div>
	  	<div>
	  		<MachineSelector machineList={machineList} onSelectMachine={this.selectMachine} />
	  	</div>
	  	<div>
			<LineChart width={800} height={600} data={auditList}>
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
    </div>
    );
  }
}


export default VmstatCharts;