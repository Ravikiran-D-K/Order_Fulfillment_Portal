import React from 'react';
import logo from './logo.svg';
import App1 from './App1'
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Table from './components/Table';
import DashBoard from './components/DashBoard';
import Login from './components/Login';
import Register from './components/Register';
import Upload from './components/Upload';
import {Navigate} from 'react-router-dom';
import { PrivateRoute } from './components/Login';

function App() {
  return (
    <div>
      
        <Router>
                <div className="container">
                    <Routes>
                          <Route path = "/dashboard" element = {<PrivateRoute><DashBoard/></PrivateRoute>}></Route>
                          <Route path = "/" element = {<App1/>}></Route>
                      </Routes>
                </div>
      
        </Router>
    </div>
  );
}

export default App;
