import Axios from "axios";

export const axios = Axios.create({ 
    baseURL: "https://cors-anywhere.herokuapp.com/"+"http://localhost:8080",
    headers: {
        "Content-type": "application/json"
    }
});
