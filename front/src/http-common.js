import axios from "axios"

export default axios.create({
    //baseURL: "http://49.50.164.178:8080",
    baseURL: "http://localhost:8080",
    header:{
        "Content-type":"application/json",
    }
});