import axios, { AxiosInstance, AxiosRequestConfig, AxiosResponse } from "axios";
// import { ElMessage } from "element-plus";

export interface ResponseData {
  code: number;
  data?: any;
  message: string;
}

//let service: AxiosInstance | any;
const service = axios.create({
    baseURL: "/",
    timeout: 50000
  });

// if (import.meta.env.MODE === "development") {
//   service = axios.create({
//     baseURL: "/api", 
//     timeout: 50000 
//   });
// } else {
//   service = axios.create({
//     baseURL: "/api",
//     timeout: 50000
//   });
// }

service.interceptors.request.use(
  (config: AxiosRequestConfig) => {
    return config;
  },
  (error: any) => {
    console.error("error:", error); 
    Promise.reject(error);
  }
);

service.interceptors.response.use(
  (res: AxiosResponse) => {
    // Some example codes here:
    // code == 0: success
    if (res.status === 200) {
        const data: ResponseData = res.data
        //console.log("JSONJSON: "+JSON.stringify(data.data));
        //console.log("data.code: "+data.code);
        //if (data.code === 0) {
          
          return data.data;
        //} 
        // else {
        //   ElMessage({
        //     message: data.message,
        //     type: "error"
        //   });
        // }
      } 
      else {
        // ElMessage({
        //   message: "Network Error!",
        //   type: "error"
        // });
        return Promise.reject(new Error(res.data.message || "Error"));
      }
    // if (res.status === 200) {
    //   const data: ResponseData = res.data
    //   if (data.code === 0) {
    //     return data.data;
    //   } else {
    //     ElMessage({
    //       message: data.message,
    //       type: "error"
    //     });
    //   }
    // } else {
    //   ElMessage({
    //     message: "Network Error!",
    //     type: "error"
    //   });
    //   return Promise.reject(new Error(res.data.message || "Error"));
    // }
  },
  (error: any) => Promise.reject(error)
);

export default service;