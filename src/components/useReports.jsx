import React, {Component} from "react";
import EmployeeService from '../services/EmployeeService'
import 'bootstrap/dist/css/bootstrap.min.css';
import { useHistory } from "react-router-dom"; 

function useReports(props){
 
    const [by1, setBy1] = React.useState();
    const [some1, setSome1] = React.useState();
    const [emp1,setEmp1]=React.useState();

    const mystyle = {
        padding: "5px"
      };

    function handleChange(event,text) {
        event.preventDefault()
        setSome1(event.target.value);
        setBy1(text);
        console.log(by1)
        console.log(event.target.value)
        event=null;
        text=null;
      }

      function handleSubmit(event){
        event.preventDefault()
        if(emp1!='rno')
        setEmp1("rno")
        else
        setEmp1("ryes")
        //props.handle2("no",by1,some1);
        
       // history.push({pathname:'/table',state: {by:by,some:some }});
        console.log(event.target.dataset.somefield)
      }
    

    return{
      emp1,by1,some1,
      render:(
        <form data-somefield={by1} 
        onSubmit={handleSubmit}
        >
            <div className="row">
                <div className=" col-md-3 mb-3">
                <br></br><input type="text" placeholder="Account" onChange={e=>handleChange(e,"account")} /><br></br>
                <br></br> <button className="btn btn-secondary mb-3" type="submit" value="account">Order Report By Account</button>
                </div>
                <div className="col-sm-3">
                <br></br><input type="text" placeholder="Name" onChange={e=>handleChange(e,"name")} /><br></br>
                <br></br><button className="btn btn-secondary mb-3" type="submit" value="name">Order Report By Name</button>   
                </div>
                <div className="col-sm-3">
                <br></br><input type="date" placeholder="dd-mm-yyyy" onChange={e=>handleChange(e,"due_date")} /><br></br>
                <br></br><button className="btn btn-secondary mb-3" type="submit" value="due_date">Order Report By Date</button>   
                </div>
            </div>
        </form>
    )}

}

export default useReports;
