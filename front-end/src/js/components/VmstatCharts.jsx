import React from "react";
import { connect } from "react-redux"

import MachineSelector from './MachineSelector.jsx';
import MemoryLineChart from './chart/MemoryLineChart.jsx';


import { getAuditList } from "../actions/auditActions";
import { getMachineList } from "../actions/machineActions";

@connect((store) => {
  return {
    auditList: store.audit.auditList,
    machineList: store.machine.machineList
  };
})
class VmstatCharts extends React.Component {
  
  constructor(props) {
    super(props);
  }

  componentWillMount() {    
    this.props.dispatch(getMachineList())      
  }

  selectMachine(machine) {  		
	this.props.dispatch(getAuditList(machine))    	  	
  }

  render() { 
	const { machineList, auditList  } = this.props;			
	
	let html;	
	html =  (<div>			  	
			  	<div>
			  		<MachineSelector machineList={machineList} onSelectMachine={this.selectMachine.bind(this)} />
			  	</div>
			  	<div>
					<MemoryLineChart auditList={auditList}></MemoryLineChart>
			    </div>			    			    			    
			  </div> 
		    )
	
  	return ( <div>{ html }</div>)
  }
}

export default VmstatCharts;