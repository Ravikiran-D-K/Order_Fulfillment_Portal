import React, {Component} from "react";
import EmployeeService from '../services/EmployeeService'
import 'bootstrap/dist/css/bootstrap.min.css';
import Upload from "./Upload";
import Email from "./Upload";
import Pass from "./Upload";
import useReports from "./useReports";
import Table from "./Table";
import { useNavigate,useParams,useLocation } from "react-router-dom";


function DashBoard(props){
    const mystyle = {
        color: "black",
        backgroundColor: "lightgrey",
        padding: "5px",
        fontFamily: "Arial"
      };
    let navigate = useNavigate();
    const location = useLocation();
    const {render,emp1,by1,some1}=useReports()
    // const {email,password}=useParams()

    let email=location.state.email;
    let password=location.state.password;



        return(
            <React.Fragment>
                {/* <div>
                 <h5 style={mystyle}class="card-title">{email}</h5>
                </div> */}
                <div className="row">
                <div>
                     <Upload {...{email,password}} />
                </div>
                <div>
                    {render}
                </div>
                
                </div>
                
                <div>
                    <Table {...{emp1,by1,some1,email,password}}
                     ></Table>
                </div>
                
            </React.Fragment>
        );
}

export default DashBoard;