import React from 'react';
import logo from './logo.svg';
import './App.css';
import './components/tickets/AddTicket'
import AddTicket from './components/tickets/AddTicket';
import Navbar from './components/layout/Navbar';
import Home from './components/pages/Home';
import About from './components/pages/About';
import Contact from './components/pages/Contact';
import  "../node_modules/bootstrap/dist/css/bootstrap.css"
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import NotFound from './components/pages/NotFound';
import AddUser from './components/users/AddUser';
import EditUser from './components/users/EditUser';
import User from './components/users/User';
import ViewUser from './components/users/ViewUser';
import ViewTicket from './components/tickets/ViewTicket';
import EditTicket from './components/tickets/EditTicket';
import Ticket from './components/tickets/Ticket';
import UserInfo from './components/tickets/UserInfo';

function App() {
  return (
    <Router>
      <div className="App">
      <Navbar/>
      <Switch>
        <Route exact path="/" component={Home}/>
        <Route exact path="/viewusers" component={ViewUser}/>
        <Route exact path="/viewtickets" component={ViewTicket}/>
        <Route exact path="/about" component={About} />
        <Route exact path="/contact" component={Contact}/>
        <Route exact path="/users/add" component={AddUser}/>
        <Route exact path="/users/edit/:id" component={EditUser}/>
        <Route exact path="/users/:id" component={User}/>
        <Route exact path="/tickets/add" component={AddTicket}/>
        <Route exact path="/tickets/user/info/:mobile" component={UserInfo}/>
        <Route exact path="/tickets/edit/:id" component={EditTicket}/>
        <Route exact path="/tickets/:date/:time" component={Ticket}/>
        <Route component={NotFound}/>
      </Switch>
    </div>
    </Router>
  );
}

export default App;
