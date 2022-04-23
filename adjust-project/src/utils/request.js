import axios from 'axios'

const request = axios.create({
    baseURL:'http://52i13683m0.zicp.vip/adjust/',
    timeout:5000
})

export default request