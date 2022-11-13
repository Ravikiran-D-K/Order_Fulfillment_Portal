import React, {useState,useEffect} from "react";
import EmployeeService from '../services/EmployeeService'
import 'bootstrap/dist/css/bootstrap.min.css';
import useDashBoard from "./DashBoard";


function Table({emp1,by1,some1,email,password}){
  const [orders, setOrders] = React.useState([])
const[x,setX]=React.useState()
  useEffect(()=>{
    if(emp1==='rno' || emp1==='ryes'){
        if(by1==='account'){
        EmployeeService.getByAccount(email,password,some1).then((res) => {
            setOrders(res.data);
            console.log(by1);
        });
        }
        else if(by1==='name'){
            EmployeeService.getByName(email,password,some1).then((res) => {
                setOrders(res.data);
                console.log(by1);
            });
        }
        else if(by1==='due_date'){
            EmployeeService.getByDate(email,password,some1).then((res) => {
                setOrders(res.data);
                console.log(by1);
            });
        }
    }
        console.log(some1)
        console.log(email)
        console.log(password)
  },[emp1,by1,some1,x])
       
  function handleSubmit(event) {
    event.preventDefault()
    console.log("haiii")
    setOrders([])
            EmployeeService.getByEmp(email,password).then((res) => {
                setOrders(res.data);
                if(x==='yes')
                setX('no')
                else
                setX('yes')
            });
        }

        return(
            <React.Fragment>
                <form  onSubmit={handleSubmit}>
                <button className="btn btn-primary mb-3" type="submit">Refresh</button>
                
                <div className = "row">
                        <table className = "table table-striped table-bordered table-responsive m-2">

                            <thead>
                                <tr>
                                    <th> Account</th>
                                    <th> Due Date</th>
                                    <th> Product ID</th>
                                    <th> Product Category</th>
                                    <th> Product Name</th>
                                    <th> Product Quantity</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    orders.map(
                                        orders => 
                                        <tr key = {orders.by1}>
                                             <td> {orders.account} </td>   
                                             <td> {orders.due_date}</td>
                                             <td> {orders.p_id}</td>
                                             <td> {orders.category}</td>
                                             <td> {orders.name}</td>
                                             <td> {orders.quantity}</td>
                                             
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>
                 </div>
                 </form>
            </React.Fragment>
        );
    }

export default Table;