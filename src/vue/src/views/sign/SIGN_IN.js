import axios from 'axios'

export default {

}
const getUserInfo = (userEmail, loginPw, remember) => {
    const req = {
        'email': userEmail,
        'password': loginPw,
        'remember': remember
    }

    let severUrl = '//localhost:9922'

    return axios.post(severUrl + '/user/sign-in', req, {
        headers: {
            'Content-type': 'application/json'
        }
    })
}