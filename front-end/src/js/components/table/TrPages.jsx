import React from "react";


class TrPages extends React.Component {
  
  constructor(props) {
    super(props);
  }


  render() {      
    

    let html;            
      html = (
        <tr>                                
            <td>{this.props.page.date}</td>
            <td>{this.props.page.ipRunnerMachine}</td>
            <td>{this.props.page.pagesPagedIn}</td>
            <td>{this.props.page.pagesPagedOut}</td>
            <td>{this.props.page.pagesSwappedIn}</td>            
            <td>{this.props.page.pagesSwappedOut}</td>            
        </tr>
      )    
    return (html);
  }
}

export default TrPages;