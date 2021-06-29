import React from 'react';
import './App.css';
import{BrowserRouter as Router,Switch,Route}from 'react-router-dom';
import  Header from './Components/Header'
import Home from './Components/Home'
import Checkout from './Components/Checkout';
import Login from './Components/Login';
function App() {
  return (
    <Router>
    <div className="app">


       <Switch>
      <Route path="/checkout">
      < Header/>
      <Checkout/>
    
      </Route>
      <Route path="/login">
        <Login/>
      </Route>
      <Route path="/"> {/* this one is default*/}
        < Header/>
        <Home/>
        
      </Route>
      </Switch>
    
 
    </div>
    </Router>
  );

  {

  }
  {

  }
  {
    
  }
}

export default App;
