import React ,{useState,useEffect} from 'react'
import axios from 'axios'
import  {useParams,useHistory} from 'react-router-dom'

const initialState = {
    id: 0,
    userName: "",
    mobNumber: "",
    bookedDate: "",
    movieTime: "",
    status: 0 
}

// function reducer(state,{field,value}) {
//     return{
//         ...state,
//         [field]:value
//     }
// }

function EditTicket() {

    let history =useHistory()
    //const [state,dispatch] = useReducer(reducer,initialState)
    const [ticket,setTicket] = useState(initialState)
    const {id} = useParams()

    useEffect(()=>{
        loadTicket()
    },[])

    const loadTicket = ()=>{
        axios.get("/tickets/"+id) //"http://localhost:3005/ticket/"
        .then(res=>{
            setTicket(res.data)
        })
    }

    const onChange = (e) => {
        //dispatch({ field:e.target.name, value:e.target.value })
        setTicket({
            ...ticket,
            [e.target.name]:e.target.value
        })
    }

    const onSubmit = (e) =>{
        e.preventDefault()
        axios.put("/tickets/"+id,ticket)
        .then(res=>{
            console.log(res.data)
            history.push("/viewtickets")
        })
    }

    return (
        <div className="container">
            <div className="w-75 mx-auto shadow p-5">
                    <h2 className="text-center mb-4">Edit Ticket</h2>
            <form onSubmit={onSubmit}>
            <div className="form-group">
                <input type="text" className="form-control form-control-lg"  placeholder="Enter your Name" name="userName" value={ticket.userName} onChange={onChange}/>
            </div>
            <div className="form-group">
                <input type="text" className="form-control form-control-lg"  placeholder="Enter your Mobile Number" name="mobNumber" value={ticket.mobNumber} onChange={onChange}/>
            </div>
            <div className="form-group">
                <input type="text" className="form-control form-control-lg"  placeholder="Enter Date yyyy-mm-dd" name="bookedDate" value={ticket.bookedDate} onChange={onChange}/>
            </div>
            <div className="form-group">
                <input type="text" className="form-control form-control-lg"  placeholder="Enter Time hh:mm:ss in 24hr format" name="movieTime" value={ticket.movieTime} onChange={onChange}/>
            </div>
            <button className="btn btn-warning btn-block">Update Ticket</button>
            </form>
            </div>
        </div>
    )
}

export default EditTicket
