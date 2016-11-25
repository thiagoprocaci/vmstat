import React from "react";
import { Table } from 'react-bootstrap';
import TrPages from './TrPages.jsx';


class PagesTable extends React.Component {
  
  constructor(props) {
    super(props);
  }


  render() {      
    let html = (<div></div>);       
    if(this.props.pagesStatusList && this.props.pagesStatusList.length > 0 && this.props.perspective === 'pages') {
      
      let mappedTr = this.props.pagesStatusList.map(p =>  <TrPages page={p} key={p.date} />)   
      
      html = (
        <div>
          <Table responsive>
            <thead>
              <tr>
                <th>Date</th>
                <th>Machine</th>
                <th>Pages Paged In</th>
                <th>Pages Paged Out</th>
                <th>Pages Swapped In</th>
                <th>Pages Swapped Out</th>                
              </tr>
            </thead>       
             <tbody>
             {mappedTr}
            </tbody>
          </Table>
          
        </div>
        )
    }           
    return (html);
  }
}

export default PagesTable;