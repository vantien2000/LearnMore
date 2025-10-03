import api from "../../../api/axiosClient";

const LOGIN_URL = import.meta.env.VITE_LOGIN_URL;

console.log("LOGIN_URL:", LOGIN_URL);

export const loginApi = async (email: string, password: string) => {
  const response = await 
  api.post(`${LOGIN_URL}`, { email, password }, { withCredentials: true });
  return response.data;
};