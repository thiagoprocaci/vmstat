import React from "react";
import { connect } from "react-redux"

import MachineSelector from './MachineSelector.jsx';
import MemoryLineChart from './chart/MemoryLineChart.jsx';
import CpuLineChart from './chart/CpuLineChart.jsx';
import PagesLineChart from './chart/PagesLineChart.jsx';

import MemoryTable from './table/MemoryTable.jsx';

import PerspectiveSelector from './PerspectiveSelector.jsx';



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
     this.state = {
    	perspective: "memory",
    	machineSelected: false
  	};
  }

  componentWillMount() {    
    this.props.dispatch(getMachineList())     
    this.props.dispatch(getAuditList(null))  
  }

  selectMachine(machine) {  		
	this.props.dispatch(getAuditList(machine)) 
	if(machine) {
		this.setState({perspective: this.state.perspective, machineSelected : true});  	
	} else {
		this.setState({perspective: "memory", machineSelected : false});  	
	}   	  	
  }

  clickPerspective(val) {
  	this.setState({perspective: val, machineSelected : this.state.machineSelected});  	
  }

  render() { 

	const { machineList, memoryStatusList, pagesStatusList, cpuStatusList  } = this.props;				
	const { perspective, machineSelected  } = this.state;	
	
	let html;	
	html =  (<div>	
				<MachineSelector machineList={machineList} onSelectMachine={this.selectMachine.bind(this)} />		  	
				<PerspectiveSelector onClickPerspective={this.clickPerspective.bind(this)} display={machineSelected} />			  				  	
				<MemoryLineChart memoryStatusList={memoryStatusList} perspective={perspective}></MemoryLineChart>			    
				<CpuLineChart cpuStatusList={cpuStatusList} perspective={perspective}></CpuLineChart>			    
				<PagesLineChart pagesStatusList={pagesStatusList} perspective={perspective}></PagesLineChart>			    
				<MemoryTable memoryStatusList={memoryStatusList} perspective={perspective}></MemoryTable>		    

			    	    			    			    
			  </div> 
		    )
	
  	return ( <div>{ html }</div>)
  }
}

export default VmstatCharts;