import React from 'react'
import { Link } from 'react-router-dom'



function Home() {

    return (
        <div className="container">
            <div className="py-4">
                <h1>Home page</h1>
                <Link className="btn btn-primary mr-2" to="/viewusers">View User</Link>
                <Link className="btn btn-outline-primary mr-2" to="/viewtickets">View Ticket</Link>
            </div>
        </div>
    )
}

export default Home
