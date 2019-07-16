import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  state = {
    isLoading : true,
    numbers : 0
  }

  async componentDidMount(){
    const response = await fetch('/api/get_all');
    const body = await response.json();
    this.setState({numbers: body, isLoading:false});
  }

  render (){
    const {isLoading, numbers} = this.state;
    if(isLoading){
      return <p>Loading...</p>;
    }

    return(
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div className="App-intro">
            <h2>User Number: {numbers}</h2>
          </div>
        </header>
      </div>
    )
  }
}

export default App;
