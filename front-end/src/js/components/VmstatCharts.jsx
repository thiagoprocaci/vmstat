import React from "react";
import { connect } from "react-redux"

import MachineSelector from './MachineSelector.jsx';
import MemoryLineChart from './chart/MemoryLineChart.jsx';
import CpuLineChart from './chart/CpuLineChart.jsx';
import PagesLineChart from './chart/PagesLineChart.jsx';


import { getAuditList } from "../actions/auditActions";
import { getMachineList } from "../actions/machineActions";

@connect((store) => {
  return {
    memoryStatusList: store.audit.memoryStatusList,
    pagesStatusList: store.audit.pagesStatusList,
    cpuStatusList: store.audit.cpuStatusList,
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
	const { machineList, memoryStatusList, pagesStatusList, cpuStatusList  } = this.props;			
	
	let html;	
	html =  (<div>			  	
			  	<div>
			  		<MachineSelector machineList={machineList} onSelectMachine={this.selectMachine.bind(this)} />
			  	</div>
			  	<div>
					<MemoryLineChart memoryStatusList={memoryStatusList}></MemoryLineChart>
			    </div>		
			    <div>
					<CpuLineChart cpuStatusList={cpuStatusList}></CpuLineChart>
			    </div>		
			    <div>
					<PagesLineChart pagesStatusList={pagesStatusList}></PagesLineChart>
			    </div>

			    	    			    			    
			  </div> 
		    )
	
  	return ( <div>{ html }</div>)
  }
}

export default VmstatCharts;