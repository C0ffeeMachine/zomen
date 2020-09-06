import React,{useState,useEffect} from 'react'
import { useParams } from 'react-router-dom'
import axios from 'axios'


function UserInfo() {

    const [users,setUser] = useState([])
    const {mobile} = useParams()

    useEffect(()=>{
        axios.get("http://localhost:8080/users/info/"+mobile) //http://localhost:3005/users?mobNumber=
        .then((res) => {
            setUser(res.data)
            console.log(res.data)
        })
    },[])

    return (
        <div className="container py-4">
            
                    <div key={users.id}>
                        <h1 className="display-4">User Id:  {users.id}</h1>
                        <hr />
                        <ul className="list-group w-50">
                            <li className="list-group-item">name: {users.name}</li>
                            <li className="list-group-item">mobile number: {users.mobNumber}</li>
                            <li className="list-group-item">email: {users.emailId}</li>
                        </ul>
                    </div>
                
            
        </div>
    )
}

export default UserInfo
