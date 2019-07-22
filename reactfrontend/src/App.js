import React, {Component} from 'react';
import './App.css';

class App extends Component {
  state = {
    isLoading : true,
    numberAccounts : 0,
    numberTransactions : 0
  }

  async componentDidMount(){
    const responseAccounts = await fetch('/api/get_all_accounts');
    const bodyAccounts = await responseAccounts.json();
    const responseTransactions = await fetch('/api/get_all_accounts');
    const bodyTransactions = await responseTransactions.json();
    this.setState({numberAccounts: bodyAccounts, numberTransactions: bodyTransactions, isLoading:false});
  }

  async clickHandler(){
    let response = await fetch(
      'api/add', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }, body: JSON.stringify({
          custId: 1,
          amount: 0,
        })
      }
    );
    response = await fetch('/api/get_all_accounts');
    const body = await response.json();
    this.setState({numberAccounts: body, isLoading:false});
    console.log(response);
  }

  render (){
    const {isLoading, numberAccounts, numberTransactions} = this.state;
    if(isLoading){
      return <p>Loading...</p>;
    }

    return(
      <div className="App">
        <header className="App-header">
          <div className="App-intro">
            <h2>User Number: {numberAccounts}</h2>
          </div>
          <div className="App-intro">
            <h2>Transaction Number: {numberTransactions}</h2>
          </div>
          <button onClick={()=>this.clickHandler()}>Press me</button>

          <form>
            <label>
              Customer:
            </label>
            <input type="text" name="name" />
            <input type="submit" value="Submit" />
          </form>
        </header>
      </div>
    )
  }
}

export default App;
