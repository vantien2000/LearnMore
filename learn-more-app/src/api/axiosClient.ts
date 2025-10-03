import { jwtDecode, JwtPayload } from "jwt-decode";
import axios from "axios";
// axios instance
const api = axios.create({
  baseURL: import.meta.env.VITE_BASE_URL,
  withCredentials: true,
});

// You can add interceptors here if needed
function isTokenExpired(token: string): boolean {
  try {
    const jwtDecoded = jwtDecode<JwtPayload>(token);
    const now = Date.now() / 1000;
    if (jwtDecoded.exp === undefined) {
      return false; // Token không có exp, coi như không hết hạn
    }
    return jwtDecoded.exp < now; // in seconds
  } catch (e) {
    return true; // Nếu không thể decode, coi như token không hợp lệ (hết hạn)
  }
};

async function callRefreshToken(): Promise<string> {
  const res = await api.post("/auth/refresh");
  const data = res.data as { accessToken: string };
  return data.accessToken;
}

api.interceptors.request.use(
  async (config) => {
    let token = localStorage.getItem("token");
    if (token && isTokenExpired(token)) {
      try {
        token = await callRefreshToken();
        localStorage.setItem("token", token);
        console.log("Token refreshed");
      } catch (error) {
        console.error("Error refreshing token:", error);
      }
    }
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// Response interceptor: handle 401
api.interceptors.response.use(
  (response) => response,
  async (error) => {
    const originalRequest = error.config;

    if (error.response?.status === 401 && !originalRequest._retry) {
      originalRequest._retry = true;
      try {
        const newToken = await callRefreshToken();
        localStorage.setItem("accessToken", newToken);
        api.defaults.headers.common.Authorization = `Bearer ${newToken}`;
        originalRequest.headers.Authorization = `Bearer ${newToken}`;
        return api(originalRequest); // retry request cũ
      } catch (err) {
        localStorage.removeItem("accessToken");
        window.location.href = "/login"; // redirect về login
      }
    }

    return Promise.reject(error);
  }
);

export default api;