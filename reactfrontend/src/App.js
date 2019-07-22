import React, {Component} from 'react';
import './App.css';
import Select from "react-select";
import {getAllAccounts, getAllTransactions, addAccount, getAllCustomers} from './utils/BackendCalls';
import 'bootstrap/dist/css/bootstrap.min.css';

class App extends Component {
  state = {
    isLoading : true,
    numberAccounts : 0,
    numberTransactions : 0,
    customers: [],
    selectedCustomer: undefined,
    amount: 0
  }

  async componentDidMount(){
    const bodyAccounts = await getAllAccounts();
    const bodyTransactions = await getAllTransactions();
    const customers = await getAllCustomers();
    this.setState({
      numberAccounts: bodyAccounts, 
      numberTransactions: bodyTransactions, 
      customers: customers,
      isLoading:false});
  }

  submitHandler = async (event) => {
    event.preventDefault();
    addAccount({
      custId: this.state.selectedCustomer.value, 
      amount: this.state.amount});
    const bodyAccounts = await getAllAccounts();
    const bodyTransactions = await getAllTransactions();
    this.setState({numberAccounts: bodyAccounts, numberTransactions: bodyTransactions});
  }
  selectHandler = (event) => {
    this.setState({selectedCustomer: {value:event.value, label:event.label}});
  };
  changeAmountHandler = (event) => this.setState({amount: event.target.value});

  render (){
    const {isLoading, customers} = this.state;
    const renderCust = [];
    customers.forEach(customer=>renderCust.push({label:customer.name, value:customer.id}));
    
    if(isLoading){
      return <p>Loading...</p>;
    }

    return(
      <div className="container">
        <div className="row">
          <h2>Create account:</h2>
        </div>
        <div className="row">
          <form className="col-md-4" onSubmit={this.submitHandler}>
            <label>Customer: </label>
            <Select placeholder="Select Customer"
                    value={this.state.selectedCustomer} 
                    onChange={this.selectHandler}
                    options={renderCust}/>
            <label>Amount: </label><br/>
            <input placeholder="Insert Initial Amount" 
                   type="number" 
                   min="0"
                   onChange={this.changeAmountHandler}></input>
            <br/>
            <input type="submit"/>
          </form>
        </div>
      </div>
    )
  }
}

export default App;
