import React from "react";
import Bootstrap from 'bootstrap/dist/css/bootstrap.css';


class ChartTitle extends React.Component {
  
  constructor(props) {
    super(props);
  }


  render() {              
	const divTitleChartStyle = {
      width: '100%',
      marginTop: '10px',
      marginLeft: '20px'
    };
    let html;
    html = (
        <div style={divTitleChartStyle}>
          <h4>{this.props.label}</h4>
        </div>
        )
    
    return (html);
  }
}

export default ChartTitle;