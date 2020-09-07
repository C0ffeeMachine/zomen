import React,{useState,useEffect} from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'



function ViewTicket() {

    const [tickets,setTicket]= useState([])

    useEffect(()=>{
        axios.get("/tickets")  //http://localhost:3005/ticket
        .then(res =>{
            console.log(res.data)
            setTicket(res.data)
        })
    },[])

    const loadTicket = () =>{
        axios.get("/tickets")  //http://localhost:3005/ticket
        .then(res =>{
            setTicket(res.data)
        })
    }

    const deleteUser = id =>{
        axios.delete("/tickets/"+id) //http://localhost:3005/ticket/
        .then(res=>{
            loadTicket();
        })
    }



    return (
        <div className="container">
            <div className="py-4">
                <h1>View Tickets</h1>
                <table className="table border shadow">
                    <thead className="thead-dark">
                        <tr>
                        <th scope="col">Id</th>
                        <th scope="col">User Name</th>
                        <th scope="col">Mobile Number</th>
                        <th scope="col">Booked Date</th>
                        <th scope="col">Movie Time</th>
                        <th scope="col">Status</th>
                        <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            tickets.map((ticket)=>(
                                <tr key={ticket.id}>
                                    <th scope="row">{ticket.id}</th>
                                    <td>{ticket.userName}</td>
                                    <td>{ticket.mobNumber}</td>
                                    <td>{ticket.bookedDate}</td>
                                    <td>{ticket.movieTime}</td>
                                    <td>{ticket.status}</td>
                                    <td> 
                                        <Link className="btn btn-primary mr-2"  to={`/tickets/${ticket.bookedDate}/${ticket.movieTime}`}>View</Link>
                                        <Link className="btn btn-outline-primary mr-2"  to={`/tickets/user/info/${ticket.mobNumber}`}>User info</Link>
                                        <Link className="btn btn-outline-primary mr-2"  to={`/tickets/edit/${ticket.id}`}>Edit</Link>
                                        <Link className="btn btn-danger mr-2" onClick={()=>deleteUser(ticket.id)}>Delete</Link>
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default ViewTicket
