import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { loginApi } from "./api/authApi";

type LoginState = {
  loading: boolean;
  error: string | null;
  token: string | null;
};

type LoginData = {
  email: string;
  password: string;
}

export const loginAsync = createAsyncThunk(
  "auth/login",
  async (data: LoginData, { rejectWithValue }) => {
    let count = 0;
    while (count < 3) {
      try {
        const res = await loginApi(data.email, data.password);
        //lưu token vào localStorage
        if (res == null) {
          throw new Error("Login failed");
        }
        localStorage.setItem("token", (res as { token: string }).token);
        
        return (res as { token: string }).token;
      } catch (err: any) {
        count++;
      }
    }

    if (count === 3) {
      return rejectWithValue("Login failed after 3 attempts");
    }
  }
);

const initialState: LoginState = { loading: false, error: null, token: null };

const LoginSlice = createSlice({
  name: "login",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(loginAsync.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(loginAsync.fulfilled, (state, action) => {
        state.loading = false;
        state.token = action.payload || null;
      })
      .addCase(loginAsync.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload as string;
      });
  },
});

export default LoginSlice.reducer;