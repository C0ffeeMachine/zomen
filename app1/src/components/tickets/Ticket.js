import React,{useState,useEffect} from 'react'
import { useParams } from 'react-router-dom'
import axios from 'axios'


function Ticket() {

    const {date,time} = useParams()
    const [tickets,setTicket] = useState([])

    useEffect(()=>{
        loadTicket()
    },[])

    //http://localhost:3005/ticket?bookedDate=2020-08-31&movieTime=10:20:00
    const loadTicket = ()=>{
        axios.get("/tickets/mt/"+date+"/"+time) //"http://localhost:3005/ticket?bookedDate="+date+"&movieTime="+time
        .then(res=>{
            setTicket(res.data)
        })
    }

    return (
        <div className="container">
        <div className="py-4">
            <h1>Tickets for Date: {date} and Time: {time}</h1>
            <table className="table border shadow">
                <thead className="thead-dark">
                    <tr>
                    <th scope="col">Id</th>
                    <th scope="col">User Name</th>
                    <th scope="col">Mobile Number</th>
                    <th scope="col">Booked Date</th>
                    <th scope="col">Movie Time</th>
                    <th scope="col">Status</th>
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
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    </div>
    )
}

export default Ticket
