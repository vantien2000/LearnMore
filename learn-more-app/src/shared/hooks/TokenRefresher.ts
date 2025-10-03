import { createAsyncThunk } from "@reduxjs/toolkit";
import { jwtDecode, JwtPayload } from "jwt-decode";
import { useEffect } from "react";
import api from "../../api/axiosClient";

export function useTokenRefresher() {
  useEffect(() => {
    const token = localStorage.getItem("token");
    if (!token) return;
    try {
      const jwtDecoded = jwtDecode<JwtPayload>(token);
      let now = Date.now() / 1000;
      if (jwtDecoded.exp === undefined) return;
      if (jwtDecoded.exp < now) return; // Token đã hết hạn
      let timeToExpiry = jwtDecoded.exp - now;
      // Cài đặt interval để refresh token trước khi nó hết hạn
      // Refresh trước 1 phút
      if (timeToExpiry > 60) {
        const timer = setTimeout(() => {
          try {
            createAsyncThunk("auth/refresh", async () => {
              const res = await api.post('auth/refresh');
              localStorage.setItem("token", (res.data as { accessToken: string }).accessToken);
              console.log("Token refreshed");
            });
          } catch (error) {
            console.error("Error refreshing token:", error);
            localStorage.removeItem("token");
          } 
        }, (timeToExpiry - 60) * 1000);
        return () => clearTimeout(timer);
      } 
    } catch (e) {
      console.error("Invalid token:", e);
    }
  }, []);
}