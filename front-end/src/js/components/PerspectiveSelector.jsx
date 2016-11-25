import React from "react";
import { ButtonToolbar, Button } from 'react-bootstrap';

class PerspectiveSelector extends React.Component {
  
  constructor(props) {
    super(props);    
  }   

  clickPerspective(val) {  
    this.props.onClickPerspective(val)    
  }

  render() {     
    const divPerspectiveStyle = {
      width: '150px',
      marginLeft: '20px'
    };    
          
    let html = (<div></div>);       
    if(this.props.display) {   
      html = (
        <div style={divPerspectiveStyle}>
            <ButtonToolbar>
              <Button bsStyle="primary" onClick={this.clickPerspective.bind(this, 'memory')}>Memory</Button>
              <Button bsStyle="success" onClick={this.clickPerspective.bind(this, 'cpu')}>CPU</Button>
              <Button bsStyle="warning" onClick={this.clickPerspective.bind(this, 'pages')}>Pages</Button>
            </ButtonToolbar>
        </div>
      )    
    }
    return (html);
  }
}

export default PerspectiveSelector;