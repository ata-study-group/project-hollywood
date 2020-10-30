import Axios from "axios";

export const axios = Axios.create({
    baseURL: "http://cinerama-env-2.eba-h2nnwj3t.us-west-2.elasticbeanstalk.com/api/",
    headers: {
        "Content-type": "application/json"
    }
});